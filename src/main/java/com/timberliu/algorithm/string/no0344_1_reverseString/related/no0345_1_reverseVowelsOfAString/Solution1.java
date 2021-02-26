package com.timberliu.algorithm.string.no0344_1_reverseString.related.no0345_1_reverseVowelsOfAString;

import java.util.HashSet;
import java.util.Set;

/**
 * 反转字符串中的元音字母
 *
 *   时间复杂度：O(n)
 *   空间复杂度：O(n)
 *
 * Created by liujie on 2021/2/26
 */

public class Solution1 {

    private static final Set<Character> set = new HashSet<Character>(){{
        add('a'); add('o'); add('e'); add('i'); add('u');
        add('A'); add('O'); add('E'); add('I'); add('U');
    }};

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left <= right) {
            if (!set.contains(chars[left])) {
                left++;
            } else if (!set.contains(chars[right])) {
                right--;
            } else {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/reverse-vowels-of-a-string/ -----");
        System.out.println("----- 1 -----");
        System.out.println(reverseVowels("hello"));

        System.out.println("----- 1 -----");
        System.out.println(reverseVowels("leetcode"));
    }
}
