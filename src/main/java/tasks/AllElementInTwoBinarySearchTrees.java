package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 05-Sep-20
 */
@LeetCode(
		id = 1305,
		name = "All Elements in Two Binary Search Trees",
		url = "https://leetcode.com/problems/all-elements-in-two-binary-search-trees/",
		difficulty = Difficulty.MEDIUM
)
public class AllElementInTwoBinarySearchTrees {
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		dfs(root1, list1);
		dfs(root2, list2);

		List<Integer> answer = new ArrayList<>();
		while (!list1.isEmpty() && !list2.isEmpty()) {
			if (list1.getFirst() <= list2.getFirst()) {
				answer.add(list1.removeFirst());
			}
			else {
				answer.add(list2.removeFirst());
			}
		}

		while (!list1.isEmpty()) {
			answer.add(list1.removeFirst());
		}


		while (!list2.isEmpty()) {
			answer.add(list2.removeFirst());
		}

		return answer;
	}

	private void dfs(TreeNode treeNode, List<Integer> list) {
		if (treeNode == null) {
			return;
		}

		dfs(treeNode.left, list);
		list.add(treeNode.val);
		dfs(treeNode.right, list);
	}
}
