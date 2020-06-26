import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 26-Jun-20
 */
@LeetCode(id = 129, name = "Sum Root to Leaf Numbers", url = "https://leetcode.com/problems/sum-root-to-leaf-numbers/")
public class SumRootToLeafNumbers
{
	public int sumNumbers(TreeNode root)
	{
		if (root == null)
		{
			return 0;
		}

		int[] answer = new int[]{0};
		traverse(root, 0, answer);
		return answer[0];
	}

	private void traverse(TreeNode root, int numbers, int[] answer)
	{
		if (root == null)
		{
			return;
		}

		numbers *= 10;
		numbers += root.val;

		if (root.left == null && root.right == null)
		{
			answer[0] += numbers;
		}

		traverse(root.left, numbers, answer);
		traverse(root.right, numbers, answer);
	}
}
