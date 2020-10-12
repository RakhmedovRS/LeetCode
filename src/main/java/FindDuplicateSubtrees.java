import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 10/12/2020
 */
@LeetCode(id = 652, name = "Find Duplicate Subtrees", url = "https://leetcode.com/problems/find-duplicate-subtrees/")
public class FindDuplicateSubtrees
{
	public List<TreeNode> findDuplicateSubtrees(TreeNode root)
	{
		Map<String, Integer> memo = new HashMap<>();
		List<TreeNode> answer = new ArrayList<>();
		postOrder(root, memo, answer);
		return answer;
	}

	private String postOrder(TreeNode root, Map<String, Integer> memo, List<TreeNode> answer)
	{
		if (root == null)
		{
			return "#";
		}

		String serial = root.val + "," + postOrder(root.left, memo, answer) + "," + postOrder(root.right, memo, answer);
		if (memo.getOrDefault(serial, 0) == 1)
		{
			answer.add(root);
		}

		memo.put(serial, memo.getOrDefault(serial, 0) + 1);

		return serial;
	}
}
