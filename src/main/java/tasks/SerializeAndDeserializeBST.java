package tasks;

import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
@LeetCode(id = 449, name = "Serialize and Deserialize BST", url = "https://leetcode.com/problems/serialize-and-deserialize-bst/")
public class SerializeAndDeserializeBST
{
	public class Codec
	{
		private final String NULL = "n";

		// Encodes a tree to a single string.
		public String serialize(TreeNode root)
		{
			StringBuilder sb = new StringBuilder();
			preorder(root, sb);
			return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data)
		{
			String[] nodes = data.split(",");
			return buildTree(nodes, new int[]{0});
		}

		private void preorder(TreeNode root, StringBuilder sb)
		{
			if (root == null)
			{
				if (sb.length() > 0)
				{
					sb.append(",");
				}

				sb.append(NULL);
				return;
			}

			if (sb.length() > 0)
			{
				sb.append(",");
			}
			sb.append(root.val);
			preorder(root.left, sb);
			preorder(root.right, sb);
		}

		private TreeNode buildTree(String[] nodes, int[] pos)
		{
			if (pos[0] == nodes.length)
			{
				return null;
			}

			if (NULL.equals(nodes[pos[0]]))
			{
				pos[0]++;
				return null;
			}

			TreeNode node = new TreeNode(Integer.parseInt(nodes[pos[0]++]));
			node.left = buildTree(nodes, pos);
			node.right = buildTree(nodes, pos);
			return node;
		}
	}
}
