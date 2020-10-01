import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 29-Jun-20
 */
@LeetCode(id = 933, name = "Number of Recent Calls", url = "https://leetcode.com/problems/number-of-recent-calls/")
public class NumberOfRecentCalls
{
	class RecentCounter
	{

		List<Integer> calls;
		int pos;

		public RecentCounter()
		{
			pos = 0;
			calls = new ArrayList<>();
		}

		public int ping(int t)
		{
			calls.add(t);
			while (pos < calls.size() && calls.get(pos) < t - 3000)
			{
				pos++;
			}

			return calls.size() - pos;
		}
	}
}
