package com;

import org.apache.log4j.Logger;

public class NewMyString {
    private Logger logger = Logger.getLogger(NewMyString.class);
    private static final int ASCII_VALUE_OF_ONE = 49;
    private static final int ASCII_VALUE_OF_ZERO = 48;


    public String getIndexesOfOnesFromString(String s) {
        int currentIndex = 0;
        int length = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ASCII_VALUE_OF_ONE) {
                if (getSequenceLength(i, s) > length) {
                    length = getSequenceLength(i, s);
                    currentIndex = i;
                }
                i = i + length - 1;
            }
        }
        logger.info("(" + currentIndex + " , " + length + " ) One-s");
        return "(" + currentIndex + " , " + length + " ) One-s";
    }

    private int getSequenceLength(int currentIndex, String s) {
        int currentLength = 0;
        char lastOne = s.charAt(currentIndex);
        while (lastOne == s.charAt(currentIndex)) {
            currentIndex++;
            currentLength++;
            if (currentIndex == s.length()) {
                break;
            }
        }
        return currentLength;
    }

    private void isContainsZerosInString(){

    }
    private void isContainsOnesInString(){

    }


    public static void main(String[] args) {

        //   String s1 = "10010001110000001111";
        String s1 = "1001111000111111";
        new NewMyString().getIndexesOfOnesFromString(s1);

    }

}


