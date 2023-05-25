package com.timberliu.algorithm.company.hw.volume_b.logic.new_no999_1_lampOrder;

import com.timberliu.algorithm.company.utils.PrintUtils;

import java.util.*;

/**
 * 面板识别
 *
 * @author liujie
 * @date 2023/5/25
 */

public class Solution1 {

	public static class Light {
		public int id;
		public int x;
		public int y;
		public int r;
		public Light(int id, int x, int y, int r) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

	public static List<Integer> lampOrder(List<Light> lights) {
		lights.sort(Comparator.comparingInt(a -> a.y));

		List<Integer> res = new ArrayList<>();

		Light base = lights.get(0);
		List<Light> sameRow = new ArrayList<>();
		sameRow.add(base);
		for (int i = 1; i < lights.size(); i++) {
			Light light = lights.get(i);
			// 纵坐标相差不超过 base 半径，同一行
			if (light.y - base.y <= base.r) {
				sameRow.add(light);
			} else {
				sameRow.sort(Comparator.comparingInt(a -> a.x));
				sameRow.forEach(l -> res.add(l.id));

				sameRow.clear();
				base = light;
				sameRow.add(light);
			}
		}
		// 最后一行
		sameRow.sort(Comparator.comparingInt(a -> a.x));
		sameRow.forEach(l -> res.add(l.id));

		return res;
	}

	/**
	 * 5
	 * 1 0 0 2 2
	 * 2 6 1 8 3
	 * 3 3 2 5 4
	 * 5 5 4 7 6
	 * 4 0 4 2 6
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Light> lights = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int id = scanner.nextInt();
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			lights.add(new Light(id, (x1 + x2) / 2, (y1 + y2) / 2, (x2 - x1) / 2));
		}

		List<Integer> res = lampOrder(lights);
		PrintUtils.printListInteger(res);
	}

}
