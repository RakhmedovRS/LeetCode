import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10-Mar-20
 */
@LeetCode(id = 515, name = "Find Largest Value in Each Tree Row", url = "https://leetcode.com/problems/find-largest-value-in-each-tree-row/")
public class FindLargestValueInEachTreeRow
{
	public List<Integer> largestValues(TreeNode root)
	{
		if (root == null)
		{
			return new ArrayList<>();
		}

		List<Integer> maxValues = new LinkedList<>();
		LinkedList<TreeNode> nodes = new LinkedList<>();
		nodes.addFirst(root);
		int max;
		int nodesCount;
		TreeNode temp;
		while (!nodes.isEmpty())
		{
			max = Integer.MIN_VALUE;
			nodesCount = nodes.size();
			while (nodesCount > 0)
			{
				temp = nodes.removeFirst();
				max = Math.max(max, temp.val);

				if (temp.left != null)
				{
					nodes.addLast(temp.left);
				}

				if (temp.right != null)
				{
					nodes.addLast(temp.right);
				}

				nodesCount--;
			}
			maxValues.add(max);
		}

		return maxValues;
	}
}
