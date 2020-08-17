import common.LeetCode;
import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 17-Aug-20
 */
@LeetCode(id = 1261, name = "Find Elements in a Contaminated Binary Tree", url = "https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/")
public class FindElementsInContaminatedBinaryTree
{
	class FindElements
	{
		TreeNode root;
		Set<Integer> integerSet;

		public FindElements(TreeNode root)
		{
			this.root = root;
			integerSet = new HashSet<>();
			recover(root, 0, integerSet);
		}

		public boolean find(int target)
		{
			return find(root, target);
		}

		private void recover(TreeNode root, int val, Set<Integer> integerSet)
		{
			if (root == null)
			{
				return;
			}

			root.val = val;
			integerSet.add(val);
			recover(root.left, 2 * val + 1, integerSet);
			recover(root.right, 2 * val + 2, integerSet);
		}

		private boolean find(TreeNode root, int val)
		{
			return integerSet.contains(val);
		}
	}
}
