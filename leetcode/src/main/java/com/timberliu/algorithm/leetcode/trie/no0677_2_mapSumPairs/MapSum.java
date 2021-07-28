package com.timberliu.algorithm.leetcode.trie.no0677_2_mapSumPairs;

/**
 * Created by liujie on 2021/7/28
 */

public class MapSum {

    private class Node {
        private Node[] children;
        private int val;
        public Node() {
            children = new Node[26];
            val = 0;
        }
    }

    private Node root;

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node pre = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = c - 'a';
            if (pre.children[index] == null) {
                pre.children[index] = new Node();
            }
            pre = pre.children[index];
        }
        pre.val = val;
    }

    public int sum(String prefix) {
        Node pre = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (pre.children[index] == null) {
                return 0;
            }
            pre = pre.children[index];
        }
        return sum(pre);
    }

    private int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int sum = root.val;
        for (int i = 0; i < 26; i++) {
            sum += sum(root.children[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
        System.out.println();
    }

}
