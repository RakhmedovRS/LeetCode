import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 04-Jun-20
 */
@LeetCode(id = 1457, name = "Pseudo-Palindromic Paths in a Binary Tree", url = "https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/")
public class PseudoPalindromicPathsInBinaryTree
{
	public int pseudoPalindromicPaths(TreeNode root)
	{
		return pseudoPalindromicPaths(root, new HashMap<>());
	}

	private int pseudoPalindromicPaths(TreeNode root, Map<Integer, Integer> values)
	{
		if (root == null)
		{
			return 0;
		}

		values.put(root.val, values.getOrDefault(root.val, 0) + 1);
		int res = 0;
		if (root.left == null && root.right == null)
		{
			if (isPossiblePalindrome(values))
			{
				res++;
			}
		}
		else
		{
			res += pseudoPalindromicPaths(root.left, values) + pseudoPalindromicPaths(root.right, values);
		}

		Integer count = values.remove(root.val);
		if (count > 1)
		{
			values.put(root.val, --count);
		}

		return res;
	}

	private boolean isPossiblePalindrome(Map<Integer, Integer> memo)
	{
		int odd = 0;

		for (Integer count : memo.values())
		{
			if (count % 2 != 0)
			{
				odd++;
			}

			if (odd > 1)
			{
				return false;
			}
		}

		return true;
	}
}
