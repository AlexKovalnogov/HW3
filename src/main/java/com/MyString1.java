package com;

import org.apache.log4j.Logger;

public class MyString1 {
    private Logger logger = Logger.getLogger(MyString1.class);
    private static final int ASCII_VALUE_OF_ONE = 49;
    private static final int ASCII_VALUE_OF_ZERO = 48;


    public String getTheLongestChainOfZeros(int index,int length){
        int maxLength=0;
        int startIndexOfSequence=0;
        if (length>maxLength){
            maxLength=length;
            startIndexOfSequence=index;
        }
    return "("+startIndexOfSequence+" , "+length +" ) One-s";
    }

    public void getIndexesOfOnesFromString(String s) {
        int indexMax = 0;
        int length = 0;
        String s1="";

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ASCII_VALUE_OF_ONE) {
                indexMax = i;
                length = getSequenceLength(indexMax, s);
                i = indexMax + length;
        s1= getTheLongestChainOfZeros(indexMax,length);
            }
        }

        System.out.print(s1);
    }

    private int getSequenceLength(int indexOfString, String s) {
        int currLength = 0;
        char lastOne = s.charAt(indexOfString);

        while (lastOne == s.charAt(indexOfString)) {
            indexOfString++;
            currLength++;
            if (indexOfString == s.length()) {
                break;
            }
        }
        return currLength;
    }




    public static void main(String[] args) {

        //   String s1 = "10010001110000001111";
        String s1 = "1001111100111";
        new MyString1().getIndexesOfOnesFromString(s1);

    }

}


