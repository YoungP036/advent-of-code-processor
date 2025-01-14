package org.fury.advent.processor.service;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DistanceService {
    public static int getDistance(int a, int b) {
        return (a <= b) ? (b-a) : (a-b);
    }
}
