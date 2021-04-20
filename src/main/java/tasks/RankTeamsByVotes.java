package tasks;

import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 05-Aug-20
 */
@LeetCode(id = 1366, name = "Rank Teams by Votes", url = "https://leetcode.com/problems/rank-teams-by-votes/")
public class RankTeamsByVotes
{
	public String rankTeams(String[] votes)
	{
		char[][] counts = new char[votes[0].length()][26];
		boolean[] seen = new boolean[26];
		for (int i = 0; i < counts.length; i++)
		{
			for (String vote : votes)
			{
				counts[i][vote.charAt(i) - 'A']++;
				seen[vote.charAt(i) - 'A'] = true;
			}
		}

		PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) ->
		{
			for (int level = 0; level < counts.length; level++)
			{
				if (counts[level][c1 - 'A'] != counts[level][c2 - 'A'])
				{
					return counts[level][c2 - 'A'] - counts[level][c1 - 'A'];
				}
			}

			return c1 - c2;
		});

		for (int i = 0; i < 26; i++)
		{
			if (seen[i])
			{
				maxHeap.add((char) (i + 'A'));
			}
		}

		StringBuilder answer = new StringBuilder();
		while (!maxHeap.isEmpty())
		{
			answer.append(maxHeap.remove());
		}

		return answer.toString();
	}
}
