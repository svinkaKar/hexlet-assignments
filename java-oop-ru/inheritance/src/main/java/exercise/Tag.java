package exercise;

import java.util.stream.Collectors;
import java.util.Map;
import lombok.Getter;

import java.util.LinkedHashMap;

// BEGIN
@Getter
public class Tag {

    private String nameTag;
    private Map<String, String> atributesTag;

    public Tag(String nameTag, Map<String, String> atributesTag) {
        this.nameTag = nameTag;
        this.atributesTag = atributesTag;
    }

    public String getAtributes(String nameTag, Map<String, String> atributesTag) {
        Map<String, String> newMap = new LinkedHashMap<>();
        atributesTag.forEach((key, value) -> newMap.put(key, String.format("=\"%s\"", value)));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<%s", nameTag));
        newMap.forEach((key, value) -> sb.append(" ").append(key).append(value));
        sb.append(">");
        return sb.toString();
    }
}

// END
