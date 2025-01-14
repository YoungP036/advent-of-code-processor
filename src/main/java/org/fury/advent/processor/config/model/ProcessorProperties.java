package org.fury.advent.processor.config.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

@Setter
@Getter
@Validated
@Configuration
@ConfigurationProperties(prefix = "config")
public class ProcessorProperties {

    @NonNull
    private String inputFile;

    private String outputFile;
}
