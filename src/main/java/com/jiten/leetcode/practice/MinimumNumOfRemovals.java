package com.jiten.leetcode.practice;

/**
 * 1671. Minimum Number of Removals to Make Mountain Array
 *
 * You may recall that an array arr is a mountain array if and only if:
 *
 * arr.length >= 3
 * There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given an integer array nums​​​, return the minimum number of elements to remove to make nums​​​ a mountain array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,1]
 * Output: 0
 * Explanation: The array itself is a mountain array so we do not need to remove any elements.
 * Example 2:
 *
 * Input: nums = [2,1,1,5,6,2,3,1]
 * Output: 3
 * Explanation: One solution is to remove the elements at indices 0, 1, and 5, making the array nums = [1,5,6,3,1].
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 1000
 * 1 <= nums[i] <= 109
 * It is guaranteed that you can make a mountain array out of nums.
 */

/**
 * Sample Input
 *
 * [1,3,1]
 * [2,1,1,5,6,2,3,1]
 * [4,3,2,1,1,2,3,1]
 * [1,2,3,4,4,3,2,1]
 * [9,8,1,7,6,5,4,3,2,1]
 * [1,16,84,9,29,71,86,79,72,12]
 */
public class MinimumNumOfRemovals {

    public static void main(String[] args) {

    }

    public static int minimumMountainRemovals(int[] a) {
        int removalsCount = 0;
        for(int i=0; i< a.length; i++){
            if(i == 0){
                if(a[i] > a[i+1])
                    removalsCount++;
            }
            else if(i > 0 && i < a.length-1){
                if(a[i] < a[i-1] && a[i] < a[i+1] && i > (a.length/2)-1) {
                    // System.out.println(i + ":" + a[i]);
                    removalsCount++;
                }
                if(a[i] == a[i-1])
                    removalsCount++;
                if(a[i] < a[i-1] && a[i] > a[i+1] && i<(a.length/2)-1){
                    // System.out.println(i + ":" + (a.length/2) + ":" + a[i]);
                    removalsCount++;
                }
            }
        }
        return removalsCount;
    }
}
