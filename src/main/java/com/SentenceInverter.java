package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceInverter {


    public String getConvertedSentence(String sentence) {
        String outputSentence = "String is empty";
        if (sentence.length() > 0) {
            outputSentence = "";
            List<String> listOfWords = getListOfWordsFromSentence(sentence);
            for (int i = 0; i < listOfWords.size(); i++) {
                if (i % 2 == 0) {
                    listOfWords.set(i, getWordWithOtherOrder(convertStringWordIntoCharArray(listOfWords.get(i))));
                } else {
                    listOfWords.set(i, getWordWithoutOddLetter(convertStringWordIntoCharArray(listOfWords.get(i))));
                }
            }
            for (String value : listOfWords) {
                outputSentence = outputSentence.concat(value + " ");
            }
        }
        return outputSentence;
    }

    private List<String> getListOfWordsFromSentence(String sentence) {
        sentence = sentence.trim().replaceAll("\\s{2,}", " ");
        return Arrays.asList(sentence.split(" "));
    }

    private List<Character> convertStringWordIntoCharArray(String word) {
        List<Character> wordPresentInCharList = new ArrayList<Character>();
        for (int i = 0; i < word.length(); i++) {
            wordPresentInCharList.add(word.charAt(i));
        }
        return wordPresentInCharList;
        //  return Arrays.asList(word.toCharArray());
    }

    private String getWordWithOtherOrder(List<Character> list) {
        String outputWord = list.toString().replaceAll("[,\\s\\[\\]]", "");
        return new StringBuilder(outputWord).reverse().toString();
    }

    private String getWordWithoutOddLetter(List<Character> list) {
        for (int i = 1; i < list.size(); i++) {
            list.remove(i);
        }
        String outputWord = list.toString().replaceAll("[,\\s\\[\\]]", "");
        return outputWord;
    }

}

