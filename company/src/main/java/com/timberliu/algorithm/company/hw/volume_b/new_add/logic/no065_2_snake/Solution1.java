package com.timberliu.algorithm.company.hw.volume_b.new_add.logic.no065_2_snake;

import java.util.*;

/**
 * 65 贪吃蛇
 *
 * @user liujie
 * @date 2023/8/30
 */
public class Solution1 {

    private static Map<String, int[]> map = new HashMap<String, int[]>() {{
        put("U", new int[]{-1, 0});
        put("D", new int[]{1, 0});
        put("L", new int[]{0, -1});
        put("R", new int[]{0, 1});
    }};

    public static int snakeLen(String[][] arr, String[] cmds) {
        int n = arr.length, m = arr[0].length;
        LinkedList<int[]> snake = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ("H".equals(arr[i][j])) {
                    snake.add(new int[]{i, j});
                    break;
                }
            }
        }

        int[] direction = new int[2];
        for (String cmd : cmds) {
            if (map.containsKey(cmd)) {
                direction = map.get(cmd);
            } else if ("G".equals(cmd)) {
                int[] head = snake.getFirst();
                int[] next = {head[0] + direction[0], head[1] + direction[1]};
                // 碰到边界
                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) {
                    return snake.size();
                }

                int[] tail = snake.getLast();
                String nextVal = arr[next[0]][next[1]];
                switch (nextVal) {
                    case "E":
                        // 空地
                        snake.addFirst(next);
                        arr[next[0]][next[1]] = "H";

                        snake.removeLast();
                        arr[tail[0]][tail[1]] = "E";
                        break;
                    case "F":
                        // 食物
                        snake.addFirst(next);
                        arr[next[0]][next[1]] = "H";
                        break;
                    case "H":
                        if (Arrays.equals(next, tail)) {
                            snake.addFirst(snake.getLast());
                        } else {
                            // 碰到蛇身
                            return snake.size();
                        }
                        break;
                }
            }
        }
        return snake.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] cmds = line.split(" ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.next();
        String[][] arr = new String[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine().split(" ");
        }

        int res = snakeLen(arr, cmds);
        System.out.println(res);
    }

}
