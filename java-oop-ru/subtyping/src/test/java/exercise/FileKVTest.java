package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import org.junit.jupiter.api.Test;
import java.util.Map;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void test() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        assertEquals("value", storage.get("key", "default"));
        assertEquals("default", storage.get("key0", "default"));

        KeyValueStorage storage2 = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage2.unset("key");

        assertEquals("default", storage.get("key", "default"));
        KeyValueStorage storage3 = new FileKV("src/test/resources/file", Map.of("key", "value"));
        assertEquals("value", storage.get("key", "default"));
    }
    // END
}
