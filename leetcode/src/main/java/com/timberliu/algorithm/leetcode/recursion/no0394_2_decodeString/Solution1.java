package com.timberliu.algorithm.leetcode.recursion.no0394_2_decodeString;

/**
 * 394. 字符串解码
 *
 * Created by liujie on 2021/4/1
 */

public class Solution1 {

    public static String decodeString(String s) {
        // [0, s.length) 前闭后开
        return doDecodeString(s, 0, s.length());
    }

    private static String doDecodeString(String str, int left, int right) {
        StringBuilder res = new StringBuilder();
        int digit = 0;
        while (left < right) {
            // 计算重复次数
            if (str.charAt(left) >= '0' && str.charAt(left) <= '9') {
                digit = 10 * digit + Integer.parseInt(String.valueOf(str.charAt(left)));
            } else if (str.charAt(left) == '[') {
                int start = left;
                String tmpRes = "";
                // 统计 [] 出现次数
                int bal = 0;
                while (left < right) {
                    if (str.charAt(left) == '[') {
                        bal++;
                    } else if (str.charAt(left) == ']') {
                        bal--;
                    }
                    if (bal == 0) {
                        // [ 和 ] 次数相等时，递归计算
                        tmpRes = doDecodeString(str, start + 1, left);
                        break;
                    }
                    left++;
                }
                for (int j = 0; j < digit; j++) {
                    res.append(tmpRes);
                }
                digit = 0;
            // 如果是字母，直接添加到 res
            } else {
                res.append(str.charAt(left));
            }
            left++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/decode-string/ -----");
        System.out.println("----- 1 -----");
        System.out.println(decodeString("3[a]2[bc]"));

        System.out.println("----- 2 -----");
        System.out.println(decodeString("3[a2[c]]"));

        System.out.println("----- 3 -----");
        System.out.println(decodeString("2[abc]3[cd]ef"));

        System.out.println("----- 4 -----");
        System.out.println(decodeString("abc3[cd]xyz"));

    }
}
