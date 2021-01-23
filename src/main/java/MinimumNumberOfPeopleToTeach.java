import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 1/23/2021
 */
@LeetCode(
	id = 1733,
	name = "Minimum Number of People to Teach",
	url = "https://leetcode.com/problems/minimum-number-of-people-to-teach/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumNumberOfPeopleToTeach
{
	public int minimumTeachings(int n, int[][] languages, int[][] friendships)
	{
		Map<Integer, Set<Integer>> knownLanguages = new HashMap<>();
		for (int i = 0; i < languages.length; i++)
		{
			Set<Integer> collection = new HashSet<>();
			for (int l : languages[i])
			{
				collection.add(l);
			}
			knownLanguages.put(i + 1, collection);
		}

		boolean[] canCommunicate = new boolean[friendships.length];
		for (int i = 0; i < friendships.length; i++)
		{
			for (int languageA : knownLanguages.getOrDefault(friendships[i][0], Collections.emptySet()))
			{
				if (knownLanguages.getOrDefault(friendships[i][1], Collections.emptySet()).contains(languageA))
				{
					canCommunicate[i] = true;
					break;
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int language = 1; language <= n; language++)
		{
			Set<Integer> learned = new HashSet<>();
			for (int i = 0; i < friendships.length; i++)
			{
				if (canCommunicate[i])
				{
					continue;
				}

				if (!knownLanguages.getOrDefault(friendships[i][0], Collections.emptySet()).contains(language))
				{
					learned.add(friendships[i][0]);
				}

				if (!knownLanguages.getOrDefault(friendships[i][1], Collections.emptySet()).contains(language))
				{
					learned.add(friendships[i][1]);
				}
			}

			min = Math.min(min, learned.size());
		}

		return min;
	}

	public static void main(String[] args)
	{
		MinimumNumberOfPeopleToTeach clazz = new MinimumNumberOfPeopleToTeach();

		System.out.println(clazz.minimumTeachings(3, new int[][]{{2}, {1, 3}, {1, 2}, {3}}, new int[][]{{1, 4}, {1, 2}, {3, 4}, {2, 3}}));//2

		System.out.println(clazz.minimumTeachings(2, new int[][]{{1}, {2}, {1, 2}}, new int[][]{{1, 2}, {1, 3}, {2, 3}})); //1

		System.out.println(clazz.minimumTeachings(17,
			new int[][]{
				{4, 7, 2, 14, 6},
				{15, 13, 6, 3, 2, 7, 10, 8, 12, 4, 9},
				{16},
				{10},
				{10, 3},
				{4, 12, 8, 1, 16, 5, 15, 17, 13},
				{4, 13, 15, 8, 17, 3, 6, 14, 5, 10},
				{11, 4, 13, 8, 3, 14, 5, 7, 15, 6, 9, 17, 2, 16, 12},
				{4, 14, 6},
				{16, 17, 9, 3, 11, 14, 10, 12, 1, 8, 13, 4, 5, 6},
				{14},
				{7, 14},
				{17, 15, 10, 3, 2, 12, 16, 14, 1, 7, 9, 6, 4}
			},
			new int[][]{{4, 11}, {3, 5}, {7, 10}, {10, 12}, {5, 7}, {4, 5}, {3, 8}, {1, 5}, {1, 6}, {7, 8}, {4, 12}, {2, 4}, {8, 9}, {3, 10}, {4, 7},
				{5, 12}, {4, 9}, {1, 4}, {2, 8}, {1, 2}, {3, 4}, {5, 10}, {2, 7}, {1, 7}, {1, 8}, {8, 10}, {1, 9}, {1, 10}, {6, 7}, {3, 7}, {8, 12},
				{7, 9}, {9, 11}, {2, 5}, {2, 3}})); //4

		System.out.println(clazz.minimumTeachings(11,
			new int[][]{
				{3, 11, 5, 10, 1, 4, 9, 7, 2, 8, 6},
				{5, 10, 6, 4, 8, 7},
				{6, 11, 7, 9},
				{11, 10, 4},
				{6, 2, 8, 4, 3},
				{6, 2, 8, 4, 3},
				{9, 2, 8, 4, 6, 1, 5, 7, 3, 10},
				{7, 5, 11, 1, 3, 4},
				{3, 4, 11, 10, 6, 2, 1, 7, 5, 8, 9},
				{8, 6, 10, 2, 3, 1, 11, 5},
				{5, 11, 6, 4, 2}
			},
			new int[][]{{7, 9}, {3, 7}, {3, 4}, {2, 9}, {1, 8}, {5, 9}, {8, 9}, {6, 9}, {3, 5},
				{4, 5}, {4, 9}, {3, 6}, {1, 7}, {1, 3}, {2, 8}, {2, 6}, {5, 7}, {4, 6}, {5, 8},
				{5, 6}, {2, 7}, {4, 8}, {3, 8}, {6, 8}, {2, 5}, {1, 4}, {1, 9}, {1, 6}, {6, 7}})); //0
	}
}
