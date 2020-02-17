import java.util.LinkedList;

/**
 * Maximum Level Sum of a Binary Tree
 * LeetCode 1161
 *
 * @author RakhmedovRS
 * @created 17-Feb-20
 */
public class MaximumLevelSumBinaryTree
{
	public class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	public int maxLevelSum(TreeNode root)
	{
		int maxLevel = 0;
		int currentLevel = 1;
		int max = Integer.MIN_VALUE;
		LinkedList<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		int levelQuantity;
		int levelSum;
		while (!nodes.isEmpty())
		{
			levelQuantity = nodes.size();
			levelSum = 0;
			while (levelQuantity > 0)
			{
				TreeNode node = nodes.removeFirst();
				if (node != null)
				{
					levelSum += node.val;

					if (node.left != null)
					{
						nodes.addLast(node.left);
					}

					if (node.right != null)
					{
						nodes.addLast(node.right);
					}
				}

				levelQuantity--;
			}

			if (levelSum > max)
			{
				max = levelSum;
				maxLevel = currentLevel;
			}
			currentLevel++;
		}

		return maxLevel;
	}
}
