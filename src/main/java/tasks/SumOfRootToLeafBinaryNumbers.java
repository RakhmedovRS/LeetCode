package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@LeetCode(id = 1022, name = "Sum of Root To Leaf Binary Numbers", url = "https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/")
public class SumOfRootToLeafBinaryNumbers {
	public int sumRootToLeaf(TreeNode root) {
		return sumRootToLeaf(root, 0);
	}

	private int sumRootToLeaf(TreeNode root, int num) {
		if (root == null) {
			return 0;
		}

		num <<= 1;
		num ^= root.val;

		if (root.left == null && root.right == null) {
			return num;
		}

		return sumRootToLeaf(root.left, num) + sumRootToLeaf(root.right, num);
	}
}
