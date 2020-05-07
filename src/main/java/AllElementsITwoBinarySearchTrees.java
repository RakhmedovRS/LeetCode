import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 18-Feb-20
 */
@LeetCode(id = 1305, name = "All Elements in Two Binary Search Trees", url = "https://leetcode.com/problems/all-elements-in-two-binary-search-trees/")
public class AllElementsITwoBinarySearchTrees
{
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2)
	{
		List<Integer> values = new ArrayList<>();
		inOrderTraverse(root1, values);
		inOrderTraverse(root2, values);
		Collections.sort(values);
		return values;
	}

	private void inOrderTraverse(TreeNode root, List<Integer> values)
	{
		if (root == null)
		{
			return;
		}

		inOrderTraverse(root.left, values);
		values.add(root.val);
		inOrderTraverse(root.right, values);
	}
}
