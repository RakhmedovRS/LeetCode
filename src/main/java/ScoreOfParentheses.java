import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 16-Jul-20
 */
@LeetCode(id = 856, name = "Score of Parentheses", url = "https://leetcode.com/problems/score-of-parentheses/")
public class ScoreOfParentheses
{
	public int scoreOfParentheses(String S) {
		Deque<Integer> results = new LinkedList<>();
		results.push(0);
		for (char ch : S.toCharArray()) {
			if (ch == '(') {
				results.push(0);
			}
			else {
				int last = results.pop();
				int prev = results.pop();
				results.push(prev + Math.max(last * 2, 1));
			}
		}

		while (results.size() > 1) {
			results.add(results.remove() + results.remove());
		}

		return results.isEmpty() ? 0 : results.peek();
	}
}
