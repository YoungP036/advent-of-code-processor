package org.fury.advent.processor.processor;

import lombok.extern.slf4j.Slf4j;
import org.fury.advent.processor.model.LocationPair;
import org.fury.advent.processor.service.DistanceService;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class LocationItemProcessor implements ItemProcessor<LocationPair, Integer> {

    @Override
    public Integer process(LocationPair locationPair) {
        log.info("ID #1: [{}], ID #2: [{}]", locationPair.firstLocationId(), locationPair.secondLocationId());
        return DistanceService.getDistance(locationPair.firstLocationId(), locationPair.secondLocationId());
    }
}
