import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Jul-20
 */
@LeetCode(id = 421, name = "Maximum XOR of Two Numbers in an Array", url = "https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/")
public class MaximumXOROfTwoNumbersInAnArray
{
	class Trie
	{
		Trie[] bit = new Trie[2];
	}

	public int findMaximumXOR(int[] nums)
	{
		Trie root = new Trie();
		for (int num : nums)
		{
			Trie current = root;
			int bit;
			for (int i = 31; i >= 0; i--)
			{
				bit = (num >> i) & 1;
				if (current.bit[bit] == null)
				{
					current.bit[bit] = new Trie();
				}
				current = current.bit[bit];
			}
		}

		int max = 0;
		int sum;
		for (int num : nums)
		{
			Trie current = root;
			int bit;
			sum = 0;
			for (int i = 31; i >= 0; i--)
			{
				bit = (num >> i) & 1;
				if (current.bit[bit ^ 1] != null)
				{
					current = current.bit[bit ^ 1];
					sum += (1 << i);
				}
				else
				{
					current = current.bit[bit];
				}
			}

			max = Math.max(max, sum);
		}

		return max;
	}
}
