package com.timberliu.algorithm.leetcode.trie.no0208_2_implementTriePrefixTree;

/**
 * 208. 实现 Trie (前缀树)
 *
 *   字典树、单次查找树 —— 多叉树
 *
 * Created by liujie on 2021/7/28
 */

public class Trie {

    static class Node {
        private final Node[] children = new Node[26];
        private boolean isEnd;
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Node searchPrefix(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/implement-trie-prefix-tree/ -----");
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.search("app"));
    }

}
