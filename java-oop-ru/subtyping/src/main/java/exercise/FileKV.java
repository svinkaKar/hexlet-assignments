package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    private String path;
    private Map<String, String> map;

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        this.map = new HashMap<>(map);
        String currentValue = Utils.readFile(path);
        var currentValueMap = Utils.deserialize(currentValue);
        currentValueMap.putAll(map);
        String content = Utils.serialize(currentValueMap);
        Utils.writeFile(path, content);
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
        String currentValue = Utils.readFile(path);
        var currentValueMap = Utils.deserialize(currentValue);
        currentValueMap.put(key, value);
        String content = Utils.serialize(currentValueMap);
        Utils.writeFile(path, content);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
        String currentValue = Utils.readFile(path);
        var currentValueMap = Utils.deserialize(currentValue);
        currentValueMap.remove(key);
        String content = Utils.serialize(currentValueMap);
        Utils.writeFile(path, content);
    }

    @Override
    public String get(String key, String defaultValue) {
        return map.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return map;
    }
}

// END
