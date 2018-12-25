package com;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SentenceTest {

    Sentence sentence;

    @BeforeMethod
    public void setUp() {
        sentence = new Sentence();
    }

    @Test
    public void testThatForbiddenWordAreReplaced() {
        Assert.assertEquals(sentence.getSentenceWithoutForbiddenWords("Он настоящая бяка"), "Он настоящая Replaced_World ");
    }

    @Test
    public void testThatUserIsNotifiedIfInputSentenceIsEmpty() {
        Assert.assertEquals(sentence.getSentenceWithoutForbiddenWords(""), "Sentence is empty!");
    }

    @Test
    public void testThatAllForbiddenWordSAreReplaced() {
        Assert.assertEquals(sentence.getSentenceWithoutForbiddenWords("бяка  ewfewefw, бяка  rergre  eer  бяка  "), "Replaced_World ewfewefw Replaced_World rergre eer Replaced_World ");
    }

    @Test
    public void testThatSentenceProcessingIsCorrectIfSentenceDoesNotContainForbiddenWords() {
        Assert.assertEquals(sentence.getSentenceWithoutForbiddenWords("test test"), "test test ");
    }

    @Test
    public void testThatSentenceProcessingIsCorrectIfSenteceContainsOnlyForbiddenWords() {
        Assert.assertEquals(sentence.getSentenceWithoutForbiddenWords("   бяка    бяка   бяка   "), "Replaced_World Replaced_World Replaced_World ");
    }
}