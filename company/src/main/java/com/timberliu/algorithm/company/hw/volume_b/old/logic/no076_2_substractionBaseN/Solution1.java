package com.timberliu.algorithm.company.hw.volume_b.old.logic.no076_2_substractionBaseN;

import java.util.Scanner;

/**
 * 76. N 进制减法
 *
 * @user liujie
 * @date 2023/8/28
 */
public class Solution1 {

    public static String substractionBaseN(int n, String first, String second) {
        if (n < 2 || n > 35) {
            return "-1";
        }

        if (!isValid(first, n) || !isValid(second, n)) {
            return "-1";
        }
        long firstVal = Long.parseLong(first, n);
        long secondVal = Long.parseLong(second, n);
        String diff = Long.toString(Math.abs(firstVal - secondVal), n);
        String sign = firstVal >= secondVal ? "0" : "1";
        return sign + " " + diff;
    }

    private static boolean isValid(String str, int n) {
        if (str.startsWith("0")) {
            return "0".equals(str);
        }
        if (str.length() > 100) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                if (Integer.parseInt(String.valueOf(c)) >= n) {
                    return false;
                }
            } else if (c >= 'a' && c <= 'z') {
                if (c - 87 >= n) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        String first = scanner.next();
        String second = scanner.next();
        String res = substractionBaseN(n, first, second);
        System.out.println(res);
    }

}
