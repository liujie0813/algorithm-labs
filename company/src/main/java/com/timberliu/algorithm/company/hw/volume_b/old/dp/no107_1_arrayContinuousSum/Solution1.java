package com.timberliu.algorithm.company.hw.volume_b.old.dp.no107_1_arrayContinuousSum;

import java.util.Scanner;

/**
 * 数组连续和
 *
 * @user liujie
 * @date 2023/9/8
 */
public class Solution1 {

    public static int arrayContinuousSum(int n, int[] arr, int x) {
        int res = 0;
        int left = 0, right = 0;
        int sum = 0;
        while (right < n) {
            sum += arr[right];
            if (sum >= x) {
                res += n - right;
                while (true) {
                    sum -= arr[left];
                    left++;
                    if (sum >= x) {
                        res += n - right;
                    } else {
                        break;
                    }
                }
            }
            right++;
        }
        return res;
    }

    /*
     * 3 7
     * 3 4 7
     */
    /**
     * 7 7
     * 1 2 3 4 5 6 7
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int res = arrayContinuousSum(n, arr, x);
        System.out.println(res);
    }

}
