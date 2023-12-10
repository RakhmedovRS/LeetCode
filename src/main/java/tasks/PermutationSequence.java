package tasks;

import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 03-Mar-20
 */
@LeetCode(id = 60, name = "Permutation Sequence", url = "https://leetcode.com/problems/permutation-sequence/")
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		return dfs(new LinkedList<>(), new int[]{k}, n, new boolean[n + 1]);
	}

	private String dfs(LinkedList<Integer> permutation, int[] counter, int n, boolean[] memo) {
		if (permutation.size() == n) {
			if (--counter[0] == 0) {
				StringBuilder sb = new StringBuilder(permutation.size());
				for (int num : permutation) {
					sb.append(num);
				}
				return sb.toString();
			}
			return null;
		}

		String res;
		for (int i = 1; i <= n; i++) {
			if (!memo[i]) {
				permutation.addLast(i);
				memo[i] = true;
				res = dfs(permutation, counter, n, memo);
				if (res != null) {
					return res;
				}
				permutation.removeLast();
				memo[i] = false;
			}
		}

		return null;
	}

	public static void main(String[] args) {
		System.out.println(new PermutationSequence().getPermutation(4, 9));
	}
}
