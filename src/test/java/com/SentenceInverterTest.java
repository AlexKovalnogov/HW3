package com;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceInverterTest {
    SentenceInverter senInv;

    @BeforeMethod
    public void setUp() {
        senInv = new SentenceInverter();
    }

    @Test
    public void testThatUserNotifiedIfInPUTSentenceIsEmpty() {
        Assert.assertEquals(senInv.getConvertedSentence(""), "String is empty");
    }

    @Test
    public void testThatConvertiongSentenseSuccessful() {
        Assert.assertEquals(senInv.getConvertedSentence("   Как решить   это задание   и не сломать себе   голову?   "), "каК ршт отэ здне и н ьтамолс сб ?уволог ");
    }

    @Test
    public void testThatConvertiongSentensewithPunctuationSignsSuccessful() {
        Assert.assertEquals(senInv.getConvertedSentence("qwerty,  asdfg,,  ,,  dffdf.."), "ytrewq adg  dff ");
    }
}
