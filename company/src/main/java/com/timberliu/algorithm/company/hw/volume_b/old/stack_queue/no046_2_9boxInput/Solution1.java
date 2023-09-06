package com.timberliu.algorithm.company.hw.volume_b.old.stack_queue.no046_2_9boxInput;

import java.util.*;

/**
 * @user liujie
 * @date 2023/9/6
 */
public class Solution1 {

    public static String nineKeyInput(String str) {
        str += "/";
        boolean numMode = true;
        Deque<Character> stack = new LinkedList<>();
        int repeat = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '#') {
                if (!numMode) {
                    interrupt(stack, repeat);
                    repeat = 0;
                }
                numMode = !numMode;
            } else if (ch == '/') {
                if (!numMode) {
                    interrupt(stack, repeat);
                    repeat = 0;
                }
            } else {
                if (numMode) {
                    stack.push(ch);
                } else if (stack.isEmpty()) {
                    stack.push(ch);
                    repeat = 1;
                } else {
                    if (stack.peek() == ch) {
                        repeat++;
                    } else {
                        interrupt(stack, repeat);
                        stack.push(ch);
                        repeat = 1;
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollLast());
        }
        return res.toString();
    }

    private static void interrupt(Deque<Character> stack, int repeat) {
        if (stack.isEmpty() || repeat == 0) {
            return;
        }
        Character poll = stack.poll();
        String str = map.get(poll - '0');
        char ch = str.charAt((repeat - 1) % str.length());
        stack.push(ch);
    }

    /**
     * 123#222235/56
     */
    private static final Map<Integer, String> map = new HashMap<Integer, String>() {{
        put(1, "j.");
        put(2, "abc");
        put(3, "def");
        put(4, "ghi");
        put(5, "jkl");
        put(6, "mno");
        put(7, "pqrs");
        put(8, "tuv");
        put(9, "wxyz");
        put(0, " ");
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String res = nineKeyInput(str);
        System.out.println(res);
    }

}
