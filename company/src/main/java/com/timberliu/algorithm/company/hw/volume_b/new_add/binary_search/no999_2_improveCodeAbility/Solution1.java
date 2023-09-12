package com.timberliu.algorithm.company.hw.volume_b.new_add.binary_search.no999_2_improveCodeAbility;

import java.util.Scanner;

/**
 * 编码能力提升
 *
 *  最大值最小化问题 - 二分
 *
 *  左边界：每天不足一题，每天看答案，left=0
 *  右边界：一天看所有题，耗时最多的题看答案，right=sum-max
 *
 * @user liujie
 * @date 2023/9/12
 */
public class Solution1 {

    public static int minCost(int[] arr, int m) {
        int sum = 0;
        int max = 0;
        for (int a : arr) {
            sum += a;
            max = Math.max(max, a);
        }

        int res = 0;
        int left = 0, right = sum - max;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (complete(arr, m, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    private static boolean complete(int[] arr, int m, int maxCost) {
        int day = 1;
        int curMax = 0, cost = 0;
        boolean answer = true;

        int i = 0;
        while (i < arr.length) {
            curMax = Math.max(curMax, arr[i]);
            cost += arr[i];
            if (cost > maxCost) {
                if (answer) {
                    cost -= curMax;
                    answer = false;
                    i++;
                } else {
                    day++;
                    cost = 0;
                    curMax = 0;
                    answer = true;
                }
            } else {
                i++;
            }
        }
        return day <= m;
    }

    /**
     * 1,2,2,3,5,4,6,7,8
     * 5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(",");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        int m = scanner.nextInt();
        int res = minCost(arr, m);
        System.out.println(res);
    }

}
