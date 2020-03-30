import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Feb-20
 */
@LeetCode(id = 1209, name = "Remove All Adjacent Duplicates in String II", url = "https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/")
public class RemoveAllAdjacentDuplicatesInStringII
{
	public String removeDuplicates(String S, int k)
	{
		java.util.Deque<java.util.Map.Entry<Character, Integer>> stack = new java.util.LinkedList<>();
		for (char ch : S.toCharArray())
		{
			if (stack.isEmpty() || stack.peek().getKey() != ch)
			{
				stack.addFirst(new java.util.AbstractMap.SimpleEntry<>(ch, 1));
			}
			else if (stack.peek().getKey() == ch && stack.peek().getValue() < k - 1)
			{
				stack.peek().setValue(stack.peek().getValue() + 1);
			}
			else
			{
				stack.pop();
			}
		}

		StringBuilder sb = new StringBuilder(stack.size());
		while (!stack.isEmpty())
		{
			for (int i = 0; i < stack.peek().getValue(); i++)
			{
				sb.append(stack.peek().getKey());
			}
			stack.pop();
		}

		return sb.reverse().toString();
	}
}
