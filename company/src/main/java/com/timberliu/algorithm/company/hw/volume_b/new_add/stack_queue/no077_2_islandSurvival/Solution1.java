package com.timberliu.algorithm.company.hw.volume_b.new_add.stack_queue.no077_2_islandSurvival;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 荒岛求生
 *
 * @user liujie
 * @date 2023/9/12
 */
public class Solution1 {

    public static int surviveNum(int[] arr) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int val : arr) {
            if (val > 0) {
                stack.push(val);
            } else {
                while (!stack.isEmpty() && (val += stack.poll()) < 0) {
                }
                if (val > 0) {
                    stack.push(val);
                } else if (val < 0) {
                    res++;
                }
            }
        }
        return res + stack.size();
    }

    /*
     * 5 10 8 -8 -5
     */
    /*
     * 10 8 -19 10 -5
     */
    /**
     * 10 8 -18 10 -10
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(" ");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        int res = surviveNum(arr);
        System.out.println(res);
    }

}
