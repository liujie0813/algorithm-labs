package com.timberliu.algorithm.company.hw.volume_b.new_add.double_pointer.no087_2_longestLen;

import java.util.Scanner;

/**
 * 最长的顺子
 *
 * @user liujie
 * @date 2023/9/5
 */
public class Solution1 {

    public static String longestLen(String[] cur, String[] used) {
        int[] cnt = new int[12];
        for (String s : cur) {
            getCnt(cnt, s);
        }
        for (String s : used) {
            getCnt(cnt, s);
        }
        for (int i = 0; i < cnt.length; i++) {
            cnt[i] = 4 - cnt[i];
        }

        int maxLen = 5;
        int startIndex = -1;
        int left = 0, right = 0;
        while (right < cnt.length) {
            if (cnt[right] > 0) {
                if (right - left + 1 >= maxLen) {
                    maxLen = right - left + 1;
                    startIndex = left;
                }
                right++;
            } else {
                right++;
                left = right;
            }
        }
        if (startIndex == -1) {
            return "NO-CHAIN";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            int index = i + startIndex;
            if (index < 7) {
                sb.append(index + 3);
            } else if (index == 7) {
                sb.append("10");
            } else if (index == 8) {
                sb.append("J");
            } else if (index == 9) {
                sb.append("Q");
            } else if (index == 10) {
                sb.append("K");
            } else if (index == 11) {
                sb.append("A");
            }
            if (i < maxLen - 1) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    private static void getCnt(int[] cnt, String s) {
        switch (s) {
            case "10": cnt[7]++;
                break;
            case "J": cnt[8]++;
                break;
            case "Q": cnt[9]++;
                break;
            case "K": cnt[10]++;
                break;
            case "A": cnt[11]++;
                break;
            default:
                cnt[s.charAt(0) - '3']++;
                break;
        }
    }

    /**
     * 3-3-3-3-4-4-5-5-6-7-8-9-10-J-Q-K-A
     * 4-5-6-7-8-8-8
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cur = scanner.nextLine().split("-");
        String[] used = scanner.nextLine().split("-");

        String res = longestLen(cur, used);
        System.out.println(res);
    }

}
