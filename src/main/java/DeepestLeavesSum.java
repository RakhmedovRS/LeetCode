import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 4/11/2021
 */
@LeetCode(
	id = 1302,
	name = "Deepest Leaves Sum",
	url = "https://leetcode.com/problems/deepest-leaves-sum/",
	difficulty = Difficulty.MEDIUM
)
public class DeepestLeavesSum
{
	public int deepestLeavesSum(TreeNode root)
	{
		int[] memo = new int[10_001];
		int[] max = new int[1];
		dfs(0, root, max, memo);
		return memo[max[0]];
	}

	private void dfs(int level, TreeNode node, int[] max, int[] memo)
	{
		if (node == null)
		{
			return;
		}

		if (node.left == null && node.right == null)
		{
			max[0] = Math.max(max[0], level);
			memo[level] += node.val;
			return;
		}

		dfs(level + 1, node.left, max, memo);
		dfs(level + 1, node.right, max, memo);
	}
}
