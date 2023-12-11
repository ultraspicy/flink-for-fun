package BlitzScaling.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestPayLoad {

    private static final String text = "{\n" +
            "    \"before\": null,\n" +
            "    \"after\": {\n" +
            "      \"id\": 1001,\n" +
            "      \"first_name\": \"Sally\",\n" +
            "      \"last_name\": \"Thomas\",\n" +
            "      \"email\": \"sally.thomas@acme.com\"\n" +
            "    },\n" +
            "    \"source\": {\n" +
            "      \"version\": \"1.6.0.Final\",\n" +
            "      \"connector\": \"mysql\",\n" +
            "      \"name\": \"dbserver1\",\n" +
            "      \"ts_ms\": 1626478552573,\n" +
            "      \"snapshot\": \"true\",\n" +
            "      \"db\": \"inventory\",\n" +
            "      \"sequence\": null,\n" +
            "      \"table\": \"customers\",\n" +
            "      \"server_id\": 0,\n" +
            "      \"gtid\": null,\n" +
            "      \"file\": \"mysql-bin.000003\",\n" +
            "      \"pos\": 154,\n" +
            "      \"row\": 0,\n" +
            "      \"thread\": null,\n" +
            "      \"query\": null\n" +
            "    },\n" +
            "    \"op\": \"r\",\n" +
            "    \"ts_ms\": 1626478552574,\n" +
            "    \"transaction\": null\n" +
            "  }";

    @Test
    public void TestDeserialization () throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        PayLoad payLoad = objectMapper.readValue(text, PayLoad.class);
        assertNotNull(payLoad);
        assertNotNull(payLoad.getAfter());
        assertEquals("Sally", payLoad.getAfter().getFirstName());
    }
}
