package com.timberliu.algorithm.company.hw.volume_b.new_add.tree.no043_rainEffect;

import java.util.Scanner;

/**
 * 二维伞的雨滴效应
 *
 * @user liujie
 * @date 2023/9/12
 */
public class Solution1 {

    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }

    public static int[] rainEffect(int[] arr) {
        Node root = new Node(arr[0]);
        int n = arr.length;
        if (isBST(arr, 0, n - 1, root)) {
            return new int[]{1, getLeftNode(root, 0), getRightNode(root, 0)};
        } else {
            return new int[]{0, 0, 0};
        }
    }

    private static boolean isBST(int[] arr, int left, int right, Node rootNode) {
        int root = arr[left];
        int i = left + 1;
        while (i <= right && arr[i] < root) {
            i++;
        }
        int j = i;
        while (j <= right && arr[j] > root) {
            j++;
        }
        if (j <= right) {
            return false;
        }
        if (left + 1 < i) {
            rootNode.left = new Node(arr[left + 1]);
            if (!isBST(arr, left + 1, i - 1, rootNode.left)) {
                return false;
            }
        }
        if (i <= right) {
            rootNode.right = new Node(arr[i]);
            if (!isBST(arr, i, right, rootNode.right)) {
                return false;
            }
        }
        return true;
    }

    private static int getLeftNode(Node root, int level) {
        // 左子节点不为空，递归遍历左子树
        if (root.left != null) {
            return getLeftNode(root.left, level + 1);
        }
        // 第一层没有左子树，返回 0
        if (level == 0) {
            return 0;
        }
        // 非第一层有右子树，递归遍历右子树
        if (root.right != null) {
            return getLeftNode(root.right, level + 1);
        } else {
            // 非第一层没有子节点，返回val
            return root.val;
        }
    }

    private static int getRightNode(Node root, int level) {
        // 右子节点不为空，递归遍历右子树
        if (root.right != null) {
            return getRightNode(root.right, level + 1);
        }
        // 第一层没有右子树，返回 0
        if (level == 0) {
            return 0;
        }
        // 非第一层有左子树，递归遍历左子树
        if (root.left != null) {
            return getRightNode(root.left, level + 1);
        } else {
            // 非第一层没有子节点，返回val
            return root.val;
        }
    }

    /**
     * 8 3 1 6 4 7 10 14 13
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(" ");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        int[] res = rainEffect(arr);
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }

}
