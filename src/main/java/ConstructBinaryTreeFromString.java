import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

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
		if (s.isEmpty())
		{
			return null;
		}

		StringBuilder number = new StringBuilder();
		int left = 0;
		while (left < s.length() && s.charAt(left) != '(')
		{
			number.append(s.charAt(left++));
		}

		TreeNode node = new TreeNode(Integer.parseInt(number.toString()));
		if (left == s.length())
		{
			return node;
		}

		int balance = 1;
		int right = left + 1;
		boolean leftCalled = false;
		for (; right < s.length(); right++)
		{
			if (s.charAt(right) == ')')
			{
				balance--;
			}
			else if (s.charAt(right) == '(')
			{
				balance++;
			}

			if (balance == 0)
			{
				if (!leftCalled)
				{
					node.left = str2tree(s.substring(left + 1, right));
					leftCalled = true;
					left = right + 1;
				}
				else
				{
					node.right = str2tree(s.substring(left + 1, right));
				}
			}
		}

		return node;
	}
}
