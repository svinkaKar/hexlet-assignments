package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage storage) {
        var storageMap = new HashMap<>(storage.toMap());
        var swappedMap = new HashMap<String, List<String>>();

        storageMap.forEach((key, value) -> {
            swappedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
            storage.unset(key);
        });

        swappedMap.forEach((value, keys) -> {
            for (var key : keys) {
                storage.set(value, key);
            }
        });
    }
}

// END
