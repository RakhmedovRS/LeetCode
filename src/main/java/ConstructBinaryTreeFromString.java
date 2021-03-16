import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/11/2020
 */
@LeetCode(
	id = 536,
	name = "Construct Binary Tree from String",
	url = "https://leetcode.com/problems/construct-binary-tree-from-string/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class ConstructBinaryTreeFromString
{
	public TreeNode str2tree(String s)
	{
		return str2tree(s.toCharArray(), 0, s.length() - 1);
	}

	public TreeNode str2tree(char[] chars, int left, int right)
	{
		if (left > right)
		{
			return null;
		}

		boolean negative = chars[left] == '-';
		int i = negative ? left + 1 : left;
		int num = 0;
		while (i <= right && Character.isDigit(chars[i]))
		{
			num *= 10;
			num += chars[i] - '0';
			i++;
		}

		num = negative ? -num : num;

		TreeNode node = new TreeNode(num);
		LinkedList<Integer> indices = new LinkedList<>();
		for (; i <= right; i++)
		{
			if (chars[i] == '(')
			{
				indices.push(i);
			}
			else if (chars[i] == ')')
			{
				if (indices.size() == 1)
				{
					if (node.left == null)
					{
						node.left = str2tree(chars, indices.pop() + 1, i - 1);
					}
					else
					{
						node.right = str2tree(chars, indices.pop() + 1, i - 1);
					}
				}
				else
				{
					indices.pop();
				}
			}
		}

		return node;
	}

	public static void main(String[] args)
	{
		ConstructBinaryTreeFromString clazz = new ConstructBinaryTreeFromString();
		System.out.println(clazz.str2tree("4(2(3)(1))(6(5))"));
	}
}
