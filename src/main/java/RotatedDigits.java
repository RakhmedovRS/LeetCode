import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Jun-20
 */
@LeetCode(id = 788, name = "Rotated Digits", url = "https://leetcode.com/problems/rotated-digits/")
public class RotatedDigits
{
	public int rotatedDigits(int N)
	{
		int answer = 0;
		int num;
		int rest;
		boolean metBad;
		boolean metGood;
		for (int i = 1; i <= N; i++)
		{
			num = i;
			metBad = false;
			metGood = false;
			while (num > 0)
			{
				rest = num % 10;
				if (rest == 3 || rest == 4 || rest == 7)
				{
					metBad = true;
					break;
				}

				if (rest == 2 || rest == 5 || rest == 6 || rest == 9)
				{
					metGood = true;
				}

				num /= 10;
			}

			if (!metBad && metGood)
			{
				answer++;
			}
		}

		return answer;
	}
}
