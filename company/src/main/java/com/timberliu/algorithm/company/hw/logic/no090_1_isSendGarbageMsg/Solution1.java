package com.timberliu.algorithm.company.hw.logic.no090_1_isSendGarbageMsg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 90. 垃圾短信发送者
 *
 * @author liujie
 * @date 2023/4/19
 */

public class Solution1 {

	public static boolean check(int[][] arr, int check, int[] res) {
		Map<Integer, Integer> receiverMap = new HashMap<>();
		Map<Integer, Integer> senderMap = new HashMap<>();
		int sendNum = 0, receiveNum = 0;
		for (int[] entry : arr) {
			if (entry[0] == check) {
				sendNum++;
				receiverMap.put(entry[1], receiverMap.getOrDefault(entry[1], 0) + 1);
			} else if (entry[1] == check) {
				receiveNum++;
				senderMap.put(entry[0], senderMap.getOrDefault(entry[0], 0) + 1);
			}
		}

		boolean flag = false;
		for (Map.Entry<Integer, Integer> entry : receiverMap.entrySet()) {
			if (!senderMap.containsKey(entry.getKey())) {
				res[0]++;
			} else {
				Integer rNum = entry.getValue();
				Integer sNum = senderMap.get(entry.getKey());
				if (rNum > sNum) {
					flag = true;
				}
			}
		}
		res[1] = sendNum - receiveNum;
		if (res[0] > 5 || res[1] > 10) {
			flag = true;
		}
		return flag;
	}

	/*
	 * 15
	 * 1 2
	 * 1 3
	 * 1 4
	 * 1 5
	 * 1 6
	 * 1 7
	 * 1 8
	 * 1 9
	 * 1 10
	 * 1 11
	 * 1 12
	 * 1 13
	 * 1 14
	 * 14 1
	 * 1 15
	 * 1
	 */

	/**
	 * 15
	 * 1 2
	 * 1 3
	 * 1 4
	 * 1 5
	 * 1 6
	 * 1 7
	 * 1 8
	 * 1 9
	 * 1 10
	 * 1 11
	 * 1 12
	 * 1 13
	 * 1 14
	 * 14 1
	 * 1 15
	 * 2
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = scanner.nextInt();
			arr[i][1] = scanner.nextInt();
		}
		int check = scanner.nextInt();

		int[] res = new int[2];
		boolean flag = check(arr, check, res);
		System.out.println(flag + " " + res[0] + " " + res[1]);
	}

}
