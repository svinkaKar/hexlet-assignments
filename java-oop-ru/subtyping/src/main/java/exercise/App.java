package exercise;

import java.util.HashMap;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage storage) {
        var storageMap = new HashMap<>(storage.toMap());
        var swipeMap = new HashMap<String, String>();

        storageMap.forEach((key, value) -> swipeMap.put(value, key));

        for (var entry : swipeMap.entrySet()) {
            storage.set(entry.getKey(), entry.getValue());
        }
    }
}

// END
