package com.timberliu.algorithm.company.hw.volume_b.new_add.binary_search.no046_1_birthdayGift;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 生日礼物
 *
 * @user liujie
 * @date 2023/9/5
 */
public class Solution1 {

    public static int birthdayGift(int[] first, int[] second, int x) {
        int[] min, max;
        if (first.length < second.length) {
            min = first;
            max = second;
        } else {
            min = second;
            max = first;
        }

        Arrays.sort(max);
        int res = 0;
        for (int j : min) {
            if (j >= x) {
                continue;
            }
            int target = x - j;

            int left = 0, right = max.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (max[mid] == target) {
                    if (mid + 1 == max.length || max[mid + 1] != target) {
                        left = mid;
                        break;
                    } else {
                        left = mid + 1;
                    }
                } else if (max[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left < max.length && max[left] == target) {
                res += (left + 1);
            } else {
                res += left;
            }
        }
        return res;
    }

    /**
     * 10,20,5
     * 5,5,2
     * 15
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstSplit = scanner.nextLine().split(",");
        int[] first = new int[firstSplit.length];
        for (int i = 0; i < firstSplit.length; i++) {
            first[i] = Integer.parseInt(firstSplit[i]);
        }
        String[] secondSplit = scanner.nextLine().split(",");
        int[] second = new int[secondSplit.length];
        for (int i = 0; i < secondSplit.length; i++) {
            second[i] = Integer.parseInt(secondSplit[i]);
        }
        int x = Integer.parseInt(scanner.nextLine());

        int res = birthdayGift(first, second, x);
        System.out.println(res);
    }


}
