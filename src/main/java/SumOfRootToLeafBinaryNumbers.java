import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@LeetCode(id = 1022, name = "Sum of Root To Leaf Binary Numbers", url = "https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/")
public class SumOfRootToLeafBinaryNumbers
{
	public int sumRootToLeaf(TreeNode root)
	{
		int[] answer = new int[]{0};
		sumRootToLeaf(root, new StringBuilder(), answer);
		return answer[0];
	}

	public void sumRootToLeaf(TreeNode root, StringBuilder prefix, int[] answer)
	{
		if (root == null)
		{
			return;
		}

		prefix.append(root.val);

		if (root.left == null && root.right == null)
		{
			answer[0] += Integer.parseInt(prefix.toString(), 2);
		}

		if (root.left != null)
		{
			sumRootToLeaf(root.left, prefix, answer);
		}

		if (root.right != null)
		{
			sumRootToLeaf(root.right, prefix, answer);
		}

		prefix.deleteCharAt(prefix.length() - 1);
	}
}
