package com.timberliu.algorithm.company.hw.volume_b.new_add.greedy.no094_2_bestCardMethod;

import java.util.Scanner;

/**
 * 最佳的出牌方法
 *
 *
 *  card[i] >= 1，顺子、单张
 *  card[i] >= 2，对子
 *  card[i] >= 3，三张
 *  card[i] >= 4，炸弹
 *
 * @user liujie
 * @date 2023/9/8
 */
public class Solution1 {

    public static int maxScore(String str) {
        int[] cards = new int[14];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '0') {
                cards[10]++;
            } else if (ch == 'J') {
                cards[11]++;
            } else if (ch == 'Q') {
                cards[12]++;
            } else if (ch == 'K') {
                cards[13]++;
            } else {
                cards[ch - '0']++;
            }
        }

        int[] res = new int[1];
        maxScore(cards, 1, str.length(), 0, res);
        return res[0];
    }

    private static void maxScore(int[] cards, int index, int unUsedCnt, int curScore, int[] res) {
        if (unUsedCnt == 0) {
            res[0] = Math.max(res[0], curScore);
            return;
        }
    
        for (int i = index; i < cards.length; i++) {
            if (cards[i] >= 1) {
                // 顺子
                if (i <= 9 && cards[i + 1] >= 1 && cards[i + 2] >= 1 && cards[i + 3] >= 1 && cards[i + 4] >= 1) {
                    cards[i]--;
                    cards[i + 1]--;
                    cards[i + 2]--;
                    cards[i + 3]--;
                    cards[i + 4]--;
                    maxScore(cards, i, unUsedCnt - 5, curScore + (i * 5 + 10) * 2, res);
                    cards[i]++;
                    cards[i + 1]++;
                    cards[i + 2]++;
                    cards[i + 3]++;
                    cards[i + 4]++;
                }
                // 单张
                cards[i]--;
                maxScore(cards, i, unUsedCnt - 1, curScore + i, res);
                cards[i]++;
            }
            // 对子
            if (cards[i] >= 2) {
                cards[i] -= 2;
                maxScore(cards, i, unUsedCnt - 2, curScore + i * 4, res);
                cards[i] += 2;
            }
            // 三张
            if (cards[i] >= 3) {
                cards[i] -= 3;
                maxScore(cards, i, unUsedCnt - 3, curScore + i * 6, res);
                cards[i] += 3;
            }
            // 炸弹
            if (cards[i] >= 4) {
                cards[i] -= 4;
                maxScore(cards, i, unUsedCnt - 4, curScore + i * 12, res);
                cards[i] += 4;
            }
        }
    }

    /**
     * 33445677
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int res = maxScore(str);
        System.out.println(res);
    }

}
