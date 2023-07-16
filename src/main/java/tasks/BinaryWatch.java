package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 09-May-20
 */
@LeetCode(
		id = 401,
		name = "Binary Watch",
		url = "https://leetcode.com/problems/binary-watch/",
		difficulty = Difficulty.EASY
)
public class BinaryWatch
{
	public List<String> readBinaryWatch(int num)
	{
		List<String> res = new ArrayList<>();
		if (num < 0 || num > 8)
		{
			return res;
		}

		for (int i = 0; i < 12; i++)
		{
			String hour = Integer.toString(i);
			for (int j = 0; j < 60; j++)
			{
				if (Integer.bitCount(i) + Integer.bitCount(j) == num)
				{
					String minute = j < 10 ? "0" + j : Integer.toString(j);
					res.add(hour + ":" + minute);
				}
			}
		}
		return res;
	}

	public static void main(String[] args)
	{
		System.out.println(new BinaryWatch().readBinaryWatch(2));
		System.out.println(new BinaryWatch().readBinaryWatch(1));
	}
}
