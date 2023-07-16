package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 31-Jan-21
 */
@LeetCode(
		id = 1586,
		name = "Binary Search Tree Iterator II",
		url = "https://leetcode.com/problems/binary-search-tree-iterator-ii/",
		difficulty = Difficulty.MEDIUM
)
public class BinarySearchTreeIteratorII
{
	class BSTIterator
	{
		TreeNode head;
		TreeNode tail;
		TreeNode current;

		public BSTIterator(TreeNode root)
		{
			head = new TreeNode(Integer.MIN_VALUE);
			tail = new TreeNode(Integer.MAX_VALUE);
			head.right = tail;
			tail.left = head;
			current = head;
			inorder(root, new TreeNode[]{head});
		}

		public boolean hasNext()
		{
			return current.right != null && current.right.val != Integer.MAX_VALUE;
		}

		public int next()
		{
			current = current.right;
			return current.val;
		}

		public boolean hasPrev()
		{
			return current.left != null && current.left.val != Integer.MIN_VALUE;
		}

		public int prev()
		{
			current = current.left;
			return current.val;
		}

		private void inorder(TreeNode node, TreeNode[] curr)
		{
			if (node == null)
			{
				return;
			}

			inorder(node.left, curr);
			TreeNode prev = curr[0];
			TreeNode right = prev.right;
			prev.right = new TreeNode(node.val);
			prev.right.left = prev;
			prev.right.right = right;
			right.left = prev.right;
			curr[0] = prev.right;
			inorder(node.right, curr);
		}
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);

		BSTIterator bSTIterator = new BinarySearchTreeIteratorII().new BSTIterator(root);
		bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 3
		bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 7
		bSTIterator.prev(); // state becomes [3, 7, 9, 15, 20], return 3
		bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 7
		bSTIterator.hasNext(); // return true
		bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 9
		bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 15
		bSTIterator.next(); // state becomes [3, 7, 9, 15, 20], return 20
		bSTIterator.hasNext(); // return false
		bSTIterator.hasPrev(); // return true
		bSTIterator.prev(); // state becomes [3, 7, 9, 15, 20], return 15
		bSTIterator.prev(); // state becomes [3, 7, 9, 15, 20], return 9
	}
}
