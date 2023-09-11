package com.timberliu.algorithm.company.hw.volume_b.old.greedy.no049_2_eatHotpot;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 导师请吃火锅
 *
 * @user liujie
 * @date 2023/9/11
 */
public class Solution1 {

    public static int maxNum(int[][] arr, int n, int m) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        int cnt = 1;
        int last = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (last + m <= arr[i][1]) {
                cnt++;
                last = arr[i][1];
            }
        }
        return cnt;
    }

    /**
     * 4 2
     * 1 1
     * 2 1
     * 3 1
     * 4 1
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = arr[i][0] + scanner.nextInt();
        }

        int res = maxNum(arr, n, m);
        System.out.println(res);
    }

}
