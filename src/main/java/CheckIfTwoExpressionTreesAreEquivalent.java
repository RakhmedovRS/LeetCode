import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/19/2020
 */
@LeetCode(
	id = 1612,
	name = "Check If Two Expression Trees are Equivalent",
	url = "https://leetcode.com/problems/check-if-two-expression-trees-are-equivalent/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class CheckIfTwoExpressionTreesAreEquivalent
{
	static class Node
	{
		char val;
		Node left;
		Node right;

		Node(){this.val = ' ';}

		Node(char val){ this.val = val; }

		Node(char val, Node left, Node right)
		{
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean checkEquivalence(Node root1, Node root2)
	{
		int[] table = new int[26];
		dfs(root1, table, true);
		dfs(root2, table, false);

		for (int c : table)
		{
			if (c != 0)
			{
				return false;
			}
		}

		return true;
	}

	private void dfs(Node root, int[] table, boolean add)
	{
		if (root == null)
		{
			return;
		}

		if (root.val == '+')

		{
			dfs(root.left, table, add);
			dfs(root.right, table, add);
		}
		else
		{
			if (add)
			{
				table[root.val - 'a']++;
			}
			else
			{
				table[root.val - 'a']--;
			}
		}
	}

	public static void main(String[] args)
	{
		Node root1 = new Node('+');
		root1.left = new Node('a');
		root1.right = new Node('+');
		root1.right.left = new Node('b');
		root1.right.right = new Node('b');

		Node root2 = new Node('+');
		root2.right = new Node('a');
		root2.left = new Node('+');
		root2.left.left = new Node('b');
		root2.left.right = new Node('d');

		System.out.println(new CheckIfTwoExpressionTreesAreEquivalent().checkEquivalence(root1, root2));
	}
}
