package com.leetcode.zh3ng.solutions.arrays101;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangxingang
 * @created on 2020-05-14
 *
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 *
 * More formally check if there exists two indices i and j such that :
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 *
 * Example 1:
 *
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 * Example 2:
 *
 * Input: arr = [7,1,14,11]
 * Output: true
 * Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
 * Example 3:
 *
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: In this case does not exist N and M, such that N = 2 * M.
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 */
public class CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i< arr.length; i++){
            if (arr[i] > 0){
                int low = i;
                int high = arr.length - 1;
                while (low <= high){
                    int midIdx = (low + high)/2;
                    if (arr[midIdx] > arr[i]*2){
                        high = midIdx - 1;
                    }else if (arr[midIdx] < arr[i]*2){
                        low = midIdx + 1;
                    }else{
                        return true;
                    }
                }
            }else if (arr[i] == 0){
                if (i < arr.length - 1 && arr[i+1] == 0){
                    return true;
                }
            }else{
                int low = 0;
                int high = i;
                while (low <= high){
                    int midIdx = (low + high) / 2;
                    if (arr[midIdx] < arr[i] * 2){
                        low = midIdx + 1;
                    }else if (arr[midIdx] > arr[i] * 2){
                        high = midIdx - 1;
                    }else{
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkIfExist2(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i:arr){
            set.add(i);
        }
        for (int i:arr){
            if (i % 2 == 0 && set.contains(i % 2)){
                return true;
            }
            if (set.contains(i*2)){
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        CheckIfNandItsDoubleExist c = new CheckIfNandItsDoubleExist();
        int[] arr = new int[]{7,1,14,11};
        System.out.println(c.checkIfExist2(arr));

        System.out.println(c.checkIfExist2(new int[]{10,2,5,3}));

        System.out.println(c.checkIfExist2(new int[]{-2,-4,5,3}));
    }
}
