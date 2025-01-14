package org.fury.advent.processor.config;

import lombok.RequiredArgsConstructor;
import org.fury.advent.processor.config.model.ProcessorProperties;
import org.fury.advent.processor.model.LocationPair;
import org.fury.advent.processor.processor.LocationItemProcessor;
import org.fury.advent.processor.writer.LocationItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@RequiredArgsConstructor
public class ProcessorConfig {

    private final ProcessorProperties processorProperties;

    @Bean
    public ItemReader<LocationPair> locationReader() {
        return new FlatFileItemReaderBuilder<LocationPair>()
                .name("personItemReader")
                .resource(new PathResource(processorProperties.getInputFile()))
                .delimited()
                .delimiter("   ")
                .names("firstLocationId", "secondLocationId")
                .targetType(LocationPair.class)
                .build();
    }

    @Bean
    public ItemProcessor<LocationPair, Integer> locationProcessor() {
        return new LocationItemProcessor();
    }

    @Bean
    public ItemWriter<Integer> locationWriter() {
        return new LocationItemWriter();
    }

    @Bean
    public Job adventJob(JobRepository jobRepository, Step step) {
        return new JobBuilder("adventJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    protected Step day1Step(JobRepository jobRepository,
                         PlatformTransactionManager transactionManager,
                         ItemReader<LocationPair> reader,
                         ItemProcessor<LocationPair, Integer> processor,
                         ItemWriter<Integer> writer) {
        return new StepBuilder("day1Step", jobRepository)
                .<LocationPair, Integer>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager getTransactionManager() {
        return new ResourcelessTransactionManager();
    }
}
