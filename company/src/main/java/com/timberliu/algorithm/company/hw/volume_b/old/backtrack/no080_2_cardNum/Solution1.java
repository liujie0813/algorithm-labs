package com.timberliu.algorithm.company.hw.volume_b.old.backtrack.no080_2_cardNum;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * 连续出牌数量
 *
 * @user liujie
 * @date 2023/9/1
 */
public class Solution1 {

    public static int cardNum(int[] nums, String[] colors) {
        int[] res = new int[1];
        backtrack(nums, colors, -1, 0, new boolean[nums.length], res);
        return res[0];
    }

    private static void backtrack(int[] nums, String[] colors, int last, int curNum, boolean[] used, int[] res) {
        res[0] = Math.max(res[0], curNum);
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (last == -1 || (nums[i] == nums[last] || colors[i].equals(colors[last]))) {
                used[i] = true;
                backtrack(nums, colors, i, curNum + 1, used, res);
                used[i] = false;
            }
        }
    }

    /**
     * 1 4 3 4 5
     * r y b b r
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] colors = scanner.nextLine().split(" ");

        int res = cardNum(nums, colors);
        System.out.println(res);
    }

}
