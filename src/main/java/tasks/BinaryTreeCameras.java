package tasks;

import common.LeetCode;
import common.TreeNode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 12-Aug-20
 */
@LeetCode(id = 968, name = "Binary Tree Cameras", url = "https://leetcode.com/problems/binary-tree-cameras/")
public class BinaryTreeCameras
{
	enum State
	{
		EMPTY(0),
		CAMERA(1),
		COVERED(2);

		int index;

		State(int index)
		{
			this.index = index;
		}
	}

	public int minCameraCover(TreeNode root)
	{
		int[] val = new int[]{0};
		inorder(root, val);
		int[][] memo = new int[val[0]][3];
		for (int[] row : memo)
		{
			Arrays.fill(row, -1);
		}
		return Math.min(dfs(root, State.EMPTY, memo), 1 + dfs(root, State.CAMERA, memo));
	}

	private int dfs(TreeNode root, State state, int[][] memo)
	{
		if (root == null)
		{
			return 0;
		}

		if (memo[root.val][state.index] != -1)
		{
			return memo[root.val][state.index];
		}

		int result = 0;
		switch (state)
		{
			case EMPTY:
			{
				int cameraHere = 1 + dfs(root.left, State.COVERED, memo) + dfs(root.right, State.COVERED, memo);
				int cameraAtLeftChild = root.left == null ? Integer.MAX_VALUE : 1 + dfs(root.left, State.CAMERA, memo) + dfs(root.right, State.EMPTY, memo);
				int cameraAtRightChild = root.right == null ? Integer.MAX_VALUE : 1 + dfs(root.right, State.CAMERA, memo) + dfs(root.left, State.EMPTY, memo);
				result = Math.min(cameraHere, Math.min(cameraAtLeftChild, cameraAtRightChild));
				break;
			}
			case CAMERA:
			{
				result = dfs(root.left, State.COVERED, memo) + dfs(root.right, State.COVERED, memo);
				break;
			}
			case COVERED:
			{
				result = 1 + dfs(root.left, State.COVERED, memo) + dfs(root.right, State.COVERED, memo);
				result = Math.min(result, dfs(root.left, State.EMPTY, memo) + dfs(root.right, State.EMPTY, memo));
				break;
			}
		}

		memo[root.val][state.index] = result;

		return memo[root.val][state.index];
	}

	private void inorder(TreeNode root, int[] val)
	{
		if (root == null)
		{
			return;
		}

		inorder(root.left, val);
		root.val = val[0]++;
		inorder(root.right, val);
	}
}
