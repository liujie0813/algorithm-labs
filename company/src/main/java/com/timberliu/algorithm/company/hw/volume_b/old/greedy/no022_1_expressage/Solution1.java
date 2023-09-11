package com.timberliu.algorithm.company.hw.volume_b.old.greedy.no022_1_expressage;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 快递运输
 *
 * @user liujie
 * @date 2023/9/11
 */
public class Solution1 {

    public static int maxExpressCnt(int[] arr, int n) {
        Arrays.sort(arr);
        int count = 0;
        int sum = 0;
        for (int i : arr) {
            sum += i;
            if (sum > n) {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(",");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }
        int n = scanner.nextInt();

        int res = maxExpressCnt(arr, n);
        System.out.println(res);
    }

}
