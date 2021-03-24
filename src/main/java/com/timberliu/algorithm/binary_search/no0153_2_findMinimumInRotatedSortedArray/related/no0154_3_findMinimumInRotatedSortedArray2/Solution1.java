package com.timberliu.algorithm.binary_search.no0153_2_findMinimumInRotatedSortedArray.related.no0154_3_findMinimumInRotatedSortedArray2;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 *
 *   原理？
 *      a. 1,2,3,4,5
 *      b. 1,1,1,0,1
 *      c. 1,0,1,1,1
 *      d. 1,1,1,1,1
 *
 * Created by liujie on 2021/3/19
 */

public class Solution1 {

    public static int findMin1(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                return doFindMin(nums);
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    private static int doFindMin(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(findMin1(new int[]{1, 3, 5}));

        System.out.println("----- 2 -----");
        System.out.println(findMin1(new int[]{2, 2, 2, 0, 1}));

        System.out.println("----- 3 -----");
        System.out.println(findMin1(new int[]{1, 0, 1, 1, 1}));

    }
}
