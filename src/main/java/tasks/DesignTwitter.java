package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 10/13/2020
 */
@LeetCode(id = 355, name = "Design Twitter", url = "https://leetcode.com/problems/design-twitter/")
public class DesignTwitter {
	class Twitter {
		int counter;
		Map<Integer, List<int[]>> userTweets;
		Map<Integer, Set<Integer>> subscriptions;

		public Twitter() {
			counter = 0;
			userTweets = new HashMap<>();
			subscriptions = new HashMap<>();
		}

		/**
		 * Compose a new tweet.
		 */
		public void postTweet(int userId, int tweetId) {
			userTweets.putIfAbsent(userId, new ArrayList<>());
			userTweets.get(userId).add(new int[]{counter++, tweetId});
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from
		 * most recent to least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));
			for (int id : subscriptions.getOrDefault(userId, Collections.emptySet())) {
				findTweets(minHeap, id);
			}

			findTweets(minHeap, userId);

			LinkedList<Integer> answer = new LinkedList<>();
			while (!minHeap.isEmpty()) {
				answer.addFirst(minHeap.remove()[1]);
			}

			return answer;
		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should be a no-op.
		 */
		public void follow(int followerId, int followeeId) {
			if (followerId == followeeId) {
				return;
			}
			subscriptions.putIfAbsent(followerId, new HashSet<>());
			subscriptions.get(followerId).add(followeeId);
		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			subscriptions.getOrDefault(followerId, Collections.emptySet()).remove(followeeId);
		}

		private void findTweets(PriorityQueue<int[]> minHeap, int id) {
			List<int[]> tweets = userTweets.getOrDefault(id, Collections.emptyList());
			for (int i = tweets.size() - 1; i >= 0; i--) {
				if (minHeap.size() == 10) {
					if (tweets.get(i)[0] > minHeap.peek()[0]) {
						minHeap.remove();
						minHeap.add(tweets.get(i));
					}
					else {
						return;
					}
				}
				else {
					minHeap.add(tweets.get(i));
				}
			}
		}
	}
}
