package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 3/6/2022
 */
@LeetCode(
		id = 2196,
		name = "Create Binary Tree From Descriptions",
		url = "https://leetcode.com/problems/create-binary-tree-from-descriptions/",
		difficulty = Difficulty.MEDIUM
)
public class CreateBinaryTreeFromDescriptions
{
	public TreeNode createBinaryTree(int[][] descriptions)
	{
		Map<Integer, TreeNode> treeNodeMap = new HashMap<>();
		Map<TreeNode, TreeNode> parents = new HashMap<>();
		for (int[] description : descriptions)
		{
			treeNodeMap.putIfAbsent(description[0], new TreeNode(description[0]));
			treeNodeMap.putIfAbsent(description[1], new TreeNode(description[1]));
			TreeNode parent = treeNodeMap.get(description[0]);
			TreeNode child = treeNodeMap.get(description[1]);
			if (description[2] == 1)
			{
				parent.left = child;
			}
			else
			{
				parent.right = child;
			}

			parents.put(child, parent);
		}

		TreeNode root = treeNodeMap.get(descriptions[0][0]);
		while (parents.containsKey(root))
		{
			root = parents.get(root);
		}

		return root;
	}
}
