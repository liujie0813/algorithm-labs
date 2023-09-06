package com.timberliu.algorithm.company.hw.volume_b.old.stack_queue.no048_2_findMinNum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 找最小数
 *
 * @user liujie
 * @date 2023/9/6
 */
public class Solution1 {

    public static int findMinNum(int num, int k) {
        char[] chars = String.valueOf(num).toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            while (!stack.isEmpty() && stack.peek() > chars[i] && k > 0) {
                stack.poll();
                k--;
            }
            stack.push(chars[i]);
        }
        int res = 0;
        int index = 0;
        while (!stack.isEmpty()) {
            res += Math.pow(10, index) * (stack.poll() - '0');
            index++;
        }
        return res;
    }

    /**
     * 2615372
     * 4
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int k = scanner.nextInt();

        int res = findMinNum(num, k);
        System.out.println(res);
    }

}
