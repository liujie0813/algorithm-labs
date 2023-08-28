package com.timberliu.algorithm.company.hw.volume_b.new_add.container.no082_1_tlvDecode;

import java.util.*;

/**
 * TLV 解码II
 *
 * @user liujie
 * @date 2023/8/28
 */
public class Solution1 {

    public static List<int[]> tlvDecode(String str, int[] tags) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < str.length();) {
            Integer tag = Integer.parseInt(str.substring(i, i + 2), 16);
            int len = Integer.parseInt(str.substring(i + 2, i + 4), 16);
            int valOffset = (i + 4) / 2;
            i = i + 4 + len * 2;
            if (i >= str.length()) {
                break;
            }
            map.put(tag, new int[] {len, valOffset});
        }
        List<int[]> res = new ArrayList<>();
        for (int tag : tags) {
            res.add(map.getOrDefault(tag, new int[2]));
        }
        return res;
    }

    /**
     * 0F04ABABABAB1001FF
     * 2
     * 15
     * 17
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int n = Integer.parseInt(scanner.next());
        int[] tags = new int[n];
        for (int i = 0; i < n; i++) {
            tags[i] = Integer.parseInt(scanner.next());
        }
        List<int[]> res = tlvDecode(str, tags);
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }

}
