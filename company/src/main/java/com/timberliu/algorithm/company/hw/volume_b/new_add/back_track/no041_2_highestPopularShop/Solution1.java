package com.timberliu.algorithm.company.hw.volume_b.new_add.back_track.no041_2_highestPopularShop;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 人气最高的店铺
 *
 * @user liujie
 * @date 2023/9/11
 */
public class Solution1 {

    public static int minSubsidy(int[][] votes, int person, int shop) {
        Map<Integer, Integer> shopMap = new HashMap<>();
        for (int[] vote : votes) {
            shopMap.put(vote[0], shopMap.getOrDefault(vote[0], 0) + 1);
        }

        int[] res = {Integer.MAX_VALUE};
        backtrack(votes, new ArrayList<>(), 0, shopMap, res);
        return res[0];
    }

    private static void backtrack(int[][] votes, List<int[]> changes, int begin, Map<Integer, Integer> shopMap, int[] res) {
        if (check(changes, shopMap, res)) {
            return;
        }
        for (int i = begin; i < votes.length; i++) {
            changes.add(votes[i]);
            backtrack(votes, changes, i + 1, shopMap, res);
            changes.remove(changes.size() - 1);
        }
    }

    private static boolean check(List<int[]> changes, Map<Integer, Integer> shopMap, int[] res) {
        if (changes.isEmpty()) {
            return false;
        }
        Map<Integer, Integer> newShopMap = new HashMap<>(shopMap);
        int money = 0;
        for (int[] change : changes) {
            money += change[1];
            newShopMap.put(1, newShopMap.getOrDefault(1, 0) + 1);
            newShopMap.put(change[0], newShopMap.getOrDefault(change[0], 0) - 1);
        }

        List<Map.Entry<Integer, Integer>> list = newShopMap.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> -entry.getValue())).collect(Collectors.toList());
        if (list.get(0).getKey() == 1 && (list.size() == 1 || list.get(0).getValue() > list.get(1).getValue())) {
            res[0] = Math.min(money, res[0]);
            return true;
        }
        return false;
    }

    /**
     * 5,5
     * 2,10
     * 3,20
     * 4,30
     * 5,80
     * 5,90
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.nextLine().split(",");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(",");
            arr[i][0] = Integer.parseInt(line[0]);
            arr[i][1] = Integer.parseInt(line[1]);
        }

        int res = minSubsidy(arr, n, m);
        System.out.println(res);
    }

}
