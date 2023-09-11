package com.timberliu.algorithm.company.hw.volume_b.new_add.binary_search.no999_2_queueUp;

import java.util.*;

/**
 * 排队游戏
 *
 * @user liujie
 * @date 2023/9/11
 */
public class Solution1 {

    public static int teach(Set<Integer> set, int[] arr2, int n, int k) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int ability = arr2[i];
            // 最后一个等于 target 的位置，或应该插入的位置
            int rank = searchLast(list, ability);

            if (set.contains(i)) {
                // 刺头
                list.add(rank, ability);
            } else {
                // 非刺头，计算不满意度
                res += list.size() - rank;
            }
        }
        return res > k ? 1 : 0;
    }

    private static int searchLast(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else if (list.get(mid) > target) {
                right = mid - 1;
            } else {
                if (mid == list.size() - 1 || list.get(mid + 1) != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return left;
    }

    /*
     * 4 2 3
     * 0 1
     * 1810 1809 1801 1802
     */
    /**
     * 4 2 4
     * 0 1
     * 1810 1809 1801 1802
     */
    /*
     * 6 3 4
     * 0 1 3
     * 1810 1808 1801 1808 1802 1808
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(scanner.nextInt());
        }
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = scanner.nextInt();
        }

        int res = teach(set, arr2, n, k);
        System.out.println(res);
    }

}
