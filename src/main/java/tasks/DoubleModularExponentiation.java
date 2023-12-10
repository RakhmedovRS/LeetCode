package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 12/10/2023
 */
@LeetCode(
		id = 2961,
		name = "Double Modular Exponentiation",
		url = "https://leetcode.com/problems/double-modular-exponentiation/",
		difficulty = Difficulty.MEDIUM
)
public class DoubleModularExponentiation
{
	public List<Integer> getGoodIndices(int[][] variables, int target) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < variables.length; i++)
		{
			java.math.BigInteger a = java.math.BigInteger.valueOf(variables[i][0]);
			java.math.BigInteger b = java.math.BigInteger.valueOf(variables[i][1]);
			int c = variables[i][2];
			java.math.BigInteger m = java.math.BigInteger.valueOf(variables[i][3]);

			java.math.BigInteger res = a.modPow(b, java.math.BigInteger.valueOf(10)).pow(c).remainder(m);
			if (target == res.intValue()) {
				ans.add(i);
			}

		}

		return ans;
	}
}
