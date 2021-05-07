package com.timberliu.algorithm.tree.no0112_1_pathSum.related.no0508_mostFrequentSubtreeSum;

import com.timberliu.algorithm.tree.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 508. 出现次数最多的子树元素和
 *
 * Created by liujie on 2021/5/7
 */

public class Solution1 {

    static Map<Integer, Integer> freqMap;
    static int maxFreq;

    public static int[] findFrequentTreeSum(TreeNode root) {
        freqMap = new HashMap<>();
        sumElement(root);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (Integer key : list) {
            res[index++] = key;
        }
        return res;
    }

    private static int sumElement(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sumElement(root.left);
        int right = sumElement(root.right);
        int sum = left + right + root.val;
        freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
        maxFreq = Math.max(maxFreq, freqMap.get(sum));
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/most-frequent-subtree-sum/%3E/ -----");
        System.out.println("----- 1 -----");
        System.out.println(Arrays.toString(findFrequentTreeSum(TreeNode.buildTree(Arrays.asList(5,2,-3)))));

        System.out.println("----- 2 -----");
        System.out.println(Arrays.toString(findFrequentTreeSum(TreeNode.buildTree(Arrays.asList(5,2,-5)))));

    }
}
