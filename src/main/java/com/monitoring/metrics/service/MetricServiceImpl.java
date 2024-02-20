package com.monitoring.metrics.service;

import com.monitoring.metrics.model.Metric;
import com.monitoring.metrics.util.Utility;
import io.prometheus.client.Histogram;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
@Slf4j
public class MetricServiceImpl {
    private static final Histogram customHistogram = Histogram.build()
            .name("custom_histogram")
            .help("Description of custom histogram")
            .labelNames("aid","tt","hc","mc","d")
            .buckets(200, 400, 417, 424,500) // Define buckets
            .register();

    public void insertData(){
        List<Metric> metricData = Utility.readJsonFile("m.json");
        System.out.println(metricData.size());
        log.info("metric size is {} ", metricData.size());
        for ( Metric metric : metricData) {
            String aid = metric.getAid();
            String tt = metric.getTt();
            String hc = metric.getHc();
            String mc = metric.getMc();
            String d = metric.getD();

            customHistogram.labels(aid, tt, hc, mc, d).observe(500.0);
            log.info("label data pushed");
        }
    }
}
