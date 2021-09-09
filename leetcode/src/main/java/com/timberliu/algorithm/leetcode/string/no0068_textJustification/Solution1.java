package com.timberliu.algorithm.leetcode.string.no0068_textJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 左右文本对齐
 *
 *  贪心算法
 *   尽可能往一行中放单词，除非放不下
 *
 * @author Timber
 * @date 2021/9/9
 */
public class Solution1 {

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> resList = new ArrayList<>();
		int startIndex = 0;
		while (startIndex < words.length) {
			int endIndex = findEnd(words, maxWidth, startIndex);
			resList.add(fillWords(words, maxWidth, startIndex, endIndex, endIndex == words.length - 1));
			startIndex = endIndex + 1;
		}
		return resList;
	}

	private String fillWords(String[] words, int maxWidth, int left, int right, boolean lastLine) {
		int wordCount = right - left + 1;
		// wordCount 个单词之间有 wordCount - 1 个位置
		int extraSpaceCount = maxWidth - (wordCount - 1);
		for (int i = left; i <= right; i++) {
			extraSpaceCount -= words[i].length();
		}

		int extraSpaceAvg = wordCount == 1 ? 1 : extraSpaceCount / (wordCount - 1);
		int extraSpaceRemainder = wordCount == 1 ? 0 : extraSpaceCount % (wordCount - 1);

		StringBuilder sb = new StringBuilder();
		for (int i = left; i < right; i++) {
			sb.append(words[i]).append(" ");
			if (lastLine) {
				continue;
			}
			// 前 extraSpaceRemainder（余数）多一个空格
			int supplySpaceCount = extraSpaceAvg + ((i - left) < extraSpaceRemainder ? 1 : 0);
			while (supplySpaceCount-- > 0) {
				sb.append(" ");
			}
		}
		// 最后一个单词后面可能有空格，也可能没有，特殊处理，前面计算额外空格，也只需要考虑 各个单词之间的位置
		sb.append(words[right]);
		int endSpaceCount = maxWidth - sb.length();
		while (endSpaceCount-- > 0) {
			sb.append(" ");
		}
		return sb.toString();
	}

	private int findEnd(String[] words, int maxWidth, int startIndex) {
		int curIndex = startIndex + 1;
		int charCount = words[startIndex].length();
		// +1：至少有一个空格
		while (curIndex < words.length && charCount + 1 + words[curIndex].length() <= maxWidth) {
			charCount += 1 + words[curIndex].length();
			curIndex++;
		}
		return curIndex - 1;
	}

	public static void main(String[] args) {
		System.out.println("----- https://leetcode-cn.com/problems/text-justification/ -----");
		Solution1 solution1 = new Solution1();
		System.out.println("----- 1 -----");
		String[] strings1 = {"This", "is", "an", "example", "of", "text", "justification."};
		List<String> res1 = solution1.fullJustify(strings1, 16);
		for (String s : res1) {
			System.out.println(s);
		}
		System.out.println();


		System.out.println("----- 2 -----");
		String[] strings2 = {"What","must","be","acknowledgment","shall","be"};
		List<String> res2 = solution1.fullJustify(strings2, 16);
		for (String s : res2) {
			System.out.println(s);
		}
		System.out.println();


		System.out.println("----- 3 -----");
		String[] strings3 = {"Science","is","what","we","understand","well","enough","to","explain", "to","a","computer.","Art","is","everything","else","we","do"};
		List<String> res3 = solution1.fullJustify(strings3, 20);
		for (String s : res3) {
			System.out.println(s);
		}
		System.out.println();

	}
}
