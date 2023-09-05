package com.timberliu.algorithm.company.hw.volume_b.new_add.double_pointer.no127_2_buildBlock;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 叠积木
 *
 * @user liujie
 * @date 2023/9/5
 */
public class Solution1 {

    public static int buildBlock(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(arr);
        int minLen = arr[n - 1];
        int maxLen = arr[n - 1] + arr[n - 2];
        for (int len = minLen; len <= maxLen; len++) {
            int height = 0;
            int l = 0, r = n - 1;
            // 判断较长的积木可以单独成一层
            while (r >= 0 && arr[r] == len) {
                r--;
                height++;
            }
            // 判断一个较长的和一个较短的可以拼成一层
            while (l < r) {
                if (arr[l] + arr[r] != len) {
                    break;
                }
                l++;
                r--;
                height++;
            }
            if (l > r) {
                return height;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(" ");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        int res = buildBlock(arr);
        System.out.println(res);
    }

}
