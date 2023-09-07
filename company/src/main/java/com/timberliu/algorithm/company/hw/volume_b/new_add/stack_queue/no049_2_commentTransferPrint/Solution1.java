package com.timberliu.algorithm.company.hw.volume_b.new_add.stack_queue.no049_2_commentTransferPrint;

import java.util.*;

/**
 * 评论转换输出
 *
 * @user liujie
 * @date 2023/9/7
 */
public class Solution1 {

    public static String commentTransferPrint(String str) {
        Deque<String[]> comments = new LinkedList<>();
        String[] splits = str.split(",");
        for (int i = 0; i < splits.length - 1; i += 2) {
            comments.add(new String[]{splits[i], splits[i + 1]});
        }

        List<List<String>> list = new ArrayList<>();
        while (!comments.isEmpty()) {
            doTransfer(comments, 0, list);
        }

        StringBuilder res = new StringBuilder();
        res.append(list.size()).append("\n");
        for (List<String> strings : list) {
            for (String s : strings) {
                res.append(s).append(" ");
            }
            res.append("\n");
        }
        return res.toString();
    }

    private static void doTransfer(Deque<String[]> comments, int level, List<List<String>> list) {
        String[] comment = comments.poll();
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(comment[0]);

        int size = Integer.parseInt(comment[1]);
        for (int i = 0; i < size; i++) {
            doTransfer(comments, level + 1, list);
        }
    }

    /**
     * hello,2,ok,0,bye,0,test,0,one,1,two,1,a,0
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String res = commentTransferPrint(str);
        System.out.println(res);
    }

}
