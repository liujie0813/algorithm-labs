package com.timberliu.algorithm.leetcode.tree.no0297_2_serializeAndDeserializeBinaryTree;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    public String serialize(TreeNode root) {
        List<String> array = new ArrayList<>();
        serialize(root, array);
        if (array.isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String str : array) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private void serialize(TreeNode root, List<String> array) {
        if (root == null) {
            array.add("null,");
            return;
        }
        array.add(String.valueOf(root.val) + ",");
        serialize(root.left, array);
        serialize(root.right, array);
    }

    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        List<String> array = new ArrayList<>(Arrays.asList(data.split(",")));
        return deserialize(array);
    }

    private TreeNode deserialize(List<String> array) {
        if ("null".equals(array.get(0))) {
            array.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(array.get(0)));
        array.remove(0);
        root.left = deserialize(array);
        root.right = deserialize(array);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/ -----");
        System.out.println("----- 1 -----");
        Solution1 ser = new Solution1();
        Solution1 deser = new Solution1();
        TreeNode ans = deser.deserialize(ser.serialize(TreeNode.buildTree(Arrays.asList(1,2,3,null,null,4,5))));
        System.out.println(ans);
    }

}
