package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/5/2020
 */
@LeetCode(
		id = 1244,
		name = "Design A Leaderboard",
		url = "https://leetcode.com/problems/design-a-leaderboard/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class DesignLeaderboard
{
	class Leaderboard
	{
		Map<Integer, Integer> idToScore;
		TreeSet<Integer> board;

		public Leaderboard()
		{
			idToScore = new HashMap<>();
			board = new TreeSet<>((id1, id2) ->
			{
				if (idToScore.get(id2).equals(idToScore.get(id1)))
				{
					return id1 - id2;
				}

				return idToScore.get(id2) - idToScore.get(id1);
			});
		}

		public void addScore(int playerId, int score)
		{
			if (idToScore.containsKey(playerId))
			{
				board.remove(playerId);
			}

			score += idToScore.getOrDefault(playerId, 0);
			idToScore.put(playerId, score);
			board.add(playerId);
		}

		public int top(int K)
		{
			int sum = 0;
			for (Integer id : board)
			{
				sum += idToScore.get(id);
				if (--K == 0)
				{
					break;
				}
			}

			return sum;
		}

		public void reset(int playerId)
		{
			board.remove(playerId);
			idToScore.remove(playerId);
		}
	}

	public static void main(String[] args)
	{
		Leaderboard leaderboard = new DesignLeaderboard().new Leaderboard();
		leaderboard.addScore(1, 73);   // leaderboard = [[1,73]];
		leaderboard.addScore(2, 56);   // leaderboard = [[1,73],[2,56]];
		leaderboard.addScore(3, 39);   // leaderboard = [[1,73],[2,56],[3,39]];
		leaderboard.addScore(4, 51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
		leaderboard.addScore(5, 4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
		System.out.println(leaderboard.top(1));           // returns 73;
		leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
		leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
		leaderboard.addScore(2, 51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
		System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
	}
}
