package com.timberliu.algorithm.array.no0118_1_pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 *   时间复杂度：O(k^2)
 *   空间复杂度：O(k^2) 不考虑返回值的空间占用
 *
 * Created by liujie on 2021/2/25
 */

public class Solution1 {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> topRow = res.get(i - 1);
            List<Integer> bottomRow = new ArrayList<>();
            bottomRow.add(1);
            for (int j = 1; j < i; j++) {
                bottomRow.add(topRow.get(j - 1) + topRow.get(j));
            }
            bottomRow.add(1);
            res.add(bottomRow);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/pascals-triangle/ -----");
        System.out.println("----- 1 -----");
        List<List<Integer>> lists = generate(1);
        System.out.println(lists);

        System.out.println("----- 2 -----");
        List<List<Integer>> lists1 = generate(2);
        System.out.println(lists1);

        System.out.println("----- 3 -----");
        List<List<Integer>> lists2 = generate(5);
        System.out.println(lists2);

        System.out.println("----- 4 -----");
        List<List<Integer>> lists3 = generate(10);
        System.out.println(lists3);
    }
}
