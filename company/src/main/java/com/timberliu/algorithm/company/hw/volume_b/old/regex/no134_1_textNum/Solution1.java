package com.timberliu.algorithm.company.hw.volume_b.old.regex.no134_1_textNum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 统计文本数量
 *
 *  文本条数，统计有效分号的个数
 *
 *  无效分号：
 *  - 成对双引号、成对单引号中的分号；
 *  - 注释符号后面的分号；
 *
 * @user liujie
 * @date 2023/9/1
 */
public class Solution1 {

    public static int textNum(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            line = line.replaceAll("\\[\"']", "") // 替换 \" \' 为空串
                    .replaceAll("\".+\"", "") // 替换成对双引号之间的内容
                    .replaceAll("'.+'", "") // 替换成对单引号之间的内容
                    .replaceAll("-.+", "") // 替换注释符的内容
                    .replaceAll("\\s+", "") // 替换空白字符
                    .replaceAll(";+", ";"); // 连续分号替换为一个
            sb.append(line);
        }
        // 文本最后一条可能没有 ;
        sb.append(";");
        // 连续分号替换为一个，去掉开头的分号
        String s = sb.toString().replaceAll(";+", ";").replaceAll("^;", "");
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ';') {
                res++;
            }
        }
        return res;
    }

    /**
     * abc;abc;
     * abc "a\"b;c"
     * abc 'a\'b;c';
     * abc -abc;
     * abc;
     * ;abc
     * abc;;
     * abc
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("".equals(line)) {
                scanner.close();
                break;
            }
            lines.add(line);
        }

        int res = textNum(lines);
        System.out.println(res);
    }

}
