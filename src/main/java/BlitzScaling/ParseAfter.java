package BlitzScaling;

import BlitzScaling.entity.DebeziumMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.functions.MapFunction;

public class ParseAfter implements MapFunction<String, String> {

    @Override
    public String map(String input) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        DebeziumMessage msg = objectMapper.readValue(input, DebeziumMessage.class);
        return msg.toString();
    }
}
