package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 03-Apr-20
 */
@LeetCode(
	id = 297,
	name = "Serialize and Deserialize Binary Tree",
	url = "https://leetcode.com/problems/serialize-and-deserialize-binary-tree/",
	difficulty = Difficulty.HARD
)
public class SerializeAndDeserializeBinaryTree
{
	public class Codec
	{

		// Encodes a tree to a single string.
		public String serialize(TreeNode root)
		{
			StringBuilder sb = new StringBuilder();
			preorder(root, sb);
			return sb.toString();
		}

		private void preorder(TreeNode root, StringBuilder sb)
		{
			if (sb.length() > 0)
			{
				sb.append(',');
			}

			if (root == null)
			{
				sb.append('N');
				return;
			}

			sb.append(root.val);
			preorder(root.left, sb);
			preorder(root.right, sb);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data)
		{
			if (data.equals("N"))
			{
				return null;
			}

			String[] nodes = data.split(",");

			return deserialize(nodes, new int[]{0});
		}

		private TreeNode deserialize(String[] nodes, int[] index)
		{
			if (index[0] >= nodes.length)
			{
				return null;
			}

			if (nodes[index[0]].equals("N"))
			{
				index[0]++;
				return null;
			}

			TreeNode node = new TreeNode(Integer.parseInt(nodes[index[0]++]));
			node.left = deserialize(nodes, index);
			node.right = deserialize(nodes, index);

			return node;
		}
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		//		root.left.left = new TreeNode(4);
		//		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(3);
		root.right.left.right = new TreeNode(1);

		new SerializeAndDeserializeBinaryTree().new Codec().deserialize(new SerializeAndDeserializeBinaryTree().new Codec().serialize(root));
	}
}
