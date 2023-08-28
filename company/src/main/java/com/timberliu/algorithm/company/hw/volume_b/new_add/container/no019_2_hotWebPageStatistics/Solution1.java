package com.timberliu.algorithm.company.hw.volume_b.new_add.container.no019_2_hotWebPageStatistics;

import java.util.*;

/**
 * 热点网站统计
 *
 * @user liujie
 * @date 2023/8/28
 */
public class Solution1 {

    /**
     * news.qq.com
     * news.sina.com.cn
     * news.qq.com
     * news.qq.com
     * game.163.com
     * game.163.com
     * www.huawei.com
     * www.cctv.com
     * 3
     * www.huawei.com
     * www.cctv.com
     * www.huawei.com
     * www.cctv.com
     * www.huawei.com
     * www.cctv.com
     * www.huawei.com
     * www.cctv.com
     * www.huawei.com
     * www.cctv.com
     * 3
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> hashMap = new HashMap<>();
        TreeMap<Integer, HashSet<String>> treeMap = new TreeMap<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (Character.isDigit(line.charAt(0))) {
                int n = Integer.parseInt(line);
                Map.Entry<Integer, HashSet<String>> entry = treeMap.lastEntry();
                while (n > 0) {
                    List<String> list = new ArrayList<>(entry.getValue());
                    list.sort(null);
                    for (int j = 0; j < list.size() && n > 0; j++) {
                        System.out.print(list.get(j));
                        if (n > 1) {
                            System.out.print(",");
                        }
                        n--;
                    }
                    entry = treeMap.lowerEntry(entry.getKey());
                }
                System.out.println();
            } else {
                if (hashMap.containsKey(line)) {
                    Integer oldCnt = hashMap.get(line);
                    treeMap.get(oldCnt).remove(line);
                    HashSet<String> set = treeMap.computeIfAbsent(oldCnt + 1, val -> new HashSet<>());
                    set.add(line);
                } else {
                    HashSet<String> set = treeMap.computeIfAbsent(1, val -> new HashSet<>());
                    set.add(line);
                }
                hashMap.put(line, hashMap.getOrDefault(line, 0) + 1);
            }

        }

    }

}
