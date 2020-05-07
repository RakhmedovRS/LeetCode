import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 06-May-20
 */
@LeetCode(id = 449, name = "Serialize and Deserialize BST", url = "https://leetcode.com/problems/serialize-and-deserialize-bst/")
public class SerializeAndDeserializeBST
{
	public String serialize(TreeNode root)
	{
		if (root == null)
		{
			return "null";
		}

		StringBuilder stringBuilder = new StringBuilder();
		serialize(root, stringBuilder);
		return stringBuilder.toString();
	}

	public void serialize(TreeNode root, StringBuilder stringBuilder)
	{
		if (root == null)
		{
			stringBuilder.append("null");
			return;
		}

		stringBuilder.append(root.val);
		stringBuilder.append(",");
		serialize(root.left, stringBuilder);
		stringBuilder.append(",");
		serialize(root.right, stringBuilder);
	}

	public TreeNode deserialize(String data)
	{
		String[] nodes = data.split(",");
		return buildTree(nodes, new int[]{0});
	}

	private TreeNode buildTree(String[] nodes, int[] index)
	{
		if ("null".equals(nodes[index[0]]))
		{
			index[0]++;
			return null;
		}

		TreeNode treeNode = new TreeNode(Integer.parseInt(nodes[index[0]++]));
		treeNode.left = buildTree(nodes, index);
		treeNode.right = buildTree(nodes, index);
		return treeNode;
	}
}
