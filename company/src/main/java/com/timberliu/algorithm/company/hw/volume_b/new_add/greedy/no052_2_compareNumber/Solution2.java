package com.timberliu.algorithm.company.hw.volume_b.new_add.greedy.no052_2_compareNumber;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 数字序列比大小
 *
 * 田忌赛马
 *  用田忌"必输"且"最慢"的马 去消耗掉 齐王最快的马
 *
 *
 * @user liujie
 * @date 2023/9/11
 */
public class Solution2 {

    public static int compareNumber(int n, int[] first, int[] second) {
        Arrays.sort(first);
        Arrays.sort(second);

        int leftA = 0;
        int leftB = 0, rightB = n - 1;
        int res = 0;
        while (leftA < n) {
            if (first[leftA] > second[leftB]) {
                // 田忌最慢的马，比齐王最慢的马，还要快，则直接比，田忌赢
                res += 1;
                leftA++;
                leftB++;
            } else {
                // 田忌最慢的马，比齐王最慢的马，要慢，则用田忌最慢的马消耗掉齐王最快的马，以最小的代价输
                if (first[leftA] < second[rightB]) {
                    res--;
                }
                leftA++;
                rightB--;
            }
        }
        return res;
    }

    /*
     * 2 3 4
     * 1 2 3
     */
    /*
     * 3 4 5
     * 4 5 6
     */
    /**
     * 1 1 3
     * 1 1 3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] first = new int[n];
        int[] second = new int[n];

        int res = compareNumber(n, first, second);
        System.out.println(res);
    }

}
