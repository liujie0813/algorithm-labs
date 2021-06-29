package com.timberliu.algorithm.tree.no0144_2_binaryTreePreorderTraversal.related.no0987_2_verticalOrderTraversalOfABinaryTree;

import com.timberliu.algorithm.tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 987. 二叉树的垂序遍历
 *
 * Created by liujie on 2021/6/29
 */

public class Solution2 {

    private class Node implements Comparable<Node> {

        private Integer y;
        private Integer value;

        public Node(Integer y, Integer value) {
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (this.y.equals(o.y)) {
                return this.value - o.value;
            }
            return this.y - o.y;
        }
    }

    private Map<Integer, List<Node>> results = new HashMap<>();
    private Integer minX = 0;
    private Integer maxX = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        dfs(root, 0, 0);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = minX; i <= maxX; i++) {
            List<Node> nodes = results.get(i);
            if (nodes == null) {
                continue;
            }
            Collections.sort(nodes);
            res.add(nodes.stream().map(node -> node.value).collect(Collectors.toList()));
        }
        return res;
    }

    /**
     * dfs 深度遍历（打坐标）
     */
    public void dfs(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        List<Node> nodes = results.computeIfAbsent(x, k -> new ArrayList<>());
        nodes.add(new Node(y, root.val));

        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);

        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/ -----");
        System.out.println("----- 1 -----");
        Solution2 solution1 = new Solution2();
        System.out.println(solution1.verticalTraversal(TreeNode.buildTree(Arrays.asList(3,9,20,null,null,15,7))));

    }
}
