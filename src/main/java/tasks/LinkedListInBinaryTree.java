package tasks;

import common.LeetCode;
import common.ListNode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 12-Jun-20
 */
@LeetCode(id = 1367, name = "Linked List in Binary Tree", url = "https://leetcode.com/problems/linked-list-in-binary-tree/")
public class LinkedListInBinaryTree
{
	public boolean isSubPath(ListNode head, TreeNode root)
	{
		if (root == null)
		{
			return false;
		}

		if (root.val == head.val && subPath(head, root))
		{
			return true;
		}

		return isSubPath(head, root.left) || isSubPath(head, root.right);
	}

	private boolean subPath(ListNode head, TreeNode root)
	{
		if (head == null)
		{
			return true;
		}

		if (root == null)
		{
			return false;
		}

		return root.val == head.val && (subPath(head.next, root.left) || subPath(head.next, root.right));
	}
}
