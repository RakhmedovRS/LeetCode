package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/3/2021
 */
@LeetCode(
		id = 1711,
		name = "Count Good Meals",
		url = "https://leetcode.com/problems/count-good-meals/",
		difficulty = Difficulty.MEDIUM
)
public class CountGoodMeals {
	public int countPairs(int[] deliciousness) {
		int mod = 1_000_000_007;
		long count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int search;
		for (int num : deliciousness) {
			for (int i = 0; i <= 31; i++) {
				search = (1 << i) - num;
				count = (count + map.getOrDefault(search, 0)) % mod;
			}

			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		return (int) count;
	}

	public static void main(String[] args) {
		CountGoodMeals clazz = new CountGoodMeals();

		System.out.println(clazz.countPairs(new int[]{64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64,
				64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64}));//528

		System.out.println(clazz.countPairs(new int[]{2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0,
				16, 0, 3860, 28908, 6, 2, 15, 49, 6246, 1946, 23, 105, 7996, 196, 0, 2, 55, 457, 5,
				3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628, 1468})); //53

		System.out.println(clazz.countPairs(new int[]{1, 3, 5, 7, 9}));
		System.out.println(clazz.countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
	}
}
