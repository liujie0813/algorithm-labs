package com.timberliu.algorithm.company.hw.volume_b.new_add.prefix_sum.no032_2_numberGame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 数字游戏
 *
 *  a-b 能被 k 整除  <=>  a % k = b % k
 *
 *  如果存在两个前缀和对 k 取余相等，就说明存在区间和可以整除 k
 *
 * @user liujie
 * @date 2023/9/8
 */
public class Solution1 {

    public static int numberGame(int m, int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int a : arr) {
            sum += a;
            if (set.contains(sum % m)) {
                return 1;
            } else {
                set.add(sum % m);
            }
        }
        return 0;
    }

    /**
     * 6 7
     * 2 12 6 3 5 5
     * 10 11
     * 1 1 1 1 1 1 1 1 1 1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] splits1 = scanner.nextLine().split(" ");
            int n = Integer.parseInt(splits1[0]);
            int m = Integer.parseInt(splits1[1]);
            String[] splits2 = scanner.nextLine().split(" ");
            int[] arr = new int[splits2.length];
            for (int i = 0; i < splits2.length; i++) {
                arr[i] = Integer.parseInt(splits2[i]);
            }

            int res = numberGame(m, arr, n);
            System.out.println(res);
        }

    }

}
