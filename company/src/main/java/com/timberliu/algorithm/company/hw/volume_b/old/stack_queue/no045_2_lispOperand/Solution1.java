package com.timberliu.algorithm.company.hw.volume_b.old.stack_queue.no045_2_lispOperand;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * 仿 LISP 运算
 *
 * @user liujie
 * @date 2023/9/6
 */
public class Solution1 {

    public static String lispOperation(String str) {
        Deque<String> operator = new LinkedList<>();
        Deque<Integer> operand = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                String cmd = str.substring(i, i + 3);
                operator.push(cmd);
                i += 2;
            } else if (Character.isDigit(ch) || ch == '-') {
                int val = ch - '0';
                boolean negative = false;
                if (ch == '-') {
                    negative = true;
                    i++;
                    val = 0;
                }
                while (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))) {
                    val = val * 10 + (str.charAt(i + 1) - '0');
                    i++;
                }
                operand.push(negative ? -val : val);
            } else if (ch == ')') {
                boolean flag = compute(operator, operand);
                if (!flag) {
                    return "error";
                }
            }
        }
        while (operand.size() > 1) {
            boolean flag = compute(operator, operand);
            if (!flag) {
                return "error";
            }
        }
        return String.valueOf(operand.peek());
    }

    private static boolean compute(Deque<String> operator, Deque<Integer> operand) {
        String cmd = operator.poll();
        Integer second = operand.poll();
        Integer first = operand.poll();

        int val = 0;
        switch (cmd) {
            case "add":
                val = first + second;
                break;
            case "sub":
                val = first - second;
                break;
            case "mul":
                val = first * second;
                break;
            case "div":
                if (second == 0) {
                    return false;
                }
                val = Math.floorDiv(first, second);
        }
        operand.push(val);
        return true;
    }

    /*
     * (div 12 (sub 45 45))
     */
    /**
     * (add 1 (div -7 3))
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String res = lispOperation(str);
        System.out.println(res);
    }

}
