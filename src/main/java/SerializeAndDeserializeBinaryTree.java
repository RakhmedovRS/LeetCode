import common.LeetCode;
import common.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 03-Apr-20
 */
@LeetCode(id = 297, name = "Serialize and Deserialize Binary Tree", url = "https://leetcode.com/problems/serialize-and-deserialize-binary-tree/")
public class SerializeAndDeserializeBinaryTree
{
	public class Codec
	{
		// Encodes a tree to a single string.
		public String serialize(TreeNode root)
		{
			StringBuilder sb = new StringBuilder();
			buildString(root, sb);
			return sb.toString();
		}

		private void buildString(TreeNode node, StringBuilder sb)
		{
			if (node == null)
			{
				sb.append("N");
				sb.append(",");
			}
			else
			{
				sb.append(node.val);
				sb.append(",");
				buildString(node.left, sb);
				buildString(node.right, sb);
			}
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data)
		{
			Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
			return buildTree(nodes);
		}

		private TreeNode buildTree(Deque<String> nodes)
		{
			String val = nodes.remove();
			if (val.equals("N"))
			{
				return null;
			}
			else
			{
				TreeNode node = new TreeNode(Integer.parseInt(val));
				node.left = buildTree(nodes);
				node.right = buildTree(nodes);
				return node;
			}
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
