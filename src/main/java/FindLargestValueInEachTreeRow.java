import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Find Largest Value in Each Tree Row
 * LeetCode 515
 *
 * @author RakhmedovRS
 * @created 10-Mar-20
 */
public class FindLargestValueInEachTreeRow
{
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

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
