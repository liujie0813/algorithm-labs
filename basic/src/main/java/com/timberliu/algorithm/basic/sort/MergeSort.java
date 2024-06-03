package com.timberliu.algorithm.basic.sort;

import java.util.Arrays;

/**
 * @author liujie
 * @date 2024/6/3
 */

public class MergeSort {

	private int[] aux;

	public void mergeSort(int[] arr) {
		aux = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1);
	}

	private void mergeSort(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		merge(arr, left, mid, right);
	}

	private void merge(int[] arr, int left, int mid, int right) {
		for (int i = left; i <= right; i++) {
			aux[i] = arr[i];
		}
		int index = left;
		int i = left, j = mid + 1;
		while (i <= mid || j <= right) {
			if (i > mid) {
				arr[index++] = aux[j++];
			} else if (j > right) {
				arr[index++] = aux[i++];
			} else if (aux[i] > aux[j]) {
				arr[index++] = aux[j++];
			} else {
				arr[index++] = aux[i++];
			}
		}
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] arr = {1, 7, 3, 8, 5, 4, 6, 2, 9};
		mergeSort.mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
