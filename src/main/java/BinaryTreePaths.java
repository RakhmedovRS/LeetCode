import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 17-Mar-20
 */
@LeetCode(id = 257, name = "Binary Tree Paths", url = "https://leetcode.com/problems/binary-tree-paths/")
public class BinaryTreePaths
{
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	public List<String> binaryTreePaths(TreeNode root)
	{
		if (root == null)
		{
			return new ArrayList<>();
		}

		List<String> result = new LinkedList<>();
		LinkedList<Integer> current = new LinkedList<>();

		binaryTreePaths(root, result, current);
		return result;
	}

	private void binaryTreePaths(TreeNode root, List<String> result, LinkedList<Integer> current)
	{
		if (root == null)
		{
			return;
		}

		current.addLast(root.val);

		binaryTreePaths(root.left, result, current);
		binaryTreePaths(root.right, result, current);

		if (root.left == null && root.right == null)
		{
			result.add(current.stream().map(String::valueOf).collect(Collectors.joining("->")));
		}

		current.removeLast();
	}
}
