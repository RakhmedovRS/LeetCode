import java.util.LinkedList;
import java.util.List;

/**
 * Generate Parentheses
 * LeetCode 22
 *
 * @author RakhmedovRS
 * @created 13-Feb-20
 */
public class GenerateParentheses
{
	public void generateParenthesis(List<String> result, String currentState, int left, int right)
	{
		if (left == -1 || right == -1)
		{
			return;
		}

		if (left == 0 && right == 0)
		{
			result.add(currentState);
			return;
		}

		if (left > 0)
		{
			generateParenthesis(result, currentState + "(", left - 1, right);
		}

		if (right > 0 && right > left)
		{
			generateParenthesis(result, currentState + ")", left, right - 1);
		}
	}

	public List<String> generateParenthesis(int n)
	{
		List<String> result = new LinkedList<>();
		generateParenthesis(result, "", n, n);
		return result;
	}
}
