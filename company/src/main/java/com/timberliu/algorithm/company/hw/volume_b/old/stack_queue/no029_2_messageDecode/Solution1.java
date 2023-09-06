package com.timberliu.algorithm.company.hw.volume_b.old.stack_queue.no029_2_messageDecode;

import java.util.*;

/**
 * 报文解压缩
 *
 * @user liujie
 * @date 2023/9/6
 */
public class Solution1 {

    public static String messageDecode(String str) {
        Deque<String> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                int val = ch - '0';
                while (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))) {
                    val = val * 10 + (str.charAt(i + 1) - '0');
                    i++;
                }
                stack.push(String.valueOf(val));
            } else if (ch != ']') {
                stack.push(String.valueOf(ch));
            } else {
                List<String> list = new LinkedList<>();
                String poll = "";
                while (!"[".equals(( poll = stack.poll()))) {
                    list.add(0, poll);
                }
                int num = Integer.parseInt(stack.poll());
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    for (String s : list) {
                        sb.append(s);
                    }
                }
                stack.push(sb.toString());
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pollLast());
        }
        return res.toString();
    }

    /**
     * 3[m10[ab]c]
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String res = messageDecode(str);
        System.out.println(res);
    }

}
