package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 15-Jul-20
 */
@LeetCode(
	id = 988,
	name = "Smallest String Starting From Leaf",
	url = "https://leetcode.com/problems/smallest-string-starting-from-leaf/",
	difficulty = Difficulty.MEDIUM
)
public class SmallestStringStartingFromLeaf
{
	public String smallestFromLeaf(TreeNode root)
	{
		String[] min = new String[]{null};
		dfs(root, new StringBuilder(), min);
		return min[0];
	}

	private void dfs(TreeNode root, StringBuilder current, String[] min)
	{
		if (root == null)
		{
			return;
		}

		current.append((char) (root.val + 'a'));

		if (root.left == null && root.right == null)
		{
			String word = current.reverse().toString();
			current.reverse();

			if (min[0] == null || min[0].isEmpty() || word.compareTo(min[0]) < 0)
			{
				min[0] = word;
			}
			current.deleteCharAt(current.length() - 1);
			return;
		}

		dfs(root.left, current, min);
		dfs(root.right, current, min);
		current.deleteCharAt(current.length() - 1);
	}
}
