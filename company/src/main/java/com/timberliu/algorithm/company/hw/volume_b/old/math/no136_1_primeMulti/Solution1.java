package com.timberliu.algorithm.company.hw.volume_b.old.math.no136_1_primeMulti;

import java.util.Scanner;

/**
 * 素数之积
 *
 * @user liujie
 * @date 2023/9/1
 */
public class Solution1 {

    public static String primeMulti(int n) {
        if (isPrime(n)) {
            return "-1 -1";
        }
        for (int i = 2; i < n; i++) {
            if (n % i != 0) {
                continue;
            }
            int j = n / i;
            if (isPrime(i) && isPrime(j)) {
                return i < j ? i + " " + j : j + " " + i;
            } else {
                // 如果 i 或 j 不是素数，说明 n 存在非素数因子，则 n 不可能是素数之积
                break;
            }
        }
        return "-1 -1";
    }

    /**
     * 素数只能被 1 和自身整除
     *  遍历 [2, sqrt(n)] 判断是否能整除
     */
    private static boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String res = primeMulti(n);
        System.out.println(res);
    }

}
