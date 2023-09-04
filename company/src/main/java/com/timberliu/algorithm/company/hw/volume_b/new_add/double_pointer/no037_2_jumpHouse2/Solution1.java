package com.timberliu.algorithm.company.hw.volume_b.new_add.double_pointer.no037_2_jumpHouse2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 跳房子2
 *
 * @user liujie
 * @date 2023/9/4
 */
public class Solution1 {

    public static int[] jumpHouse2(int[] arr, int count) {
        int n = arr.length;
        int[][] steps = new int[n][2];
        for (int i = 0; i < n; i++) {
            steps[i] = new int[]{arr[i], i};
        }
        Arrays.sort(steps, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int minIndexSum = Integer.MAX_VALUE;
        int[][] res = null;
        for (int i = 0; i < n; i++) {
            if (steps[i][0] > count && count > 0 && steps[i][0] > 0) {
                break;
            }
            if (i > 0 && steps[i][0] == steps[i - 1][0]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = steps[i][0] + steps[left][0] + steps[right][0];
                if (sum < count) {
                    left++;
                } else if (sum > count) {
                    right--;
                } else {
                    // 重复
                    while (left < right - 1 && steps[right][0] == steps[right - 1][0]) {
                        right--;
                    }

                    int indexSum = steps[i][1] + steps[left][1] + steps[right][1];
                    if (indexSum < minIndexSum) {
                        minIndexSum = indexSum;
                        res = new int[][]{steps[i], steps[left], steps[right]};
                    }
                    // 重复
                    while (left < right - 1 && steps[left][0] == steps[left + 1][0]) {
                        left++;
                    }
                    left++;
                    right--;
                }
            }
        }

        Arrays.sort(res, Comparator.comparing(a -> a[1]));
        return new int[]{res[0][0], res[1][0], res[2][0]};
    }

    /**
     * [1,4,5,2,0,2]
     * 9
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] splits = line.substring(1, line.length() - 1).split(",");
        int[] arr = new int[splits.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }
        int count = scanner.nextInt();

        int[] res = jumpHouse2(arr, count);
        System.out.println("[" + res[0] + "," + res[1] + "," + res[2] + "]");
    }

}
