package com.timberliu.algorithm.company.hw.volume_b.old.dfs_bfs.no044_1_decryptTime;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 解密犯罪时间
 *
 * @user liujie
 * @date 2023/9/13
 */
public class Solution1 {

    public static String nextTime(String str) {
        Set<Character> set = new HashSet<>();
        int idx = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ':') {
                set.add(c);
            }
        }

        List<String> list = new ArrayList<>();
        dfs(set, new ArrayList<>(), list);
        list.sort(String::compareTo);

        int index = list.indexOf(str.replace(":", ""));
        String res;
        if (index == list.size() - 1) {
            res = list.get(0);
        } else {
            res = list.get(index + 1);
        }
        return res.substring(0, 2) + ":" + res.substring(2, 4);
    }

    private static final Pattern pattern = Pattern.compile("(([01][0-9])|(2[0-3]))[0-5][0-9]");

    private static void dfs(Set<Character> set, List<Character> path, List<String> res) {
        if (path.size() == 4) {
            StringBuilder sb = new StringBuilder();
            path.forEach(sb::append);
            String str = sb.toString();
            if (pattern.matcher(str).find()) {
                res.add(str);
            }
            return;
        }
        for (char c : set) {
            path.add(c);
            dfs(set, path, res);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 20:12
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String res = nextTime(str);
        System.out.println(res);
    }

}
