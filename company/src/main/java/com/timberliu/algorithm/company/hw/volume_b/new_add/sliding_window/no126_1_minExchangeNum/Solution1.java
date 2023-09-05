package com.timberliu.algorithm.company.hw.volume_b.new_add.sliding_window.no126_1_minExchangeNum;

import java.util.Scanner;

/**
 * 最少交换次数
 *
 * @user liujie
 * @date 2023/9/5
 */
public class Solution1 {

    public static int minExchangeNum(int[] arr, int k) {
        int len = 0;
        for (int a : arr) {
            if (a < k) {
                len++;
            }
        }

        int res = Integer.MAX_VALUE;
        int cur = 0;
        int left = 0, right = 0;
        while (right < arr.length) {
            if (right >= len) {
                if (arr[left] >= k) {
                    cur--;
                }
                left++;
            }
            if (arr[right] >= k) {
                cur++;
            }
            if (right >= len) {
                res = Math.min(res, cur);
            }
            right++;
        }
        return res;
    }

    /**
     * 1 3 1 4 0
     * 2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(" ");
        int[] arr = new int[splits.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }
        int k = Integer.parseInt(scanner.nextLine());

        int res = minExchangeNum(arr, k);
        System.out.println(res);
    }

}
