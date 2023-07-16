package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 14-Jun-20
 */
@LeetCode(id = 1483, name = "Kth Ancestor of a Tree Node", url = "https://leetcode.com/problems/kth-ancestor-of-a-tree-node/")
public class KthAncestorOfTreeNode
{
	class TreeAncestor
	{
		int[] parent;

		public TreeAncestor(int n, int[] parent)
		{
			this.parent = parent;
		}

		public int getKthAncestor(int node, int k)
		{
			if (node < 0 || node > parent.length || k > node)
			{
				return -1;
			}

			while (k-- > 0 && node != -1)
			{
				node = parent[node];
			}

			return node;
		}
	}
}
