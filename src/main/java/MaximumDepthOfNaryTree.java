import common.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 22-Mar-20
 */
@LeetCode(id = 559, name = "Maximum Depth of N-ary Tree", url = "https://leetcode.com/problems/maximum-depth-of-n-ary-tree/")
public class MaximumDepthOfNaryTree
{
	class Node
	{
		public int val;
		public List<Node> children;

		public Node(){}

		public Node(int val)
		{
			this.val = val;
		}

		public Node(int val, List<Node> children)
		{
			this.val = val;
			this.children = children;
		}
	}

	public int maxDepth(Node root)
	{
		int[] answer = {0};
		dfs(root, 1, answer);
		return answer[0];
	}

	private void dfs(Node root, int currentLevel, int[] answer)
	{
		if (root == null)
		{
			return;
		}

		answer[0] = Math.max(answer[0], currentLevel);
		for (Node node : root.children)
		{
			dfs(node, currentLevel + 1, answer);
		}
	}

	public int maxDepth1(Node root)
	{
		if (root == null)
		{
			return 0;
		}

		int currentLevel = 1;
		int levelSize;
		Queue<Node> levels = new LinkedList<>();
		levels.add(root);
		while (!levels.isEmpty())
		{
			levelSize = levels.size();
			while (levelSize-- > 0)
			{
				Node currentNode = levels.poll();
				for (Node child : currentNode.children)
				{
					if (child != null)
					{
						levels.add(child);
					}
				}
			}
			currentLevel++;
		}

		return currentLevel;
	}
}
