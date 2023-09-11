package com.timberliu.algorithm.company.hw.volume_b.new_add.greedy.no062_1_giftGroup;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 礼品发放的分组数目
 *
 * @user liujie
 * @date 2023/9/11
 */
public class Solution1 {

    public static int minGiftGroup(int limit, int[] gifts) {
        Arrays.sort(gifts);
        int count = 0;
        int left = 0, right = gifts.length - 1;
        while (left <= right) {
            if (gifts[left] + gifts[right] <= limit) {
                count++;
                left++;
                right--;
            } else {
                count++;
                right--;
            }
        }
        return count;
    }

    /**
     * 5
     * 1 2 5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = Integer.parseInt(scanner.nextLine());
        String[] splits = scanner.nextLine().split(" ");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        int res = minGiftGroup(limit, arr);
        System.out.println(res);
    }

}
