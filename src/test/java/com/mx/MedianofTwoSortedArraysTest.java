package com.mx;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianofTwoSortedArraysTest {
    MedianofTwoSortedArrays medianofTwoSortedArrays = new MedianofTwoSortedArrays();
    @Test
    void findMedianSortedArrays() {
        int[] n1 = {};
        int[] n2 = {2, 3};
//        Assert.assertEquals(medianofTwoSortedArrays.findMedianSortedArrays(n1, n2), 2.0);
        assertEquals(medianofTwoSortedArrays.findMedianSortedArrays(n1, n2), 2.5);
    }

    @Test
    void findnum() {
        int[] n1 = {1, 2};
        int[] n2 = {2, 4, 6};
        Assert.assertEquals(medianofTwoSortedArrays.findnum(4, n1, n2), 4);
    }

}