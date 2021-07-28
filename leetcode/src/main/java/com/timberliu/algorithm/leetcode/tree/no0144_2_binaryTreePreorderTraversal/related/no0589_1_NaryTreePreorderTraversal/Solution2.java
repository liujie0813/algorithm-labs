package com.timberliu.algorithm.leetcode.tree.no0144_2_binaryTreePreorderTraversal.related.no0589_1_NaryTreePreorderTraversal;

import com.timberliu.algorithm.leetcode.tree.no0144_2_binaryTreePreorderTraversal.related.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liujie on 2021/6/29
 */

public class Solution2 {

    public static List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.poll();
            res.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/ -----");
        System.out.println("----- 1 -----");
        List<Node> child3 = new ArrayList<>();
        child3.add(new Node(5));
        child3.add(new Node(6));

        List<Node> child1 = new ArrayList<>();
        child1.add(new Node(3, child3));
        child1.add(new Node(2));
        child1.add(new Node(4));
        Node node1 = new Node(1, child1);

        System.out.println(preorder(node1));

    }
}
