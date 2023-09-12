package com.timberliu.algorithm.company.hw.volume_b.new_add.prefix_sum.no095_1_stringSplit;

import java.util.Scanner;

/**
 * 字符串划分
 *
 * @user liujie
 * @date 2023/9/11
 */
public class Solution1 {

    public static int[] stringSplit(String str) {
        int[] prefixSum = new int[str.length()];
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - 'a';
            prefixSum[i] = sum;
        }

        for (int i = 1; i < str.length() - 3; i++) {
            for (int j = i + 2; j < str.length() - 1; j++) {
                int left = prefixSum[i - 1];
                int mid = prefixSum[j - 1] - prefixSum[i];
                int right = prefixSum[str.length() - 1] - prefixSum[j];
                if (left == mid && mid == right) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    /*
     * acdbbbca
     */
    /**
     * abcabc
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int[] res = stringSplit(str);
        System.out.println(res[0] + "," + res[1]);
    }

}
