package org.fury.advent.processor.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceServiceTest {

    @Test
    void testGetDistance_greaterThan() {
        assertThat(DistanceService.getDistance(7, 3)).isEqualTo(4);
    }

    @Test
    void testGetDistance_lessThan() {
        assertThat(DistanceService.getDistance(3, 7)).isEqualTo(4);
    }

    @Test
    void testGetDistance_same() {
        assertThat(DistanceService.getDistance(7, 7)).isZero();
    }
}