package com.timberliu.algorithm.leetcode.greedy.no0406_2_queueReconstructionByHeight;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 406. 根据身高重建队列
 *
 *  对两个维度权衡时，一定要先确定一个维度，再确定另一个维度
 *
 *  按照身高从大到小排序（身高相同 k 小的站前面）
 *
 *  按照身高排序后，优先按身高高的 people 的 k 来插入，后序插入节点不会影响前面已经插入的节点
 *
 * @author Timber
 * @date 2021/11/8
 */
public class Solution1 {

	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return b[0] - a[0];
		});

		LinkedList<int[]> queue = new LinkedList<>();
		for (int[] p : people) {
			queue.add(p[1], p);
		}
		return queue.toArray(new int[people.length][]);
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/queue-reconstruction-by-height/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		int[][] res1 = solution1.reconstructQueue(new int[][]{
				{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
		});
		for (int[] ints : res1) {
			for (int a : ints) {
				System.out.print(a + ", ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("----- 2 -----");
		int[][] res2 = solution1.reconstructQueue(new int[][]{
				{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}
		});
		for (int[] ints : res2) {
			for (int a : ints) {
				System.out.print(a + ", ");
			}
			System.out.println();
		}
		System.out.println();

	}

}
