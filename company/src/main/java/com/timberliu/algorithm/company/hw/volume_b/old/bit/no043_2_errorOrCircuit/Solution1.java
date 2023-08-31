package com.timberliu.algorithm.company.hw.volume_b.old.bit.no043_2_errorOrCircuit;

import java.util.Scanner;

/**
 * 分积木
 *
 * @user liujie
 * @date 2023/8/31
 */
public class Solution1 {

    public static int errorOrCircuit(int n, String first, String second) {
        // second 位为 0，对应 first 位上值为 0 的有 x 个
        int x = 0;
        // second 位为 0，对应 first 位上值为 1 的有 y 个
        int y = 0;
        // first 有 a 个 0
        int a = 0;
        // first 有 b 个 1
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (first.charAt(i) == '0') {
                a++;
                if (second.charAt(i) == '0') {
                    x++;
                }
            } else {
                b++;
                if (second.charAt(i) == '0') {
                    y++;
                }
            }
        }
        return x * b + y * a - x * y;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String first = scanner.next();
        String second = scanner.next();

        int res = errorOrCircuit(n, first, second);
        System.out.println(res);
    }

}
