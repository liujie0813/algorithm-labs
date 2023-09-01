package com.timberliu.algorithm.company.hw.volume_b.new_add.math.no033_1_screensaver;

import java.util.Scanner;

/**
 * 经典屏保
 *
 *  x+50 > 800, 其中 x+50 是右边界横坐标，则说明越界，需要沿着 x=800 轴对称
 *              反转后 x+50 变为 800 - (x+50 - 800)，得到 x = 800 - (x+50 - 800) - 50
 *  y+25 > 600, 其中 y+25 是左边界横坐标，则说明越界，需要沿着 y=600 轴对称
 *             反转后 y+25 变为 600 - (y+25 - 600)，得到 y = 600 - (y+25 - 600) - 25
 *
 * @user liujie
 * @date 2023/9/1
 */
public class Solution1 {

    public static int[] screenSaver(int x, int y, int t) {
        x += t;
        y += t;

        while (x + 50 > 800 || y + 25 > 600 || x < 0 || y < 0) {
            if (x + 50 > 800) {
                x = 800 - (x+50 - 800) - 50;
            }
            if (y + 25 > 600) {
                y = 600 - (y+25 - 600) - 25;
            }
            if (x < 0) {
                x = -x;
            }
            if (y < 0) {
                y = -y;
            }
        }
        return new int[]{x, y};
    }

    /**
     * 0 0 10
     */
    /**
     * 500 570 10
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int t = scanner.nextInt();

        int[] res = screenSaver(x, y, t);
        System.out.println(res[0] + " " + res[1]);
    }

}
