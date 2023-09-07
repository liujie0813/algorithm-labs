package com.timberliu.algorithm.company.hw.volume_b.new_add.stack_queue.no067_1_numberOff;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 报数游戏
 *
 * @user liujie
 * @date 2023/9/7
 */
public class Solution1 {

    public static String numberOff(int n) {
        if (n <= 1 || n >= 100) {
            return "ERROR";
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {
            deque.offer(i);
        }

        int index = 1;
        while (deque.size() >= n) {
            if (index == n) {
                deque.pollFirst();
                index = 1;
            } else {
                deque.offer(deque.pollFirst());
                index++;
            }
        }

        StringJoiner stringJoiner = new StringJoiner(",");
        deque.stream().sorted().forEach(a -> stringJoiner.add(String.valueOf(a)));
        return stringJoiner.toString();
    }

    /**
     * 4
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String res = numberOff(n);
        System.out.println(res);
    }

}
