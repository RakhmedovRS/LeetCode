package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author RakhmedovRS
 * @created 1/16/2021
 */
@LeetCode(
		id = 919,
		name = "Complete Binary Tree Inserter",
		url = "https://leetcode.com/problems/complete-binary-tree-inserter/",
		difficulty = Difficulty.MEDIUM
)
public class CompleteBinaryTreeInserter {
	class CBTInserter {
		List<List<TreeNode>> levels;
		int nodes;

		public CBTInserter(TreeNode root) {
			levels = new ArrayList<>();
			nodes = 0;
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			int size;
			TreeNode current;
			while (!queue.isEmpty()) {
				size = queue.size();
				List<TreeNode> list = new ArrayList<>();
				while (size-- > 0) {
					current = queue.remove();
					list.add(current);
					nodes++;
					if (current.left != null) {
						queue.add(current.left);
					}

					if (current.right != null) {
						queue.add(current.right);
					}
				}

				levels.add(list);
			}
		}

		public int insert(int v) {
			int size = levels.size();
			if (Math.pow(2, size) - 1 == nodes) {
				levels.add(new ArrayList<>());
			}

			List<TreeNode> parentLevel = levels.get(levels.size() - 2);
			List<TreeNode> currentLevel = levels.get(levels.size() - 1);
			TreeNode node = new TreeNode(v);
			currentLevel.add(node);

			int pos = currentLevel.size() - 1;
			int parentPos = pos / 2;
			boolean leftChild = pos % 2 == 0;
			TreeNode parent = parentLevel.get(parentPos);
			if (leftChild) {
				parent.left = node;
			}
			else {
				parent.right = node;
			}

			nodes++;

			return parent.val;
		}

		public TreeNode get_root() {
			return levels.get(0).get(0);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);

		CBTInserter clazz = new CompleteBinaryTreeInserter().new CBTInserter(root);
		new PrintBinaryTree().printTree(clazz.get_root()).forEach(System.out::println);

		System.out.println();
		clazz.insert(7);
		new PrintBinaryTree().printTree(clazz.get_root()).forEach(System.out::println);

		System.out.println();
		clazz.insert(8);
		new PrintBinaryTree().printTree(clazz.get_root()).forEach(System.out::println);
	}
}
