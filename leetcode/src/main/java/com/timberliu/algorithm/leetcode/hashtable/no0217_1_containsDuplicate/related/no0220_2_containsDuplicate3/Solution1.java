package com.timberliu.algorithm.leetcode.hashtable.no0217_1_containsDuplicate.related.no0220_2_containsDuplicate3;

import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 *
 *  时间复杂度：O(n）
 *  空间复杂度：O(k)
 *
 *   1. 滑动窗口
 *      保证 abs(i - j) <= k
 *   2. TreeSet
 *      保证 abs(nums[i] - nums[j]) <= t
 *        nums[i] - nums[j] <= t    =>    nums[i] - t <= nums[j]
 *        nums[j] - nums[i] <= t    =>    nums[j] <= nums[i] + t
 *
 * Created by liujie on 2021/4/25
 */

public class Solution1 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 大于等于 nums[i]-t 的最小值
            // nums[i] - t  <= x <= nums[i] + t
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling < (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/contains-duplicate-iii/ -----");
        System.out.println("----- 1 -----");
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));

        System.out.println("----- 2 -----");
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));

        System.out.println("----- 3 -----");
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));

    }
}
