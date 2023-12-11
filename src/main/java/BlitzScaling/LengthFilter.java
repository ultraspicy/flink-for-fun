package BlitzScaling;

import org.apache.flink.api.common.functions.FilterFunction;

public class LengthFilter implements FilterFunction<String> {
    // todo jianfeng - somehow mvn has difficulty to load inner static class and throws "Caused by: java.lang.ClassNotFoundException: BlitzScaling.ExampleJobCopy$Filter"

    public boolean filter(String s) throws Exception {
        return s.length() > 3;
    }
}
