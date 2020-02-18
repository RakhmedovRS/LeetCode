import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * All Elements in Two Binary Search Trees
 * LeetCode 1305
 *
 * @author RakhmedovRS
 * @created 18-Feb-20
 */
public class AllElementsITwoBinarySearchTrees
{
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

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
