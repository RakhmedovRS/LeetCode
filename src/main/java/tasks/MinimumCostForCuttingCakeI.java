package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-07-13
 */
@LeetCode(
		id = 3218,
		name = "Minimum Cost for Cutting Cake I",
		url = "https://leetcode.com/problems/minimum-cost-for-cutting-cake-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumCostForCuttingCakeI {
	public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
		List<Integer> H = new ArrayList<>();
		for (int h : horizontalCut) {
			H.add(h);
		}

		List<Integer> V = new ArrayList<>();
		for (int v : verticalCut) {
			V.add(v);
		}

		H.sort(Comparator.reverseOrder());
		V.sort(Comparator.reverseOrder());

		return dfs(m, n, 1, 1, 0, H, 0, V);
	}

	private int dfs(int m, int n, int mSides, int nSides, int hPos, List<Integer> H, int vPos, List<Integer> V) {
		if (mSides == m && n == nSides) {
			return 0;
		}

		if (mSides < m && nSides < n) {
			if (V.get(vPos).compareTo(H.get(hPos)) >= 0) {
				return mSides * V.get(vPos) + dfs(m, n, mSides, nSides + 1, hPos, H, vPos + 1, V);
			} else {
				return nSides * H.get(hPos) + dfs(m, n, mSides + 1, nSides, hPos + 1, H, vPos, V);
			}
		} else if (mSides < m) {
			return nSides * H.get(hPos) + dfs(m, n, mSides + 1, nSides, hPos + 1, H, vPos, V);
		} else {
			return mSides * V.get(vPos) + dfs(m, n, mSides, nSides + 1, hPos, H, vPos + 1, V);
		}
	}
}