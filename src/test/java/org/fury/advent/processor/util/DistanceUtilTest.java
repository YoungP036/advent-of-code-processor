package org.fury.advent.processor.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistanceUtilTest {

    @Test
    void testGetDistance_greaterThan() {
        assertThat(DistanceUtil.getDistance(7, 3)).isEqualTo(4);
    }

    @Test
    void testGetDistance_lessThan() {
        assertThat(DistanceUtil.getDistance(3, 7)).isEqualTo(4);
    }

    @Test
    void testGetDistance_same() {
        assertThat(DistanceUtil.getDistance(7, 7)).isZero();
    }
}