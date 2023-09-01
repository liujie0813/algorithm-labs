package com.timberliu.algorithm.company.hw.volume_b.old.math.no999_1_permutation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @user liujie
 * @date 2023/9/1
 */
public class Solution1 {

    public static int permutation(String str) {
        int total = factorial(str.length());

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Integer cnt : map.values()) {
            total /= factorial(cnt);
        }
        return total;
    }

    private static int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();

        int res = permutation(line);
        System.out.println(res);
    }

}
