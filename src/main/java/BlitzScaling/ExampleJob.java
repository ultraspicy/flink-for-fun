package BlitzScaling;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * Skeleton for a Flink Streaming Job.
 *
 * <p>To package your application into a JAR file for execution, run
 * 'mvn clean package' on the command line.
 *
 * <p>If you change the name of the main class (with the public static void main(String[] args))
 * method, change the respective entry in the POM.xml file (simply search for 'mainClass').
 */
public class ExampleJob {
    public static void main(String[] args) throws Exception {
        // flink can figure out the environment by its own, whether it's a local environment or remote environment
        // and automatically set up the environment for us
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        final ParameterTool params = ParameterTool.fromArgs(args);
        env.getConfig().setGlobalJobParameters(params);

        DataStream<String> dataStream = StreamUtil.getDataStream(env, params);

        if (dataStream == null) {
            System.exit(1);
            return;
        }

        DataStream<String> outStream = dataStream.filter(new LengthFilter());
        outStream.print();

        // monitor the task status by task name at port 8081
        env.execute("==== Flink Streaming Java API Skeleton =====");
    }

}
