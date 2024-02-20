package com.monitoring.metrics.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitoring.metrics.model.Metric;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@UtilityClass
@Slf4j
public class Utility {

    @Autowired
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static  List<Metric> readJsonFile(String filePath) {
        List<Metric> listed = null;
        try {
            ClassPathResource resource = new ClassPathResource(filePath);
            byte[] bytes = Files.readAllBytes(Paths.get(resource.getURI()));

            listed = objectMapper.readValue(new String(bytes), new TypeReference<List<Metric>>() {});
        } catch (Exception e) {
            log.error("Error occurred during reading {}", e);
        }
        return listed;
    }
}
