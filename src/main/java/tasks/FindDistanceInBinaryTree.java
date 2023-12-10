package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 28-Jan-21
 */
@LeetCode(
		id = 1740,
		name = "Find Distance in a Binary Tree",
		url = "https://leetcode.com/problems/find-distance-in-a-binary-tree/",
		difficulty = Difficulty.EASY
)
public class FindDistanceInBinaryTree {
	public int findDistance(TreeNode root, int p, int q) {
		int[] answer = new int[]{0};
		findDistance(root, p, q, answer);
		return answer[0];
	}

	private int findDistance(TreeNode root, int p, int q, int[] answer) {
		if (root == null) {
			return -1;
		}

		int left = findDistance(root.left, p, q, answer);
		int right = findDistance(root.right, p, q, answer);

		if (root.val == p || root.val == q) {
			if (left != -1) {
				answer[0] = left + 1;
			}

			if (right != -1) {
				answer[0] = right + 1;
			}

			return 0;
		}

		if (left != -1 && right != -1) {
			answer[0] = 2 + left + right;
		}

		if (left != -1) {
			return left + 1;
		}
		else if (right != -1) {
			return right + 1;
		}
		return -1;
	}
}
