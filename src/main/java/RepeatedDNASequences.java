import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 20-Jun-20
 */
@LeetCode(id = 187, name = "Repeated DNA Sequences", url = "https://leetcode.com/problems/repeated-dna-sequences/")
public class RepeatedDNASequences
{
	public List<String> findRepeatedDnaSequences(String s)
	{
		Set<String> set = new HashSet<>();
		Set<String> result = new HashSet<>();
		for (int i = 0; i <= s.length() - 10; i++)
		{
			String str = s.substring(i, i + 10);
			if (!set.add(str))
			{
				result.add(str);
			}
		}
		return new ArrayList<>(result);
	}

	public static void main(String[] args)
	{
		System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
}
