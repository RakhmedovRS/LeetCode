import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 3/22/2021
 */
@LeetCode(
	id = 1088,
	name = "Confusing Number II",
	url = "https://leetcode.com/problems/confusing-number-ii/",
	difficulty = Difficulty.HARD,
	premium = true
)
public class ConfusingNumberII
{
	public int confusingNumberII(int N)
	{
		int[] numbers = new int[]{0, 1, 6, 8, 9};
		int[] answer = new int[1];
		for (int i = 1; i <= String.valueOf(N).length(); i++)
		{
			dfs(0, i, numbers, answer, N);
		}

		return answer[0];
	}

	private void dfs(long n, int i, int[] numbers, int[] answer, int N)
	{
		if (n > N)
		{
			return;
		}

		if (i == 0)
		{
			if (isConfusingNumber(n))
			{
				answer[0]++;
			}
			return;
		}

		for (int pos = n == 0 ? 1 : 0; pos < numbers.length; pos++)
		{
			dfs(n * 10 + numbers[pos], i - 1, numbers, answer, N);
		}
	}

	private boolean isConfusingNumber(long number)
	{
		String value = String.valueOf(number);
		StringBuilder sb = new StringBuilder();
		for (int i = value.length() - 1; i >= 0; i--)
		{
			sb.append(getRotatedChar(value.charAt(i)));
		}

		return !value.equals(sb.toString());
	}

	private char getRotatedChar(char ch)
	{
		if (ch == '6')
		{
			return '9';
		}
		else if (ch == '9')
		{
			return '6';
		}
		return ch;
	}

	public static void main(String[] args)
	{
		ConfusingNumberII clazz = new ConfusingNumberII();
		System.out.println(clazz.confusingNumberII(1000000000));
		System.out.println(clazz.confusingNumberII(195));
		System.out.println(clazz.confusingNumberII(100));
		System.out.println(clazz.confusingNumberII(20));
	}
}
