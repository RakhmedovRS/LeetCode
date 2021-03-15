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
		if (s == null || s.isEmpty())
		{
			return null;
		}

		int i = s.charAt(0) == '-' ? 1 : 0;
		while (i < s.length() && Character.isDigit(s.charAt(i)))
		{
			i++;
		}

		TreeNode node = new TreeNode(Integer.parseInt(s.substring(0, i)));
		LinkedList<Integer> indices = new LinkedList<>();
		for (; i < s.length(); i++)
		{
			if (s.charAt(i) == '(')
			{
				indices.push(i);
			}
			else if (s.charAt(i) == ')')
			{
				if (indices.size() == 1)
				{
					if (node.left == null)
					{
						node.left = str2tree(s.substring(indices.pop() + 1, i));
					}
					else
					{
						node.right = str2tree(s.substring(indices.pop() + 1, i));
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
}
