package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 07-Aug-20
 */
@LeetCode(id = 331, name = "Verify Preorder Serialization of a Binary Tree", url = "https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/")
public class VerifyPreorderSerializationOfBinaryTree
{
	class TNode
	{
		TNode left;
		TNode right;
		String val;
		boolean isLeaf = false;
	}

	public boolean isValidSerialization(String preorder)
	{
		String[] nodes = preorder.split(",");
		int[] pos = new int[]{0};
		TNode node = buildTree(nodes, pos);
		return isTreeValid(node) && pos[0] == nodes.length;
	}

	private TNode buildTree(String[] nodes, int[] pos)
	{
		if (pos[0] == nodes.length)
		{
			return null;
		}

		TNode node = new TNode();
		node.val = nodes[pos[0]];

		if ("#".equals(nodes[pos[0]]))
		{
			pos[0]++;
			node.isLeaf = true;
			return node;
		}

		pos[0]++;
		node.left = buildTree(nodes, pos);
		node.right = buildTree(nodes, pos);

		return node;
	}

	private boolean isTreeValid(TNode node)
	{
		if (node == null)
		{
			return false;
		}

		if (node.isLeaf)
		{
			return true;
		}

		return isTreeValid(node.left) && isTreeValid(node.right);
	}
}
