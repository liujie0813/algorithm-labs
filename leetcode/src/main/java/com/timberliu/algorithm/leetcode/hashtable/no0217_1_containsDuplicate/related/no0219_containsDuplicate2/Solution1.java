package com.timberliu.algorithm.leetcode.hashtable.no0217_1_containsDuplicate.related.no0219_containsDuplicate2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liujie on 2021/4/20
 *
 *   滑动窗口
 *
 */

public class Solution1 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/contains-duplicate-ii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));

        System.out.println("----- 2 -----");
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));

        System.out.println("----- 3 -----");
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));

    }
}
