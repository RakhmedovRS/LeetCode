package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 20-May-20
 */
@LeetCode(id = 710, name = "Random Pick with Blacklist", url = "https://leetcode.com/problems/random-pick-with-blacklist/")
public class RandomPickWithBlacklist {
	class Solution {
		private final Set<Integer> blacklist;
		private final List<Integer> whiteList;
		private final Random random;
		private final int N;
		private boolean useWhiteList;

		public Solution(int N, int[] blacklist) {
			random = new Random();
			this.N = N;

			this.whiteList = new ArrayList<>();
			this.blacklist = new HashSet<>();
			for (int num : blacklist) {
				this.blacklist.add(num);
			}

			if (blacklist.length > N / 1.5D) {
				useWhiteList = true;
				for (int i = 0; i < N; i++) {
					if (this.blacklist.contains(i)) {
						continue;
					}
					whiteList.add(i);
				}
			}
		}

		public int pick() {
			if (useWhiteList) {
				return whiteList.get(random.nextInt(whiteList.size()));
			}
			else {
				int r = random.nextInt(N);
				while (blacklist.contains(r)) {
					r = random.nextInt(N);
				}
				return r;
			}
		}
	}
}
