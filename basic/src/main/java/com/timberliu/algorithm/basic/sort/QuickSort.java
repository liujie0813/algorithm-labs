package com.timberliu.algorithm.basic.sort;

import java.util.Arrays;

/**
 * @author liujie
 * @date 2024/6/3
 */

public class QuickSort {

	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		// 切分，使得 p 之前的都小于 arr[i], p 之后的都大于 arr[i]
		int p = partition(arr, left, right);
		// 递归地对 p 左右两部分排序
		quickSort(arr, left, p - 1);
		quickSort(arr, p + 1, right);
	}

	private int partition(int[] arr, int left, int right) {
		// 选第一个为切分元素
		int partition = arr[left];
		int i = left, j = right + 1;
		while (true) {
			// 找到一个大于等于 pivot 的元素
			while (i < right && arr[++i] < partition) {
			}
			// 找到一个小于等于 pivot 的元素
			while (left < j && partition < arr[--j]) {
			}
			if (i >= j) {
				break;
			}
			// 前后交换
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
		// 交换 pivot 元素
		arr[left] = arr[j];
		arr[j] = partition;
		return j;
	}

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] arr = {1, 7, 3, 8, 5, 4, 6, 2, 9};
		quickSort.quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
