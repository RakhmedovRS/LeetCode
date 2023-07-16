package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 25-Apr-20
 */
@LeetCode(
		id = 67,
		name = "Add Binary",
		url = "https://leetcode.com/problems/add-binary/",
		difficulty = Difficulty.EASY
)
public class AddBinary
{
	public String addBinary(String a, String b)
	{
		List<Integer> temp = new ArrayList<>();
		int aCounter = a.length() - 1;
		int bCounter = b.length() - 1;
		int curr;
		boolean add = false;
		while (aCounter >= 0 || bCounter >= 0 || add)
		{
			curr = 0;

			if (aCounter >= 0)
			{
				curr += a.charAt(aCounter) == '1' ? 1 : 0;
				aCounter--;
			}

			if (bCounter >= 0)
			{
				curr += b.charAt(bCounter) == '1' ? 1 : 0;
				bCounter--;
			}

			if (curr > 1 && add)
			{
				curr = 1;
			}
			else if (curr > 1)
			{
				add = true;
				curr = 0;
			}
			else if (curr == 1 && add)
			{
				curr = 0;
			}
			else if (add)
			{
				curr = 1;
				add = false;
			}

			temp.add(curr);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = temp.size() - 1; i >= 0; i--)
		{
			sb.append(temp.get(i));
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new AddBinary().addBinary("1010", "1011"));
		System.out.println(new AddBinary().addBinary("11", "1"));
	}
}
