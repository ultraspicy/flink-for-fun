package BlitzScaling;

import BlitzScaling.entity.DebeziumMessage;
import BlitzScaling.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class DBStreaming {
    public static void main(String[] args) throws Exception {
        // flink can figure out the environment by its own, whether it's a local environment or remote environment
        // and automatically set up the environment for us
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

//        final ParameterTool params = ParameterTool.fromArgs(args);
//        env.getConfig().setGlobalJobParameters(params);
        String fileDir = System.getProperty("user.dir") + "/src/main/resources/sample_message_2.json";
        DataStream<String> dataStream = env.readTextFile(fileDir);
        if (dataStream == null) {
            System.exit(1);
            return;
        }

        DataStream<String> outStream = dataStream.map(new ParseAfter());
        outStream.print();

        // monitor the task status by task name at port 8081
        env.execute("==== Flink Streaming Java API Skeleton =====");
    }
}
