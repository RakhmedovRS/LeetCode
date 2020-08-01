package common;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 26-Jul-20
 */
public class TreeBuilder
{
	public static TreeNode deserializeBinaryTree(Integer[] nodes)
	{
		TreeNode[] madenodes = new TreeNode[nodes.length];
		Deque<TreeNode> stack = new LinkedList<>();
		for (int i = nodes.length - 1; i >= 0; i--)
		{
			TreeNode node = (nodes[i] == null) ? null : new TreeNode(nodes[i]);
			madenodes[i] = node;
			stack.push(node);
		}
		TreeNode root = stack.pop();
		for (TreeNode node : madenodes)
		{
			if (node != null)
			{
				if (!stack.isEmpty())
				{
					node.left = stack.pop();
				}
				if (!stack.isEmpty())
				{
					node.right = stack.pop();
				}
			}
		}
		return root;
	}

	public static TreeNode deserializeBinaryTree(String nodes)
	{
		return deserializeBinaryTree(Arrays.stream(nodes.split(","))
			.map(val -> "null".equals(val) ? null : Integer.parseInt(val)).toArray(Integer[]::new));
	}
}
