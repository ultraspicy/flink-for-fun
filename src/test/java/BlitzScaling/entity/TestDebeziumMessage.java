package BlitzScaling.entity;

import BlitzScaling.util.Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDebeziumMessage {

    @Test
    public void TestDeserialization () throws JsonProcessingException {
        // arrange
        String fileDir = System.getProperty("user.dir") + "/src/main/resources/sample_message_2.json";
        String jsonContent = Util.readFileContent(fileDir);
        ObjectMapper objectMapper = new ObjectMapper();

        // action
        DebeziumMessage msg = objectMapper.readValue(jsonContent, DebeziumMessage.class);
        assertNotNull(msg);
        assertNotNull(msg.getPayLoad());
        assertNotNull(msg.getPayLoad().getAfter());
        assertEquals("Sally", msg.getPayLoad().getAfter().getFirstName());
    }
}

