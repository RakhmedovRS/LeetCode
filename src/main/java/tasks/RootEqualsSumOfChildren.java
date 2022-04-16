package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 4/16/2022
 */
@LeetCode(
	id = 2236,
	name = "Root Equals Sum of Children",
	url = "https://leetcode.com/problems/root-equals-sum-of-children/",
	difficulty = Difficulty.EASY
)
public class RootEqualsSumOfChildren
{
	public boolean checkTree(TreeNode root)
	{
		return root.val == root.left.val + root.right.val;
	}
}
