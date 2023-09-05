package com.timberliu.algorithm.company.hw.volume_b.new_add.double_pointer.no073_2_stringCompare;

import java.util.Map;
import java.util.Scanner;

/**
 * 字符串比较
 *
 * @user liujie
 * @date 2023/9/5
 */
public class Solution1 {

    public static int stringCompare(String first, String second, int k) {
        int sum = 0;
        int maxLen = 0;
        int left = 0, right = 0;
        while (right < first.length()) {
            int diff = Math.abs(first.charAt(right) - second.charAt(right));
            sum += diff;
            if (sum <= k) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                }
            } else {
                while (left < first.length() && sum > k) {
                    diff = Math.abs(first.charAt(left) - second.charAt(left));
                    sum -= diff;
                    left++;
                }
            }
            right++;
        }
        return maxLen;
    }

    /**
     * xxcdefg
     * cdefghi
     * 5
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());

        int res = stringCompare(first, second, k);
        System.out.println(res);
    }

}
