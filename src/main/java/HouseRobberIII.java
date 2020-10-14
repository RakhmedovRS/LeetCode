import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10/14/2020
 */
@LeetCode(id = 337, name = "House Robber III", url = "https://leetcode.com/problems/house-robber-iii/")
public class HouseRobberIII
{
	enum State
	{
		CAN_BE_ROBBER,
		CANT_BE_ROBBED
	}

	public int rob(TreeNode root)
	{
		Map<TreeNode, Map<State, Integer>> memo = new HashMap<>();
		return dfs(root, State.CAN_BE_ROBBER, memo);
	}

	private int dfs(TreeNode root, State state, Map<TreeNode, Map<State, Integer>> memo)
	{
		if (root == null)
		{
			return 0;
		}

		if (memo.containsKey(root) && memo.get(root).containsKey(state))
		{
			return memo.get(root).get(state);
		}

		int max = 0;
		if (state == State.CAN_BE_ROBBER)
		{
			max = Math.max(root.val + dfs(root.left, State.CANT_BE_ROBBED, memo) + dfs(root.right, State.CANT_BE_ROBBED, memo),
				dfs(root.left, State.CAN_BE_ROBBER, memo) + dfs(root.right, State.CAN_BE_ROBBER, memo));
		}
		else
		{
			max = dfs(root.left, State.CAN_BE_ROBBER, memo) + dfs(root.right, State.CAN_BE_ROBBER, memo);
		}

		memo.putIfAbsent(root, new HashMap<>());
		memo.get(root).put(state, max);
		return max;
	}
}
