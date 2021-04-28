package com.timberliu.algorithm.hashtable.no0217_1_containsDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by liujie on 2021/4/20
 */

public class Solution1 {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/contains-duplicate/ -----");
        System.out.println("----- 1 -----");
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));

        System.out.println("----- 2 -----");
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));

        System.out.println("----- 3 -----");
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));


    }
}
