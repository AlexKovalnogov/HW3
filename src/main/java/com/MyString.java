package com;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MyString {
    Logger logger = Logger.getLogger(MyString.class);
    private static final int ASCII_VALUE_OF_ONE = 49;
    private static final int ASCII_VALUE_OF_ZERO = 48;


    public String getTheLongestContinuosChainOfOnesAndZeros(String inpupData) {
        String infoAboutOnes;
        String infoAboutZeros;

        ArrayList<Integer> indexesOfOnes = getIndexesOfOnesFromString(inpupData);
        ArrayList<Integer> indexesOfZeros = getIndexesOfZesoFromString(inpupData);
        if (!indexesOfOnes.isEmpty()) {
            List<List> groupIndexesOfOnes = getGroupsOfIndexes(indexesOfOnes);
            List<Integer> arrayListOfOnes = getTheLongestArrayList(groupIndexesOfOnes);
            infoAboutOnes = "(" + arrayListOfOnes.get(0) + "," + arrayListOfOnes.get(arrayListOfOnes.size() - 1) + ")" + " цепочка единиц";
        } else {
            infoAboutOnes = " There aren't One's in string";
        }

        if (!indexesOfZeros.isEmpty()) {
            List<List> groupIndexesOfZeros = getGroupsOfIndexes(indexesOfZeros);
            List<Integer> arrayListOfZeros = getTheLongestArrayList(groupIndexesOfZeros);
            infoAboutZeros = "(" + arrayListOfZeros.get(0) + "," + arrayListOfZeros.get(arrayListOfZeros.size() - 1) + ")" + " цепочка нулей";
        } else {
            infoAboutZeros = " There aren't Zeros's in string";
        }

        logger.info(infoAboutOnes + infoAboutZeros);

        return infoAboutOnes + infoAboutZeros;

    }

    private ArrayList<Integer> getIndexesOfOnesFromString(String s) {
        ArrayList<Integer> indexesOfOnes = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ASCII_VALUE_OF_ONE) {
                indexesOfOnes.add(i);
            }
        }
        return indexesOfOnes;
    }

    private ArrayList<Integer> getIndexesOfZesoFromString(String s) {
        ArrayList<Integer> indexesOfZeros = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ASCII_VALUE_OF_ZERO) {
                indexesOfZeros.add(i);
            }
        }
        return indexesOfZeros;
    }

 /*   private ArrayList<Integer> processingArrayList(ArrayList<Integer> listOfIndexes) {
        for (int i = 0; i < listOfIndexes.size() - 1; i++) {
            if (listOfIndexes.get(i).equals(listOfIndexes.get(i + 1) - 1)) {
                listOfIndexes.remove(i + 1);
            }
        }
        return listOfIndexes;
    }*/


    private List<List> getGroupsOfIndexes(ArrayList<Integer> listOfIndexes) {

        List<List> listOfArrays = new ArrayList();
        listOfIndexes.add(0);
        for (int i = 0; i < listOfIndexes.size() - 1; i++) {
            List<Integer> integers = new ArrayList<Integer>();
            if (listOfIndexes.get(i).equals(listOfIndexes.get(i + 1) - 1)) {
                for (int j = i; j < listOfIndexes.size() - 1; j++) {
                    if (listOfIndexes.get(j).equals(listOfIndexes.get(j + 1) - 1)) {
                        integers.add(listOfIndexes.get(j));
                    } else if (!listOfIndexes.get(j).equals(listOfIndexes.get(j + 1) - 1)) {
                        integers.add(listOfIndexes.get(j));
                        i = j;
                        break;
                    }
                }
            } else {
                integers.add(listOfIndexes.get(i));
            }

            listOfArrays.add(integers);
        }
        return listOfArrays;
    }

    public List<Integer> getTheLongestArrayList(List<List> list) {
        int maxSizeOfArray = 0;
        int indexOfLongestArrayList = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() > maxSizeOfArray) {
                maxSizeOfArray = list.get(i).size();
                indexOfLongestArrayList = i;
            }
        }
        return list.get(indexOfLongestArrayList);
    }


    public void my(String s) {

        getTheLongestContinuosChainOfOnesAndZeros(s);
    }


    public static void main(String[] args) {

        //   String s1 = "10010001110000001111";
        String s1 = "101100122330";
        new MyString().my(s1);

    }


}
