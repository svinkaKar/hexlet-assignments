package exercise;

import java.util.HashMap;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage storage) {
        var storageMap = storage.toMap();
        var swipeMap = new HashMap<String, String>();

        storageMap.forEach((key, value) -> swipeMap.put(value, key));

        storageMap.clear();
        storageMap.putAll(swipeMap);
    }
}

// END
