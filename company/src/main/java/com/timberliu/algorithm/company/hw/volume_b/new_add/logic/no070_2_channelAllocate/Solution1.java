package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no070_2_channelAllocate;

import java.util.Scanner;

/**
 * 信道分配
 *
 * 5
 * 10 5 0 1 3 2
 * 30
 * 最大阶数为 5
 *  容量为 2^0 的信道有 10个
 *  容量为 2^1 的信道有 5个
 *  容量为 2^2 的信道有 0个
 *  容量为 2^3 的信道有 1个
 *  容量为 2^4 的信道有 3个
 *  容量为 2^5 的信道有 2个
 *
 * 从这些信道中，挑选几个进行组合，组合之和大于等于 d，问这种组合有多少个
 *
 *  求 d 的反序二进制数
 *     2^0 2^1 2^2 2^3 2^4 2^5
 *   n  10  5   0   1   3   2
 *   d  0   1   1   1   1
 *
 *   n  10  2   0   0   2
 *   d  0   1   1   1   1
 *
 *   n  0   0   0   0   1
 *   d  0   1   1   1   1
 *
 *  1. 超过 d.length 范围 arr[i]，表示单个信道就可以满足一个用户通道
 *
 *
 * @user liujie
 * @date 2023/8/31
 */
public class Solution1 {

    public static int channelAllocate(int r, int[] nums, int d) {
        String dStr = Integer.toBinaryString(d);
        int[] need = new int[dStr.length()];
        int needLen = dStr.length();
        for (int i = 0; i < needLen; i++) {
            need[i] = dStr.charAt(needLen - i - 1) - '0';
        }

        int count = 0;
        int numsLen = nums.length;
        // 超过 d 长度，单个信道可以满足一个用户容量
        if (numsLen > needLen) {
            for (int i = needLen; i < numsLen; i++) {
                count += nums[i];
            }
        }

        while (true) {
            // 从高位到低位 减
            int extra = 0;
            for (int i = needLen - 1; i >= 1; i--) {
                int diff = nums[i] - need[i] - extra;
                if (diff >= 0) {
                    nums[i] = diff;
                    extra = 0;
                } else {
                    nums[i] = 0;
                    extra = Math.abs(diff) * 2;
                }
            }
            nums[0] -= (need[0] + extra);

            boolean flag = false;
            if (nums[0] >= 0) {
                // nums[0] 大于 0 表示可以构造出和为 30 的组合
                count++;
            } else {
                // 还有可能构造出大于 30 的组合
                for (int i = 0; i < needLen; i++) {
                    if (nums[i] < 0) {
                        if (i + 1 < needLen) {
                            // 升阶
//                            nums[i + 1] += nums[i] >> 1;
                            nums[i + 1] -= (1 - nums[i]) / 2;
                            nums[i] = 0;
                        } else {
                            // 最后也没有抵消完，无法构造
                            flag = true;
                        }
                    } else {
                        // 抵消了负值，可以构造
                        count++;
                        break;
                    }
                }
            }

            if (flag) {
                break;
            }
        }
        return count;
    }

    /**
     * 5
     * 10 5 0 1 3 2
     * 30
     */
    /**
     * 5
     * 10 5 0 1 3 2
     * 47
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int[] arr = new int[r + 1];
        for (int i = 0; i <= r; i++) {
            arr[i] = scanner.nextInt();
        }
        int d = scanner.nextInt();

        int res = channelAllocate(r, arr, d);
        System.out.println(res);
    }

}
