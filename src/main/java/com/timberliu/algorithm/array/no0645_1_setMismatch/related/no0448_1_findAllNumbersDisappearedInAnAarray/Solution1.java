package com.timberliu.algorithm.array.no0645_1_setMismatch.related.no0448_1_findAllNumbersDisappearedInAnAarray;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到数组中所有消失的数字
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(1)
 *
 * Created by liujie on 2021/2/24
 */

public class Solution1 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1] ) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/ -----");
        System.out.println("----- 1 -----");
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }
}
