package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //method maxAverage
        int[] arr1 = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(maxAverage(arr1, k));
        //_____________________________
        //method stringReverse
        char[] arr2 = {'e', 'n', 't', 'i', 't', 'y'};
        System.out.println(stringReverse(arr2));
        int[] arr3 = {-10, -4, -3, -1, 0, 2, 3, 5, 12};
        System.out.println(Arrays.toString(squaresOrderWithSecondArray(arr3)));
    }

    /**
     * You are given an integer array nums consisting of n elements, and an integer k.
     * <p>
     * Find a contiguous subarray whose length is equal to k that has the maximum average value
     * and return this value. Any answer with a calculation error less than 10-5 will be accepted.
     * Example 1:
     *
     * Input: nums = [1,12,-5,-6,50,3], k = 4
     * Output: 12.75000
     * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     *
     * @param arr
     * @param k   - length of contiguous subarray
     * @return maximum average value of contiguous subarray whose length is equal to k
     */
    //{1,12,-5,-6,50,3}; k = 4  12
    private static double maxAverage(int[] arr, int k) {
        double summSubarr = 0;
        for (int i = 0; i < k; i++) {
            summSubarr += arr[i];
        }
        double maxSummSubarr = summSubarr;
        for (int i = k; i < arr.length; i++) {
            summSubarr = summSubarr - arr[i - k] + arr[i];
            if (summSubarr > maxSummSubarr) {
                maxSummSubarr = summSubarr;
            }
        }
        maxSummSubarr = maxSummSubarr / k;
        return maxSummSubarr;
    }

    /**
     * Write a function that reverses a string. The input string is given as an array of characters s.
     * You must do this by modifying the input array in-place with O(1) extra memory.
     * Example 1:
     *
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     *
     * @param chars - array oа chars
     * @return reversed string
     */
    private static char[] stringReverse(char[] chars) {
        char s;
        for (int i = 0; i < chars.length / 2; i++) {
            s = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = chars[i];
            chars[i] = s;
        }
        return chars;
    }

    /**
     * Given an integer array nums sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order.
     *
     * Example 1:
     *
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     * @param arr
     * @return
     */
    public static int[] squaresOrder(int[] arr) {
        int left = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (-(arr[0]) < arr[left]) {
                arr[left] = arr[left] * arr[left];
                left --;
            } else {
                for (int j = 0; j < left; j++) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
                arr[left] = arr[left] * arr[left];
                left --;
            }
        }
        return arr;
    }

    /**
     * Given an integer array nums sorted in non-decreasing order,
     * return an array of the squares of each number sorted in non-decreasing order, using second array.
     *
     * Example 1:
     *
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     * @param arr
     * @return
     */
    public static int[] squaresOrderWithSecondArray(int[] arr) {
        int[] arr2 = new int[arr.length];
        int left = arr.length - 1;
        int right = 0;
        int nextElement = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (-(arr[right]) < arr[left]) {
                arr2[nextElement] = arr[left] * arr[left];
                left --;
            } else {
                arr2[nextElement] = arr[right] * arr[right];
                right++;
            }
            nextElement--;
        }
        return arr2;
    }

    public static <T> void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <T> void swap(List<T> l, int i, int j) {
        Collections.<T>swap(l, i, j);
    }

}
