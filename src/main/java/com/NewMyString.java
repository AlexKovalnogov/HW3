package com;

import org.apache.log4j.Logger;

public class NewMyString {
    private Logger logger = Logger.getLogger(NewMyString.class);
    private static final int ASCII_VALUE_OF_ONE = 49;
    private static final int ASCII_VALUE_OF_ZERO = 48;


    public String getTheLongestGroupAndPositionOnesAndZerosInString(String s) {
        String infoAboutOnes;
        String infoAboutZeros;
        if (isContainsOnesInString(s)) {
            infoAboutOnes = getInformationAboutOnesInString(s);
        }
        else {
            infoAboutOnes = " There aren't One's in string ";
        }
        if (isContainsZerosInString(s)) {
            infoAboutZeros = getInformationAboutZerosInString(s);
        }
        else {
            infoAboutZeros = " There aren't Zeros in string ";
        }
        return infoAboutOnes+"  "+infoAboutZeros;
    }


    private String getInformationAboutOnesInString(String s) {
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
        logger.info("(" + currentIndex + " , " + (currentIndex+length-1) + " ) One-s");
        return "(" + currentIndex + " , " + (currentIndex+length-1) + " ) One-s";
    }

    private String getInformationAboutZerosInString(String s) {
        int currentIndex = 0;
        int length = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ASCII_VALUE_OF_ZERO) {
                if (getSequenceLength(i, s) > length) {
                    length = getSequenceLength(i, s);
                    currentIndex = i;
                }
                i = i + length - 1;
            }
        }
        logger.info("(" + currentIndex + " , " + (currentIndex+length-1) + " ) Zeros");
        return "(" + currentIndex + " , " +(currentIndex+length-1) + " ) Zeros";
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

    private boolean isContainsZerosInString(String inputData) {
        boolean containZeros = false;
        for (int i = 0; i < inputData.length() - 1; i++) {
            if (inputData.charAt(i) == ASCII_VALUE_OF_ZERO) {
                containZeros = true;
                break;
            }
        }
        return containZeros;
    }

    private boolean isContainsOnesInString(String inputData) {
        boolean containOne = false;

        for (int i = 0; i < inputData.length() - 1; i++) {
            if (inputData.charAt(i) == ASCII_VALUE_OF_ONE) {
                containOne = true;
                break;
            }
        }
        return containOne;
    }


    public static void main(String[] args) {

        //   String s1 = "10010001110000001111";
        String s1 = "0000";
        new NewMyString().getTheLongestGroupAndPositionOnesAndZerosInString(s1);

    }

}


