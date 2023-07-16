package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 10/21/2020
 */
@LeetCode(id = 951, name = "Flip Equivalent Binary Trees", url = "https://leetcode.com/problems/flip-equivalent-binary-trees/")
public class FlipEquivalentBinaryTrees
{
	public boolean flipEquiv(TreeNode root1, TreeNode root2)
	{
		if (root1 == null && root2 == null)
		{
			return true;
		}
		else if (root1 == null || root2 == null)
		{
			return false;
		}

		return root1.val == root2.val &&
				(
						(flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
								|| (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
				);
	}
}
