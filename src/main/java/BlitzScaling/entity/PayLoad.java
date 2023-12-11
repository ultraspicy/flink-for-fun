package BlitzScaling.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

// PayLoad -
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayLoad implements Serializable {
    @JsonProperty("after")
    private After after;
}
