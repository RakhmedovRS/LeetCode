package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 9/4/2021
 */
@LeetCode(
		id = 1993,
		name = "Operations on Tree",
		url = "https://leetcode.com/problems/operations-on-tree/",
		difficulty = Difficulty.MEDIUM
)
public class OperationsOnTree
{
	class LockingTree
	{

		int[] parent;
		Integer[] lockedBy;
		Map<Integer, List<Integer>> children;

		public LockingTree(int[] parent)
		{
			this.parent = parent;
			lockedBy = new Integer[parent.length];
			children = new HashMap<>();
			for (int i = 0; i < parent.length; i++)
			{
				if (parent[i] != -1)
				{
					children.putIfAbsent(parent[i], new ArrayList<>());
					children.get(parent[i]).add(i);
				}
			}
		}

		public boolean lock(int num, int user)
		{
			if (lockedBy[num] == null)
			{
				lockedBy[num] = user;
				return true;
			}
			return false;
		}

		public boolean unlock(int num, int user)
		{
			if (lockedBy[num] != null && lockedBy[num] == user)
			{
				lockedBy[num] = null;
				return true;
			}
			return false;
		}

		public boolean upgrade(int num, int user)
		{
			if (lockedBy[num] != null)
			{
				return false;
			}

			if (hasBlockedParents(num))
			{
				return false;
			}

			if (hasBlockedDescendants(num))
			{
				lockedBy[num] = user;
				unlockAllChild(num);

				return true;
			}

			return false;
		}

		private boolean hasBlockedParents(int node)
		{
			if (lockedBy[node] != null)
			{
				return true;
			}

			if (parent[node] == -1)
			{
				return false;
			}

			return hasBlockedParents(parent[node]);
		}

		private boolean hasBlockedDescendants(int num)
		{
			for (int child : children.getOrDefault(num, Collections.emptyList()))
			{
				if (lockedBy[child] != null || hasBlockedDescendants(child))
				{
					return true;
				}
			}

			return false;
		}

		private void unlockAllChild(int num)
		{
			for (int child : children.getOrDefault(num, Collections.emptyList()))
			{
				lockedBy[child] = null;
				unlockAllChild(child);
			}
		}
	}
}
