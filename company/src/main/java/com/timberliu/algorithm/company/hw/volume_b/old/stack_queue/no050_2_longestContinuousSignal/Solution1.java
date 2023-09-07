package com.timberliu.algorithm.company.hw.volume_b.old.stack_queue.no050_2_longestContinuousSignal;

import java.util.Scanner;

/**
 * 最长连续方波信号
 *
 * @user liujie
 * @date 2023/9/7
 */
public class Solution1 {

    public static String longestContinuousSignal(String str) {
        str += "0";
        String res = "";
        int left = 0, right = 0;
        while (right < str.length()) {
            if (right > 0 && str.charAt(right) == '0' && str.charAt(right - 1) == '0') {
                String substring = str.substring(left, right);
                // 前面是一个或多个 01，结尾是 0
                if (substring.matches("^(01)+0$") && substring.length() > res.length()) {
                    res = substring;
                }
                left = right;
            }
            right++;
        }
        return res;
    }

    /*
     * 00101010101100001010010
     */
    /**
     * 010010101010
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String res = longestContinuousSignal(str);
        System.out.println(res);
    }

}
