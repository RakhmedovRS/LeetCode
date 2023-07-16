package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@LeetCode(
		id = 1379,
		name = "Find a Corresponding Node of a Binary Tree in a Clone of That Tree",
		url = "https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/",
		difficulty = Difficulty.MEDIUM
)
public class FindCorrespondingNodeOfBinaryTreeInCloneOfThatTree
{
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target)
	{
		if (original == null)
		{
			return null;
		}

		if (original == target)
		{
			return cloned;
		}

		TreeNode left = getTargetCopy(original.left, cloned.left, target);
		if (left != null)
		{
			return left;
		}

		return getTargetCopy(original.right, cloned.right, target);
	}
}
