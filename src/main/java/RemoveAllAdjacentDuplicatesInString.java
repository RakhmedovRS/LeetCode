import java.util.Deque;
import java.util.LinkedList;

/**
 * Remove All Adjacent Duplicates In String
 * LeetCode 1047
 *
 * @author RakhmedovRS
 * @created 26-Feb-20
 */
public class RemoveAllAdjacentDuplicatesInString
{
	public String removeDuplicates(String S)
	{
		Deque<Character> stack = new LinkedList<>();
		for (char ch : S.toCharArray())
		{
			if (stack.isEmpty() || stack.peek() != ch)
			{
				stack.addFirst(ch);
			}
			else
			{
				stack.pop();
			}
		}

		StringBuilder sb = new StringBuilder(stack.size());
		while (!stack.isEmpty())
		{
			sb.append(stack.pop());
		}

		return sb.reverse().toString();
	}
}
