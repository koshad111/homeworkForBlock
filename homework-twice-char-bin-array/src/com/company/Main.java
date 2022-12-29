package com.company;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	    String[] arr1 = {"a", "b", "c", "a", "b"};
        System.out.println(twiceChar(arr1));
        int[] arr2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(maxOnesLength(arr2, 3));
    }

    /**
     * Given a string s, return the first character to appear twice.
     * It is guaranteed that the input will have a duplicate character.
     * @param arr
     * @return
     */
    static String twiceChar(String[] arr){
        Set<String> characters = new HashSet<>();
        for (String s : arr){
            if(!characters.add(s)){
                return s;
            }
        }
        String exception = "not found";
        return exception;
    }

    /**
     * Given a binary array nums and an integer k,
     * return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
     * Output: 6
     * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     *
     * Example 2:
     *
     * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
     * Output: 10
     * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
     * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
     * @return the maximum number of consecutive 1's in the array
     */
    static int maxOnesLength(int[] arr, int k){
        int maxLength = 0;
        int numberOf1 = 0;
        int numberOf0 = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j= i; j < arr.length; j++){
                if(arr[j] == 1){
                    numberOf1++;
                }else{
                    if(numberOf0 + 1 > k){
                        break;
                    }
                    numberOf0++;
                }
                if(numberOf0 + numberOf1 > maxLength){
                    maxLength = numberOf0 + numberOf1;
                }
            }
            numberOf1 = 0;
            numberOf0 = 0;
        }
        return maxLength;
    }
}
