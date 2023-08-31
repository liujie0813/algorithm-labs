package com.timberliu.algorithm.company.hw.volume_b.new_add.container.no118_2_strongerStudentNum;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 找到比自己强的人
 *
 * @user liujie
 * @date 2023/8/31
 */
public class Solution1 {

    public static List<Integer> strongerStudentNum(int[][] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] a : arr) {
            List<Integer> list = map.computeIfAbsent(a[0], val -> new ArrayList<>());
            map.computeIfAbsent(a[1], val -> new ArrayList<>());
            list.add(a[1]);
        }

        List<int[]> res = new ArrayList<>();
        for (Integer p : map.keySet()) {
            int val = getHigh(p, p, map, new boolean[map.size()]);
            res.add(new int[]{p, val});
        }
        res.sort(Comparator.comparing(a -> a[0]));
        return res.stream().map(a -> a[1]).collect(Collectors.toList());
    }

    private static int getHigh(int target, int cur, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (cur == 1) {
            return 0;
        }
        int count = 0;
        visited[cur - 1] = true;
        for (Integer student : map.get(cur)) {
            if (visited[student - 1]) {
                continue;
            }
            if (student < target) {
                count++;
                count += getHigh(target, student, map, visited);
            }
        }
        return count;
    }


    /**
     * [[1,4],[1,3],[2,4],[2,1],[3,2]]
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        String[] strs = line.substring(2, line.length() - 2).split("],\\[");
        int[][] arr = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            String[] splits = strs[i].split(",");
            arr[i][0] = Integer.parseInt(splits[0]);
            arr[i][1] = Integer.parseInt(splits[1]);
        }

        List<Integer> res = strongerStudentNum(arr);
        PrintUtils.printListIntegerV2(res);
    }

}
