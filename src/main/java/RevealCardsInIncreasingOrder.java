import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 22-Jul-20
 */
@LeetCode(id = 950, name = "Reveal Cards In Increasing Order", url = "https://leetcode.com/problems/reveal-cards-in-increasing-order/")
public class RevealCardsInIncreasingOrder
{
	public int[] deckRevealedIncreasing(int[] deck)
	{
		int[] answer = new int[deck.length];
		Arrays.sort(deck);
		LinkedList<Integer> indices = new LinkedList<>();
		for (int i = 0; i < deck.length; i++)
		{
			indices.addLast(i);
		}

		for (int num : deck)
		{
			answer[indices.removeFirst()] = num;
			if (!indices.isEmpty())
			{
				indices.addLast(indices.removeFirst());
			}
		}

		return answer;
	}
}
