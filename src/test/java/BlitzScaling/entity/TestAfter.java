package BlitzScaling.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestAfter {

    @Test
    public void TestDeserialization () throws JsonProcessingException {
        // arrange
        String text = "{\"id\": 1001, \"first_name\": \"Sally\", \"last_name\": \"Thomas\", \"email\": \"sally.thomas@acme.com\"}";
        ObjectMapper objectMapper = new ObjectMapper();

        // action
        After after = objectMapper.readValue(text, After.class);

        // assert
        assertEquals(1001, after.getID());
        assertEquals("Sally", after.getFirstName());
        assertEquals("Thomas", after.getLastName());
        assertEquals("sally.thomas@acme.com", after.getEmail());
    }

    @Test
    public void TestDeserialization_NullField () throws JsonProcessingException {
        // arrange
        String text = "{\"id\": 1001, \"first_name\": \"Sally\", \"last_name\": \"Thomas\", \"email\": null}";
        ObjectMapper objectMapper = new ObjectMapper();

        // action
        After after = objectMapper.readValue(text, After.class);

        // assert
        assertEquals(1001, after.getID());
        assertEquals("Sally", after.getFirstName());
        assertEquals("Thomas", after.getLastName());
        assertNull(after.getEmail());
    }

    @Test
    public void TestDeserialization_UnknownField () throws JsonProcessingException {
        // arrange
        String text = "{\"id\": 1001, \"first_name\": \"Sally\", \"last_name\": \"Thomas\", \"email\": null, \"unknownField\": \"this is a field should be ignored\"}";
        ObjectMapper objectMapper = new ObjectMapper();

        // action
        After after = objectMapper.readValue(text, After.class);

        // assert
        assertEquals(1001, after.getID());
        assertEquals("Sally", after.getFirstName());
        assertEquals("Thomas", after.getLastName());
        assertNull(after.getEmail());
    }
}
