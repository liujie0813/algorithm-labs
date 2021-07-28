package com.timberliu.algorithm.leetcode.recursion.no0394_2_decodeString.related.no0726_3_numberOfAtoms;

import java.util.Map;
import java.util.TreeMap;

/**
 * 726. 原子的数量
 *
 *   时间复杂度：
 *      最好情况下 O(n)   H2O
 *      最坏情况下 O(n^2)    (((((H)))))
 *
 *   空间复杂度： O(n)
 *
 * Created by liujie on 2021/4/1
 */

public class Solution1 {

    public static String countOfAtoms(String formula) {
        StringBuilder res = new StringBuilder();
        // 各个字符 及其个数
        Map<String, Integer> count = doCountOfAtoms(formula, 0, formula.length());
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            res.append(entry.getKey());
            if (entry.getValue() > 1) {
                res.append(entry.getValue());
            }
        }
        return res.toString();
    }

    private static Map<String, Integer> doCountOfAtoms(String formula, int left, int right) {
        Map<String, Integer> count = new TreeMap<>();
        while (left < right) {
            // 如果遇到 (
            if (formula.charAt(left) == '(') {
                int iStart = left;
                int bal = 0;
                // 计算相对应的 ()
                while (left < right) {
                    if (formula.charAt(left) == '(') {
                        bal++;
                    } else if (formula.charAt(left) == ')') {
                        bal--;
                    }
                    if (bal == 0) {
                        // 递归处理
                        Map<String, Integer> tmpMap = doCountOfAtoms(formula, iStart + 1, left);
                        // 是否有数字，重复数量
                        iStart = ++left;
                        while (left < right && Character.isDigit(formula.charAt(left))) {
                            left++;
                        }
                        int multi = iStart < left ? Integer.parseInt(formula.substring(iStart, left)) : 1;
                        // 临时结果加到总结果中
                        for (Map.Entry<String, Integer> entry : tmpMap.entrySet()) {
                            // 之前的数量
                            Integer oldVal = count.getOrDefault(entry.getKey(), 0);
                            // 叠加
                            count.put(entry.getKey(), oldVal + entry.getValue() * multi);
                        }
                        break;
                    }
                    left++;
                }
            // 普通
            } else {
                int iStart = left;
                // 第一个必为大写字母
                left++;
                // 计算小写字母
                while (left < right && Character.isLowerCase(formula.charAt(left))) {
                    left++;
                }
                String name = formula.substring(iStart, left);
                // 计算数量
                iStart = left;
                while (left < right && Character.isDigit(formula.charAt(left))) {
                    left++;
                }
                int multi = iStart < left ? Integer.parseInt(formula.substring(iStart, left)) : 1;
                count.put(name, count.getOrDefault(name, 0) + multi);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/number-of-atoms/ -----");
        System.out.println("----- 1 -----");
        System.out.println(countOfAtoms("H2O"));

        System.out.println("----- 2 -----");
        System.out.println(countOfAtoms("Mg(OH)2"));

        System.out.println("----- 3 -----");
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));

        System.out.println("----- 4 -----");
        System.out.println(countOfAtoms("(H)"));

        System.out.println("----- 5 -----");
        System.out.println(countOfAtoms("((((H))))"));

    }
}
