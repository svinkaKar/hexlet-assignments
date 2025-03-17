package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// BEGIN
public class Validator {

    public static List<String> validate(Object object) {
        List<String> nullableFields = new ArrayList<>();
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(object) == null) {
                        nullableFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return nullableFields;
    }

    public static Map<String, List<String>> advancedValidate(Object object) {
        Map<String, List<String>> notValideFields = new HashMap<>();
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        List<String> nullableFields = validate(object);
        for (String field : nullableFields) {
            notValideFields.put(field, List.of("can not be null"));
        }

        for(Field field : fields) {
            field.setAccessible(true);
            String value;
            try {
                value = (String) field.get(object);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                int annotationLength = field.getAnnotation(MinLength.class).minLength();
                if (value.length() < annotationLength) {
                    String fieldName = field.getName();
                    if (notValideFields.containsKey(fieldName)) {
                        List<String> valueList = notValideFields.get(fieldName);
                        valueList.forEach(v -> valueList.add(String.valueOf(notValideFields.get(fieldName))));
                        valueList.add(String.format("length less than %d", annotationLength));
                        notValideFields.put(fieldName, valueList);
                    } else {
                        notValideFields.put(fieldName, List.of(String.format("length less than %d", annotationLength)));
                    }
                }
            }
        }
        return notValideFields;
    }
}

// END
