package com.timberliu.algorithm.company.hw.volume_b.old.tree.no084_2_treeInorderTraversal;

import java.util.*;

/**
 * 二叉树中序遍历
 *
 * @user liujie
 * @date 2023/9/7
 */
public class Solution1 {

    public static String inOrderTraversal(String str) {
        Deque<String> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '}') {
                // 从弹出元素，直到遇到 {
                List<String> list = new ArrayList<>();
                String s;
                while (!"{".equals((s = stack.poll()))) {
                    list.add(s);
                }
                String root = stack.poll();
                if (list.size() == 1) {
                    // 只有左子节点
                    stack.push(list.get(0) + root);
                } else if (list.size() == 2) {
                    // 只有右子节点
                    stack.push(root + list.get(0));
                } else {
                    // 左右子节点
                    stack.push(list.get(2) + root + list.get(0));
                }
            } else {
                stack.push(String.valueOf(ch));
            }
        }
        return stack.peek();
    }

    /**
     * a{b{d,e{g,h{,i}}},c{f}}
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String res = inOrderTraversal(str);
        System.out.println(res);
    }

}
