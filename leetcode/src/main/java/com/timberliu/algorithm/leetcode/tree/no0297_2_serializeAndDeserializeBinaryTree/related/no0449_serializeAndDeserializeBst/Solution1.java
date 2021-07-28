package com.timberliu.algorithm.leetcode.tree.no0297_2_serializeAndDeserializeBinaryTree.related.no0449_serializeAndDeserializeBst;

import com.timberliu.algorithm.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 449. 序列化和反序列化二叉搜索树
 *
 * Created by liujie on 2021/6/29
 */

public class Solution1 {

    // Encodes a tree to a single string.
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
            return;
        }
        array.add(root.val + ",");
        serialize(root.left, array);
        serialize(root.right, array);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        List<Integer> array = new ArrayList<>();
        String[] split = data.split(",");
        for (String str : split) {
            array.add(Integer.parseInt(str));
        }

        return deserialize(array, 0, array.size() - 1);
    }

    public TreeNode deserialize(List<Integer> array, int low, int high) {
        if (low > high) {
            return null;
        }
        TreeNode root = new TreeNode(array.get(low));

        int index = low + 1;
        for (; index <= high; index++) {
            if (array.get(index) > root.val) {
                break;
            }
        }

        root.left = deserialize(array, low + 1, index - 1);
        root.right = deserialize(array, index, high);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/serialize-and-deserialize-bst/ -----");
        System.out.println("----- 1 -----");
        Solution1 ser = new Solution1();
        Solution1 deser = new Solution1();
        String str = ser.serialize(TreeNode.buildTree(Arrays.asList(2, 1, 3)));
        System.out.println(str);
        TreeNode ans = deser.deserialize(str);
        System.out.println(ans);

    }
}
