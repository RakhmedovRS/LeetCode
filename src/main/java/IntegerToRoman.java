import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 24-Feb-20
 */
@LeetCode(id = 12, name = "Integer to Roman", url = "https://leetcode.com/problems/integer-to-roman/")
public class IntegerToRoman
{
	static List<Map.Entry<Integer, String>> dictionary = new ArrayList<>();

	static
	{
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(1000, "M"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(900, "CM"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(500, "D"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(400, "CD"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(100, "C"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(90, "XC"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(50, "L"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(40, "XL"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(10, "X"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(9, "IX"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(5, "V"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(4, "IV"));
		dictionary.add(new java.util.AbstractMap.SimpleEntry<>(1, "I"));
	}

	public String intToRoman(int num)
	{
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Integer, String> entry : dictionary)
		{
			if (num == 0)
			{
				break;
			}

			while (num > 0 && num >= entry.getKey())
			{
				result.append(entry.getValue());
				num -= entry.getKey();
			}
		}

		return result.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new IntegerToRoman().intToRoman(1));
		System.out.println(new IntegerToRoman().intToRoman(3));
		System.out.println(new IntegerToRoman().intToRoman(4));
		System.out.println(new IntegerToRoman().intToRoman(6));
		System.out.println(new IntegerToRoman().intToRoman(9));
		System.out.println(new IntegerToRoman().intToRoman(10));
	}
}
