package exercise;

import java.util.Map;

import java.util.LinkedHashMap;

// BEGIN
public class Tag {

    public String nameTag;
    public Map<String, String> atributesTag;

    public Tag(String nameTag, Map<String, String> atributesTag) {
        this.nameTag = nameTag;
        this.atributesTag = atributesTag;
    }

    public String getNameTag() {
        return nameTag;
    }

    public Map<String, String> getAtributesTag() {
        return atributesTag;
    }

    public String getAtributes(String nameOfTag, Map<String, String> atributesForTag) {
        Map<String, String> newMap = new LinkedHashMap<>();
        atributesForTag.forEach((key, value) -> newMap.put(key, String.format("=\"%s\"", value)));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<%s", nameOfTag));
        newMap.forEach((key, value) -> sb.append(" ").append(key).append(value));
        sb.append(">");
        return sb.toString();
    }
}

// END
