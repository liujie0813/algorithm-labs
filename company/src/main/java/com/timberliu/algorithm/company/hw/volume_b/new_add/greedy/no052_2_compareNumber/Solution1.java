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
public class Solution1 {

    public static int compareNumber(int n, int[] first, int[] second) {
        Arrays.sort(first);
        Arrays.sort(second);

        int leftA = 0, rightA = n - 1;
        int leftB = 0, rightB = n - 1;
        int res = 0;
        while (leftA <= rightA) {
            if (first[rightA] > second[rightB]) {
                // 田忌最快的马，比齐王最快的马，还要快，则直接比
                res += 1;
                rightA--;
                rightB--;
            } else if (first[rightA] < second[rightB]) {
                // 田忌最快的马，比齐王最快的马，要慢，则用田忌最慢的马消耗掉齐王最快的马，以最小的代价输
                res--;
                leftA++;
                rightB--;
            } else {
                // 田忌最快的马，与齐王最快的马，速度相同，如果比，会消耗掉田忌最快的马
                // 可以用田忌必输的马消耗掉齐王最快的马
                if (first[leftA] > second[leftB]) {
                    // 田忌最慢的马，比齐王最慢的马，要快，则此时田忌最慢的马不是必输的马，继续寻找
                    res++;
                    leftA++;
                    leftB++;
                } else {
                    // 田忌最慢的马 <= 齐王最慢的马，则找到了必输或平局的马，此时应该让田忌最慢的马 消耗掉 齐王最快的马

                    // 如果田忌最慢的马 < 齐王最快的马，则田忌分数减1
                    // 如果田忌最慢的马 == 齐王最快的马，则田忌分数不变
                    if (first[leftA] < second[rightB]) {
                        res--;
                    }
                    leftA++;
                    rightB--;
                }
            }
        }
        return res;
    }

    /**
     * 9     3  2
     * 9     4  1
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
