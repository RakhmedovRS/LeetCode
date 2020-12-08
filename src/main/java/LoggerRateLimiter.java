import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/8/2020
 */
@LeetCode(
	id = 359,
	name = "Logger Rate Limiter",
	url = "https://leetcode.com/problems/logger-rate-limiter/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class LoggerRateLimiter
{
	class Logger
	{

		/**
		 * Initialize your data structure here.
		 */
		Map<String, Integer> map;

		public Logger()
		{
			map = new HashMap<>();
		}

		/**
		 * Returns true if the message should be printed in the given timestamp, otherwise returns false. If this method returns false, the message will not be printed. The timestamp is in seconds
		 * granularity.
		 */
		public boolean shouldPrintMessage(int timestamp, String message)
		{
			boolean result = timestamp - map.getOrDefault(message, -10) >= 10;
			if (result)
			{
				map.put(message, timestamp);
			}
			return result;
		}
	}
}
