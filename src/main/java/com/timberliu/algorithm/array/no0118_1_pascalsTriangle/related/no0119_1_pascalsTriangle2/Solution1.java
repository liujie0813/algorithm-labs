package com.timberliu.algorithm.array.no0118_1_pascalsTriangle.related.no0119_1_pascalsTriangle2;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角 ii
 *
 *   时间复杂度：O(k^2)
 *   空间复杂度：O(k)
 *
 *   注意：内层循环递推时，需要从后往前，否则会覆盖下一步计算需要的值
 *
 * Created by liujie on 2021/2/25
 */

public class Solution1 {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }

        res.add(1);
        for (int i = 1; i < rowIndex + 1; i++) {
            res.add(1);
            for (int j = i - 1; j >= 1; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/pascals-triangle-ii/ -----");
        System.out.println("----- 1 -----");
        List<Integer> row = getRow(3);
        System.out.println(row);
    }
}
