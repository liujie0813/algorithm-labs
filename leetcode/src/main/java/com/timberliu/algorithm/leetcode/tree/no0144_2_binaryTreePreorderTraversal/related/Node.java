package com.timberliu.algorithm.leetcode.tree.no0144_2_binaryTreePreorderTraversal.related;

import java.util.List;

/**
 * Created by liujie on 2021/6/29
 */

public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
