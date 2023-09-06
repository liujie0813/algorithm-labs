package com.timberliu.algorithm.company.hw.volume_b.old.stack_queue.no046_2_9boxInput;

import java.util.*;

/**
 * @user liujie
 * @date 2023/9/6
 */
public class Solution2 {

    public static String nineKeyInput(String str) {
        str += "/";
        boolean numMode = true;

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '#') {
                numMode = !numMode;
            } else if (ch != '/') {
                if (numMode) {
                    res.append(ch);
                } else {
                    int repeat = 1;
                    while (i + 1 < str.length() && str.charAt(i + 1) == ch) {
                        i++;
                        repeat++;
                    }
                    char transfer = transfer(ch, repeat);
                    res.append(transfer);
                }
            }
        }
        return res.toString();
    }

    private static char transfer(char ch, int repeat) {
        String str = map.get(ch);
        return str.charAt((repeat - 1) % str.length());
    }

    /*
     * 123#222235/56
     */
    /**
     * 123#22/222
     */
    private static final Map<Character, String> map = new HashMap<Character, String>() {{
        put('1', "j.");
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
        put('0', " ");
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        String res = nineKeyInput(str);
        System.out.println(res);
    }

}
