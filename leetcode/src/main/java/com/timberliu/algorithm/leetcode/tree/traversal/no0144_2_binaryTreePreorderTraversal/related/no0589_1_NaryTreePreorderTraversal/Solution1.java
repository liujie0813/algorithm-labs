package com.timberliu.algorithm.leetcode.tree.traversal.no0144_2_binaryTreePreorderTraversal.related.no0589_1_NaryTreePreorderTraversal;

import com.timberliu.algorithm.leetcode.tree.traversal.no0144_2_binaryTreePreorderTraversal.related.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public static List<Integer> preorder(Node root) {
        List<Integer> preorderList = new ArrayList<>();
        preorderTraversal(root, preorderList);
        return preorderList;
    }

    public static void preorderTraversal(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preorderTraversal(child, res);
            }
        }
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
