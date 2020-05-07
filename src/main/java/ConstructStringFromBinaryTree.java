import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 05-Apr-20
 */
@LeetCode(id = 606, name = "Construct String from Binary Tree", url = "https://leetcode.com/problems/construct-string-from-binary-tree/")
public class ConstructStringFromBinaryTree
{
	public String tree2str(TreeNode t)
	{
		if (t == null)
		{
			return "";
		}
		if (t.left == null && t.right == null)
		{
			return t.val + "";
		}
		if (t.right == null)
		{
			return t.val + "(" + tree2str(t.left) + ")";
		}
		return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		System.out.println(new ConstructStringFromBinaryTree().tree2str(root));
	}
}
