package com;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence {


    private static final String FORBIDDEN_WORD = "бяка";
    private static final String WORD_FOR_REPLACEMENT = "Replaced_World";

    private Logger log = Logger.getLogger(Sentence.class);

    public String getSentenceWithoutForbiddenWords(String sentence) {
        String processedSentence = "Sentence is empty!";
        if (sentence.length() > 0) {
            processedSentence = "";
            List<String> listOfWords = splitSentenceByWordIntoList(sentence.trim().replaceAll("\\p{P}", "").replaceAll("\\s{2,}", " "));
            List<Integer> listOfIndexes = getIndexsesForbidenWord(listOfWords);
            List<String> listWithoutForbiddenWords = replaseWordInArrayList(listOfWords, listOfIndexes);
            for (String value : listWithoutForbiddenWords) {
                processedSentence = processedSentence.concat(value+" ");
            }
            log.info("Sentence without forbidden words;  " + processedSentence);
        }

        return processedSentence;

    }

    private List<String> splitSentenceByWordIntoList(String inputSentence) {
        List<String> splittedSentence = Arrays.asList(inputSentence.split(" "));
        log.info("Splitting completed");
        return splittedSentence;
    }

    private List<Integer> getIndexsesForbidenWord(List<String> listOfWorlds) {
        List<Integer> indexUslessWorld = new ArrayList();
        for (int i = 0; i < listOfWorlds.size(); i++) {
            if (listOfWorlds.get(i).equals(FORBIDDEN_WORD)) {
                indexUslessWorld.add(i);
            }
        }
        return indexUslessWorld;
    }

    private List<String> replaseWordInArrayList(List<String> listOfWords, List<Integer> listOfIndexes) {
        for (int i = 0; i < listOfIndexes.size(); i++) {
            listOfWords.set(listOfIndexes.get(i), WORD_FOR_REPLACEMENT);
        }
        log.info("All forbidden words are replaced");
        return listOfWords;
    }

}
