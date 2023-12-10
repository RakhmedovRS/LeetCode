package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 11/9/2020
 */
@LeetCode(
		id = 1348,
		name = "Tweet Counts Per Frequency",
		url = "https://leetcode.com/problems/tweet-counts-per-frequency/",
		difficulty = Difficulty.MEDIUM
)
public class TweetCountsPerFrequency {
	class TweetCounts {
		Map<String, TreeMap<Integer, Integer>> history;

		public TweetCounts() {
			history = new TreeMap<>();
		}

		public void recordTweet(String tweetName, int time) {
			history.putIfAbsent(tweetName, new TreeMap<>());
			int count = history.get(tweetName).getOrDefault(time, 0);
			history.get(tweetName).put(time, count + 1);
		}

		public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
			List<Integer> answer = new ArrayList<>();
			int interval = freq.equals("day") ? 60 * 60 * 24 : freq.equals("hour") ? 60 * 60 : 60;
			int[] bucket = new int[(endTime - startTime) / interval + 1];

			TreeMap<Integer, Integer> tweets = history.get(tweetName);
			for (Map.Entry<Integer, Integer> tweet : tweets.subMap(startTime, endTime + 1).entrySet()) {
				int index = (tweet.getKey() - startTime) / interval;
				bucket[index] += tweet.getValue();
			}

			for (int count : bucket) {
				answer.add(count);
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		TweetCounts tweetCounts = new TweetCountsPerFrequency().new TweetCounts();
		tweetCounts.recordTweet("tweet2", 61);
		System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet2", 78, 5374));

		System.out.println("________");

		tweetCounts = new TweetCountsPerFrequency().new TweetCounts();
		tweetCounts.recordTweet("tweet3", 0);
		tweetCounts.recordTweet("tweet3", 60);
		tweetCounts.recordTweet("tweet3", 10);
		System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59));
		System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60));
		tweetCounts.recordTweet("tweet3", 120);
		System.out.println(tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210));

		System.out.println("________");

		tweetCounts = new TweetCountsPerFrequency().new TweetCounts();
		tweetCounts.recordTweet("tweet0", 13);
		tweetCounts.recordTweet("tweet1", 16);
		tweetCounts.recordTweet("tweet2", 12);
		tweetCounts.recordTweet("tweet2", 12);
		tweetCounts.recordTweet("tweet3", 18);
		tweetCounts.recordTweet("tweet4", 82);
		tweetCounts.recordTweet("tweet3", 89);
		System.out.println(tweetCounts.getTweetCountsPerFrequency("day", "tweet0", 89, 9471));
		System.out.println(tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 13, 4024));
	}
}
