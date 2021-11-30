package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 10/18/2020
 */
@LeetCode(
	id = 1626,
	name = "Best Team With No Conflicts",
	url = "https://leetcode.com/problems/best-team-with-no-conflicts/",
	difficulty = Difficulty.MEDIUM
)
public class BestTeamWithNoConflicts
{
	static class Player
	{
		int age;
		int score;

		public Player(int age, int score)
		{
			this.age = age;
			this.score = score;
		}
	}

	public int bestTeamScore(int[] scores, int[] ages)
	{
		List<Player> players = new ArrayList<>(scores.length);
		for (int i = 0; i < scores.length; i++)
		{
			players.add(new Player(ages[i], scores[i]));
		}

		players.sort((p1, p2) ->
		{
			if (p1.age == p2.age)
			{
				return p1.score - p2.score;
			}

			return p1.age - p2.age;
		});

		int[] dp = new int[players.size()];
		int max = 0;
		int currentMax;
		Player player;
		for (int i = 0; i < dp.length; i++)
		{
			dp[i] = players.get(i).score;
			currentMax = 0;
			player = players.get(i);
			for (int j = 0; j < i; j++)
			{
				if (players.get(j).score <= player.score)
				{
					currentMax = Math.max(currentMax, dp[j]);
				}
			}
			dp[i] += currentMax;
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	public static void main(String[] args)
	{
		System.out.println(new BestTeamWithNoConflicts().bestTeamScore(
			new int[]{578, 141, 564, 931, 422, 316, 395, 116, 712, 573, 795, 255, 842, 615, 736, 619, 537, 350, 962, 716, 903, 693, 934, 265, 251, 443, 393, 637, 85, 316, 659, 414, 366, 726, 372, 49, 456, 92, 662, 218, 15, 68, 615, 80, 12, 259, 707, 376, 696, 420, 447, 371, 743, 491, 725, 678, 227, 360, 378, 681, 674, 587, 581, 288, 716, 628, 259, 598, 531},
			new int[]{3, 16, 50, 90, 63, 58, 72, 59, 21, 84, 59, 58, 33, 28, 27, 46, 87, 51, 1, 49, 79, 55, 97, 23, 66, 67, 42, 79, 56, 54, 18, 60, 3, 17, 30, 32, 26, 24, 48, 12, 47, 12, 44, 90, 88, 62, 41, 38, 77, 39, 54, 95, 12, 36, 56, 59, 62, 80, 29, 50, 51, 58, 14, 76, 4, 85, 6, 53, 57})); //9698
		System.out.println(new BestTeamWithNoConflicts().bestTeamScore(new int[]{1, 2, 3, 5}, new int[]{8, 9, 10, 1})); //6
		System.out.println(new BestTeamWithNoConflicts().bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1})); //16
		System.out.println(new BestTeamWithNoConflicts().bestTeamScore(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5})); //34
	}
}
