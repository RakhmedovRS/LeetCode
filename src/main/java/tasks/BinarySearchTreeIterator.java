package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/9/2020
 */
@LeetCode(
		id = 173,
		name = "Binary Search Tree Iterator",
		url = "https://leetcode.com/problems/binary-search-tree-iterator/",
		difficulty = Difficulty.MEDIUM
)
public class BinarySearchTreeIterator
{
	class BSTIterator
	{

		LinkedList<TreeNode> stack;

		public BSTIterator(TreeNode root)
		{
			stack = new LinkedList<>();
			if (root != null)
			{
				stack.add(root);
			}
		}

		public int next()
		{
			TreeNode current = stack.pop();
			while (current.left != null)
			{
				stack.push(current);
				TreeNode temp = current.left;
				current.left = null;
				current = temp;
			}

			if (current.right != null)
			{
				stack.push(current.right);
			}

			return current.val;
		}

		public boolean hasNext()
		{
			return !stack.isEmpty();
		}
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);

		BSTIterator bstIterator = new BinarySearchTreeIterator().new BSTIterator(root);
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
		System.out.println(bstIterator.next());
		System.out.println(bstIterator.hasNext());
	}
}
