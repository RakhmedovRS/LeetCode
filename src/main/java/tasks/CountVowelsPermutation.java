package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/26/2020
 */
@LeetCode(
		id = 1220,
		name = "Count Vowels Permutation",
		url = "https://leetcode.com/problems/count-vowels-permutation/",
		difficulty = Difficulty.HARD
)
public class CountVowelsPermutation {
	public int countVowelPermutation(int n) {
		int mod = 1_000_000_007;
		long[] aS = new long[n];
		long[] eS = new long[n];
		long[] iS = new long[n];
		long[] oS = new long[n];
		long[] uS = new long[n];

		aS[0] = eS[0] = iS[0] = oS[0] = uS[0] = 1;

		for (int i = 1; i < n; i++) {
			aS[i] = ((uS[i - 1] % mod) + (eS[i - 1] % mod) + (iS[i - 1] % mod)) % mod;
			eS[i] = ((aS[i - 1] % mod) + (iS[i - 1] % mod)) % mod;
			iS[i] = ((eS[i - 1] % mod) + (oS[i - 1] % mod)) % mod;
			oS[i] = iS[i - 1] % mod;
			uS[i] = ((iS[i - 1] % mod) + (oS[i - 1] % mod)) % mod;
		}

		long answer = 0;
		answer = (answer + aS[n - 1]) % mod;
		answer = (answer + eS[n - 1]) % mod;
		answer = (answer + iS[n - 1]) % mod;
		answer = (answer + oS[n - 1]) % mod;
		answer = (answer + uS[n - 1]) % mod;

		return (int) answer;
	}
}
