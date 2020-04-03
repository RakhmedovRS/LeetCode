import common.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 03-Apr-20
 */
@LeetCode(id = 987, name = "Vertical Order Traversal of a Binary Tree", url = "https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/")
public class VerticalOrderTraversalOfBinaryTree
{
	public static class TreeNode
	{
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x){ val = x; }
	}

	private static class Point implements Comparable<Point>
	{
		private int x;
		private int y;
		private int value;

		public Point(int x, int y, int value)
		{
			this.x = x;
			this.y = y;
			this.value = value;
		}

		@Override
		public int compareTo(Point point)
		{
			if (this.x != point.x)
			{
				return this.x - point.x;
			}
			else if (this.y != point.y)
			{
				return this.y - point.y;
			}
			else
			{
				return this.value - point.value;
			}
		}
	}

	public List<List<Integer>> verticalTraversal(TreeNode root)
	{
		List<List<Integer>> answer = new ArrayList<>();
		if (root == null)
		{
			return answer;
		}

		List<Point> points = new ArrayList<>();
		verticalTraversal(root, 0, 0, points);
		Collections.sort(points);

		int prevX = Integer.MIN_VALUE;
		List<Integer> lines = new ArrayList<>();
		for (int i = 0; i < points.size(); i++)
		{
			if (points.get(i).x != prevX)
			{
				if (!lines.isEmpty())
				{
					answer.add(lines);
					lines = new ArrayList<>();
				}
			}

			prevX = points.get(i).x;
			lines.add(points.get(i).value);

			if (i == points.size() - 1)
			{
				answer.add(lines);
			}
		}

		return answer;
	}

	public void verticalTraversal(TreeNode root, int x, int y, List<Point> points)
	{
		if (root == null)
		{
			return;
		}

		points.add(new Point(x, y, root.val));
		verticalTraversal(root.left, x - 1, y + 1, points);
		verticalTraversal(root.right, x + 1, y + 1, points);
	}

	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		System.out.println(new VerticalOrderTraversalOfBinaryTree().verticalTraversal(root));
	}
}
