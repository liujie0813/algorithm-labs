package com.timberliu.algorithm.company.hw.volume_b.old.tree.no120_1_postOrderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 完全二叉树非叶子部分后序遍历
 *
 * @user liujie
 * @date 2023/9/7
 */
public class Solution1 {

    public static List<Integer> postOrderTraversal(int[] arr) {
        List<Integer> res = new ArrayList<>();
        postOrderTraversal(arr, 0, res);
        return res;
    }

    private static void postOrderTraversal(int[] arr, int root, List<Integer> res) {
        // 有左子节点，即不为叶子节点
        if (root * 2 + 1 < arr.length) {
            postOrderTraversal(arr, root * 2 + 1, res);
            if (root * 2 + 2 < arr.length) {
                postOrderTraversal(arr, root * 2 + 2, res);
            }
            res.add(arr[root]);
        }
    }

    /*
     * 1 2 3 4 5 6
     */
    /**
     * 1 2 3 4 5 6 7 8 9 10
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(" ");
        int[] arr = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            arr[i] = Integer.parseInt(splits[i]);
        }

        List<Integer> res = postOrderTraversal(arr);
        for (Integer r : res) {
            System.out.print(r + " ");
        }
    }

}
