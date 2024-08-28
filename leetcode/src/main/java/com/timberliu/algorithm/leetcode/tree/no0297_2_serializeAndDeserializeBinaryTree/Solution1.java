package com.timberliu.algorithm.leetcode.tree.no0297_2_serializeAndDeserializeBinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serialize(root, res);
        return res.toString();
    }

    private void serialize(TreeNode root, StringBuilder array) {
        if (root == null) {
            array.append("null,");
            return;
        }
        array.append(root.val).append(',');
        serialize(root.left, array);
        serialize(root.right, array);
    }

    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deserialize(arr, new int[1]);
    }

    private TreeNode deserialize(String[] array, int[] index) {
        if ("null".equals(array[index[0]])) {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(array[index[0]]));
        index[0]++;
        root.left = deserialize(array, index);
        root.right = deserialize(array, index);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/ -----");
        System.out.println("----- 1 -----");
        Solution1 ser = new Solution1();
        TreeNode ans = ser.deserialize(ser.serialize(TreeNode.buildTree(Arrays.asList(1,2,3,null,null,4,5))));
        System.out.println(ans);

        TreeNode res2 = ser.deserialize(ser.serialize(TreeNode.buildTree(Arrays.asList())));
        System.out.println(res2);

    }

}
