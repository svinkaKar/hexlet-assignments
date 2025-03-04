package exercise;

import java.util.HashMap;
import java.util.Map;

import static exercise.Utils;

// BEGIN
public class FileKV implements KeyValueStorage {

    private String path;
    private Map<String, String> map;

    public FileKV(String path, Map<String, String> map) {
        this.path = path;
        this.map = new HashMap<>(map);
        String currentValue = readFile(path);
        var currentValueMap = deserialize(currentValue);
        currentValueMap.putAll(map);
        String content = serialize(currentValueMap);
        writeFile(path, content);
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
        String currentValue = readFile(path);
        var currentValueMap = deserialize(currentValue);
        currentValueMap.put(key, value);
        String content = serialize(currentValueMap);
        writeFile(path, content);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
        String currentValue = readFile(path);
        var currentValueMap = deserialize(currentValue);
        currentValueMap.remove(key);
        String content = serialize(currentValueMap);
        writeFile(path, content);
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
