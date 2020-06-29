import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 29-Jun-20
 */
@LeetCode(id = 933, name = "Number of Recent Calls", url = "https://leetcode.com/problems/number-of-recent-calls/")
public class NumberOfRecentCalls
{
	class RecentCounter
	{

		LinkedList<Integer> list;
		public RecentCounter()
		{
			list = new LinkedList<>();
		}

		public int ping(int t)
		{
			list.addLast(t);
			while (list.getFirst() < t - 3000)
			{
				list.removeFirst();
			}

			return list.size();
		}
	}
}
