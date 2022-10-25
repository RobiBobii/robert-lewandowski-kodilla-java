package com.kodilla.stream.array;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage() {
        //Given
        int[] list = new int[]{1,2,3,4};

        //When
        double average = ArrayOperations.getAverage(list);
        double expected = 2.5;

        //Then
        assertEquals(expected, average,0.1);
    }

}