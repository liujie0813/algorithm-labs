package com.timberliu.algorithm.leetcode.graph.basic.no0133_2_cloneGraph;

import java.util.*;

/**
 * 133. 克隆图
 *
 * @user liujie
 * @date 2023/8/4
 */
public class Solution1 {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            Node clone = dfs(neighbor, visited);
            newNode.neighbors.add(clone);
        }
        return newNode;
    }

    public static void main(String[] args) {

    }

}
