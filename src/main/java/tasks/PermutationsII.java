package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author RakhmedovRS
 * @created 11/12/2020
 */
@LeetCode(
	id = 47,
	name = "Permutations II",
	url = "https://leetcode.com/problems/permutations-ii/",
	difficulty = Difficulty.MEDIUM
)
public class PermutationsII
{
	class Trie
	{
		Trie[] children = new Trie[21];
	}

	public List<List<Integer>> permuteUnique(int[] nums)
	{
		List<List<Integer>> answer = new ArrayList<>();
		Trie root = new Trie();
		permute(0, nums, new LinkedList<>(), root, answer::add);
		return answer;
	}

	private void permute(int used, int[] nums, LinkedList<Integer> current, Trie root, Consumer<List<Integer>> consumer)
	{
		if (current.size() == nums.length)
		{
			if (addToTrie(root, current))
			{
				consumer.accept(new ArrayList<>(current));
			}

			return;
		}

		for (int i = 0; i < nums.length; i++)
		{
			if ((used & (1 << i)) == 0)
			{
				current.addLast(nums[i]);
				permute(used ^ (1 << i), nums, current, root, consumer);
				current.removeLast();
			}
		}
	}

	private boolean addToTrie(Trie root, LinkedList<Integer> current)
	{
		boolean added = false;
		for (int val : current)
		{
			if (root.children[val + 10] == null)
			{
				added = true;
				root.children[val + 10] = new Trie();
			}
			root = root.children[val + 10];
		}

		return added;
	}
}
