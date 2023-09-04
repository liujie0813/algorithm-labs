package com.timberliu.algorithm.company.hw.volume_b.old.dfs_bfs.no079_2_archaeologist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 考古学家
 *
 * @user liujie
 * @date 2023/9/4
 */
public class Solution1 {

    public static List<String> archaeologist(String[] strs, int n) {
        Arrays.sort(strs);
        List<String> res = new ArrayList<>();
        dfs(strs, new boolean[n], new ArrayList<>(), res);
        return res;
    }

    private static void dfs(String[] strs, boolean[] used, List<String> path, List<String> res) {
        if (path.size() == strs.length) {
            StringBuilder sb = new StringBuilder();
            for (String s : path) {
                sb.append(s);
            }
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < strs.length; i++) {
            if (i > 0 && strs[i].equals(strs[i - 1])) {
                continue;
            }
            if (!used[i]) {
                path.add(strs[i]);
                used[i] = true;
                dfs(strs, used, path, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 3
     * a b c
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        String[] splits = line.split(" ");

        List<String> res = archaeologist(splits, n);
        for (String s : res) {
            System.out.println(s);
        }
    }

}
