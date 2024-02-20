package com.monitoring.metrics.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Metric {

    @JsonProperty("aid")
    private String aid;
    @JsonProperty("tt")
    private String tt;
    @JsonProperty("hc")
    private String hc;
    @JsonProperty("d")
    private String d;
    @JsonProperty("mc")
    private String mc;

}
