package com.timberliu.algorithm.company.hw.volume_b.old.stack_queue.no077_2_continuousCard;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 斗地主之顺子
 *
 * @user liujie
 * @date 2023/9/6
 */
public class Solution1 {

    public static List<String> continuousCard(String[] cards) {
        int[] nums = cardToNum(cards);
        Arrays.sort(nums);

        List<List<Integer>> containers = new ArrayList<>();
        containers.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = 0; j < containers.size(); j++) {
                List<Integer> container = containers.get(j);
                if (container.isEmpty() || container.get(container.size() - 1) + 1 == nums[i]) {
                    container.add(nums[i]);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                List<Integer> newContainer = new ArrayList<>();
                newContainer.add(nums[i]);
                containers.add(newContainer);
            }
        }

        containers = containers.stream().filter(container -> container.size() >= 5)
                .sorted(Comparator.comparingInt(container -> container.get(0))).collect(Collectors.toList());
        List<String> res = new ArrayList<>();
        for (List<Integer> container : containers) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < container.size(); i++) {
                sb.append(numToCard(container.get(i)));
                if (i < container.size() - 1) {
                    sb.append(" ");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    private static int[] cardToNum(String[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if ("J".equals(arr[i])) {
                res[i] = 8;
            } else if ("Q".equals(arr[i])) {
                res[i] = 9;
            } else if ("K".equals(arr[i])) {
                res[i] = 10;
            } else if ("A".equals(arr[i])) {
                res[i] = 11;
            } else if ("2".equals(arr[i])) {
                res[i] = 12;
            } else {
                int val = Integer.parseInt(arr[i]);
                res[i] = val - 3;
            }
        }
        return res;
    }

    private static char numToCard(int num) {
        char res;
        if (num == 8) {
            res = 'J';
        } else if (num == 9) {
            res = 'Q';
        } else if (num == 10) {
            res = 'K';
        } else if (num == 11) {
            res = 'A';
        } else if (num == 12) {
            res = '2';
        } else {
            res = (char)('0' + num + 3);
        }
        return res;
    }

    /**
     * 3 4 5 6 7 A 3 4 5 6 7 8 A
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splits = scanner.nextLine().split(" ");

        List<String> res = continuousCard(splits);
        for (String a : res) {
            System.out.println(a);
        }
    }

}
