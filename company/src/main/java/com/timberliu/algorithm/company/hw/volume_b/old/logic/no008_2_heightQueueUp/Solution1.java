package com.timberliu.algorithm.company.hw.volume_b.old.logic.no008_2_heightQueueUp;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.Scanner;

/**
 * 高矮个子排队
 *
 * @user liujie
 * @date 2023/9/5
 */
public class Solution1 {

    public static void heightQueueUp(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if ((i % 2 == 0 && arr[i] < arr[i + 1]) ||
                    (i % 2 == 1 && arr[i] > arr[i + 1])) {
                int tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }
    }

    /**
     * 4 1 3 5 2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(" ");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        heightQueueUp(arr);
        PrintUtils.printIntArrayV2(arr);
    }

}
