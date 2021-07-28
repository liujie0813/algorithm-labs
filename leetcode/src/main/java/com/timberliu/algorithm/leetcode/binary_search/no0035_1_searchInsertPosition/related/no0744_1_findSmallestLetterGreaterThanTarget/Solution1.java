package com.timberliu.algorithm.leetcode.binary_search.no0035_1_searchInsertPosition.related.no0744_1_findSmallestLetterGreaterThanTarget;

/**
 * 744. 寻找比目标字母大的最小字母
 *
 * Created by liujie on 2021/3/18
 */

public class Solution1 {

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left == letters.length ? letters[0] : letters[left];
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/ -----");
        System.out.println("----- 1 -----");
        char[] letters1 = {'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(letters1, 'a'));

        System.out.println("----- 2 -----");
        System.out.println(nextGreatestLetter(letters1, 'c'));

        System.out.println("----- 3 -----");
        System.out.println(nextGreatestLetter(letters1, 'd'));

        System.out.println("----- 4 -----");
        System.out.println(nextGreatestLetter(letters1, 'g'));

        System.out.println("----- 5 -----");
        System.out.println(nextGreatestLetter(letters1, 'j'));

        System.out.println("----- 6 -----");
        System.out.println(nextGreatestLetter(letters1, 'k'));

    }
}
