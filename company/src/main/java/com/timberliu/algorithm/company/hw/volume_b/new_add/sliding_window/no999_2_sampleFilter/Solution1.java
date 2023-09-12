package com.timberliu.algorithm.company.hw.volume_b.new_add.sliding_window.no999_2_sampleFilter;

import java.util.Scanner;

/**
 * 采样过滤
 *
 * @user liujie
 * @date 2023/9/12
 */
public class Solution1 {

    private static final int NORMAL = 1;
    private static final int FAULT = 2;
    private static final int ABORT = 3;
    private static final int RECOVERY_NORMAL = 4;
    private static final int RECOVERY_FAULT = 5;

    /**
     *
     * @param m 工具故障周期
     * @param t 错误次数
     * @param p 故障恢复周期
     * @param arr 状态
     */
    public static int longest(int m, int t, int p, int[] arr) {
        int[] status = new int[arr.length];

        int faultCnt = 0;
        // 滑动窗口左边界
        int left = 0;
        // right 右边界
        for (int right = 0; right < arr.length; right++) {
            // 超过窗口长度，左边界移动一位
            if (right - left + 1 > m) {
                if (status[left] == FAULT) {
                    faultCnt--;
                }
                left++;
            }
            // 检测正常
            if (checkNormal(arr, status, right)) {
                status[right] = NORMAL;
                continue;
            }
            // 如果前面没有正常值，则丢弃
            if (right == 0 || status[right - 1] == ABORT) {
                status[right] = ABORT;
                faultCnt = 0;
                left = right + 1;
            } else {
                // 前面有正常值
                faultCnt++;
                // 检测到故障前，错误数据由最近一个正常值代替
                if (faultCnt < t) {
                    status[right] = FAULT;
                    arr[right] = arr[right - 1];
                } else {
                    // 到达错误阈值，丢弃从故障开始到故障恢复的数据
                    status[right] = ABORT;
                    faultCnt = 0;

                    // 连续 p 个周期内采样正常，故障恢复
                    int correctCnt = 0;
                    int i = right + 1;
                    while (i < arr.length) {
                        if (checkRecovery(arr, status, i)) {
                            correctCnt++;
                            status[i] = RECOVERY_NORMAL;
                            if (correctCnt == p) {
                                break;
                            }
                        } else {
                            correctCnt = 0;
                            status[i] = RECOVERY_FAULT;
                        }
                        i++;
                    }
                    if (i < arr.length) {
                        left = i + 1;
                        right = i;
                    }
                }
            }
        }

        int max = 0;
        int len = 0;
        for (int s : status) {
            if (s == NORMAL || s == FAULT) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 0;
            }
        }
        return Math.max(max, len);
    }

    private static boolean checkNormal(int[] arr, int[] status, int cur) {
        if (arr[cur] <= 0) {
            return false;
        }
        // 正常值，或者由正常值代替的错误值
        if (cur > 0 && (status[cur - 1] == NORMAL || status[cur - 1] == FAULT)) {
            if (arr[cur] < arr[cur - 1]) {
                return false;
            }
            if (arr[cur] - arr[cur - 1] >= 10) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRecovery(int[] arr, int[] status, int cur) {
        if (arr[cur] <= 0) {
            return false;
        }
        // 检测到故障丢弃数据后的第一个
        // 故障恢复期间数据出现错误后的第一个
        // 不需要与前一个比较
        if (cur > 0 && status[cur - 1] != ABORT && status[cur - 1] != RECOVERY_FAULT) {
            if (arr[cur] < arr[cur - 1]) {
                return false;
            }
            if (arr[cur] - arr[cur - 1] >= 10) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int t = scanner.nextInt();
        int p = scanner.nextInt();
        scanner.nextLine();
        String[] splits = scanner.nextLine().split(" ");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        int res = longest(m, t, p, arr);
        System.out.println(res);
    }

}
