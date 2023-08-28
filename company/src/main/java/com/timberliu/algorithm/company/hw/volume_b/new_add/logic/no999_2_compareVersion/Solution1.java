package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no999_2_compareVersion;

import java.util.Scanner;

/**
 * 比较两个版本号的大小
 *
 * ascii
 *
 * 48-57   数字
 * 65-90   大写字母
 * 97-122  小写字母
 *
 * @user liujie
 * @date 2023/8/28
 */
public class Solution1 {

    public static int compareVersion(String first, String second) {
        String[] firstSplits = first.split("\\.");
        String[] secondSplits = second.split("\\.");
        int i = 0, j = 0;
        while (i < firstSplits.length || j < secondSplits.length) {
            if (i == firstSplits.length) {
                return -1;
            }
            if (j == second.length()) {
                return 1;
            }
            String firstStr = firstSplits[i];
            String secondStr = secondSplits[i];
            if (isDigit(firstStr) && isDigit(secondStr)) {
                int firstDigit = Integer.parseInt(firstStr);
                int secondDigit = Integer.parseInt(secondStr);
                if (firstDigit > secondDigit) {
                    return 1;
                } else if (firstDigit < secondDigit) {
                    return -1;
                }
            } else {
                firstStr = first.replaceAll("0", "");
                secondStr = second.replaceAll("0", "");
                int res = firstStr.compareTo(secondStr);
                if (res > 0) {
                    return 1;
                } else if (res < 0) {
                    return -1;
                }
            }
            i++;
            j++;
        }
        return 0;
    }

    private static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /*
     * 5.2
     * 5.1a
     */
    /*
     * 5.6.1
     * 5.6.2a
     */
    /**
     * 5.6.8.a
     * 5.6.8.0a
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        int res = compareVersion(first, second);
        System.out.println(res);
    }

}
