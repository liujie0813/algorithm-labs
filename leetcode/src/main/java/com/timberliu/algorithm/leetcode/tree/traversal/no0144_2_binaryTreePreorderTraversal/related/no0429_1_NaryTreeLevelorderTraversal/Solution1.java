package com.timberliu.algorithm.leetcode.tree.traversal.no0144_2_binaryTreePreorderTraversal.related.no0429_1_NaryTreeLevelorderTraversal;

import com.timberliu.algorithm.leetcode.tree.traversal.no0144_2_binaryTreePreorderTraversal.related.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public static List<List<Integer>> levelorder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/n-ary-tree-levelorder-traversal/ -----");
        System.out.println("----- 1 -----");
        List<Node> child3 = new ArrayList<>();
        child3.add(new Node(5));
        child3.add(new Node(6));

        List<Node> child1 = new ArrayList<>();
        child1.add(new Node(3, child3));
        child1.add(new Node(2));
        child1.add(new Node(4));
        Node node1 = new Node(1, child1);

        System.out.println(levelorder(node1));

    }

}
