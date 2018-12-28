package com;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NewMyStringTest {
    NewMyString newMyStr;

    @BeforeMethod
    public void setUp() {
        newMyStr = new NewMyString();
    }

    @Test
    public void testThatOnlyZerosAndOnesIsAvailableForProcessing() {
        Assert.assertEquals(newMyStr.getTheLongestGroupAndPositionOnesAndZerosInString("2222329995233546"), " There aren't One's in string    There aren't Zeros in string ");
    }

    @Test
    public void testThatEmptyStringIsProcessed() {
        Assert.assertEquals(newMyStr.getTheLongestGroupAndPositionOnesAndZerosInString(""), " There aren't One's in string    There aren't Zeros in string ");
    }

    @Test
    public void testThat() {
        Assert.assertEquals(newMyStr.getTheLongestGroupAndPositionOnesAndZerosInString("10"), "(0 , 0 ) One-s  (1 , 1 ) Zeros");
    }

    @Test
    public void testThatProcessingOnlyOneIsCorrect() {
        Assert.assertEquals(newMyStr.getTheLongestGroupAndPositionOnesAndZerosInString("1111"), "(0 , 3 ) One-s   There aren't Zeros in string ");
    }

    @Test
    public void testThatProcessingOnlyZerosIsCorrect() {
        Assert.assertEquals(newMyStr.getTheLongestGroupAndPositionOnesAndZerosInString("00000"), " There aren't One's in string   (0 , 4 ) Zeros");
    }

    @Test
    public void testThatMaxChainSequencesOfZeroAndOnesFoundRight() {
        Assert.assertEquals(newMyStr.getTheLongestGroupAndPositionOnesAndZerosInString("1110000110010"), "(0 , 2 ) One-s  (3 , 6 ) Zeros");
    }
}