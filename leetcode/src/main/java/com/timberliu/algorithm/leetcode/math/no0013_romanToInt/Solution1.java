package com.timberliu.algorithm.leetcode.math.no0013_romanToInt;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 *
 * @user liujie
 * @date 2023/8/14
 */
public class Solution1 {

    private static final Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer curVal = map.get(s.charAt(i));
            if (i + 1 < s.length() && curVal < map.get(s.charAt(i + 1))) {
                res += (map.get(s.charAt(i + 1)) - curVal);
                i++;
            } else {
                res += curVal;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int res = solution1.romanToInt("MCMXCIV");
        System.out.println(res);

    }

}
