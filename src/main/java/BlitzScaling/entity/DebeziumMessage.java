package BlitzScaling.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DebeziumMessage {
    // todo (jianfeng) - we intentionally ignore the schema part for now
    //@JsonProperty("schema")
    //private String schema;

    @JsonProperty("payload")
    private PayLoad payLoad;
}
