package com.timberliu.algorithm.leetcode.hashtable.no0217_1_containsDuplicate.related.no0220_2_containsDuplicate3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 220. 存在重复元素 III
 *
 *  时间复杂度：O(n）
 *  空间复杂度：O(k)
 *
 *  1. 计算桶？ x为负数时，求哪个桶（由于 Java 的除法，向下取整）
 *    (x+1)/(w-1)
 *
 *     例如 w = 10，非负数桶为 0~9、10~19、20~29
 *                      -1~-10、-11~-20
 *     如果 -1~-10 直接除以 10，会被分到两组中
 *     所以先 +1 变为 0~-9，再除以 10，最后除以 10，都被分到 -1~-10 这一组中
 *
 *   2. 滑动窗口
 *
 * Created by liujie on 2021/4/25
 */

public class Solution2 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // <桶，元素>
        Map<Long, Long> map = new HashMap<>();
        // 桶的大小
        long w = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            long x = getId(nums[i], w);
            // 有两个元素同属一个组，这两个元素必然符合条件
            if (map.containsKey(x)) {
                return true;
            }
            // 相邻桶
            if (map.containsKey(x - 1) && Math.abs(nums[i] - map.get(x - 1)) < w) {
                return true;
            }
            if (map.containsKey(x + 1) && Math.abs(nums[i] - map.get(x + 1)) < w) {
                return true;
            }
            map.put(x, (long) nums[i]);
            // 滑动窗口，保证 abs(i-j) <= k
            if (i >= k) {
                map.remove(getId(nums[i - k], w));
            }
        }
        return false;
    }

    private static long getId(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
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
