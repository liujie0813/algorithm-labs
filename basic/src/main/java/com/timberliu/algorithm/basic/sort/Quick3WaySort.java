package com.timberliu.algorithm.basic.sort;

import java.util.Arrays;

/**
 * @author liujie
 * @date 2024/6/3
 */

public class Quick3WaySort {

	public void quick3WaySort(int[] arr) {
		quick3WaySort(arr, 0, arr.length - 1);
	}

	private void quick3WaySort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		// 切分，使得 [left, j-1] 的元素都小于 pivot
		// 使得 [j, k] 的元素都等于 pivot
		// [k+1, right] 的元素都大于 pivot
		int i = left + 1, j = left, k = right;
		int pivot = arr[left];
		while (i <= k) {
			if (arr[i] < pivot) {
				// j位置肯定小于等于 pivot，交换后 i++
				swap(arr, i++, j++);
			} else if (arr[i] > pivot) {
				// k位置大小不确定，继续判断 i
				swap(arr, i, k--);
			} else {
				i++;
			}
		}

		quick3WaySort(arr, left, j - 1);
		quick3WaySort(arr, k + 1, right);
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		Quick3WaySort quickSort = new Quick3WaySort();
		int[] arr = {1, 7, 3, 8, 5, 3, 6, 2, 3};
		quickSort.quick3WaySort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
