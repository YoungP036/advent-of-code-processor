package org.fury.advent.processor.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DistanceUtil {
    public static int getDistance(int a, int b) {
        return (a <= b) ? (b-a) : (a-b);
    }
}
