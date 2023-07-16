package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 1/10/2021
 */
@LeetCode(
		id = 1720,
		name = "Decode XORed Array",
		url = "https://leetcode.com/problems/decode-xored-array/",
		difficulty = Difficulty.EASY
)
public class DecodeXORedArray
{
	public int[] decode(int[] encoded, int first)
	{
		int[] answer = new int[encoded.length + 1];
		answer[0] = first;
		for (int i = 1; i < answer.length; i++)
		{
			answer[i] = answer[i - 1] ^ encoded[i - 1];
		}

		return answer;
	}

	public static void main(String[] args)
	{
		DecodeXORedArray clazz = new DecodeXORedArray();
		System.out.println(Arrays.toString(clazz.decode(new int[]{6, 2, 7, 3}, 4)));
		System.out.println(Arrays.toString(clazz.decode(new int[]{1, 2, 3}, 1)));
	}
}
