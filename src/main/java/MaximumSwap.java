import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Jun-20
 */
@LeetCode(id = 670, name = "Maximum Swap", url = "https://leetcode.com/problems/maximum-swap/")
public class MaximumSwap
{
	public int maximumSwap(int num)
	{
		if (num < 10)
		{
			return num;
		}

		char[] chars = Integer.toString(num).toCharArray();

		for (int i = 0; i < chars.length - 1; i++)
		{
			int maxIndex = i;
			for (int j = i + 1; j < chars.length; j++)
			{
				if (chars[j] >= chars[maxIndex])
				{
					maxIndex = j;
				}
			}

			if (chars[i] < chars[maxIndex])
			{
				char temp = chars[maxIndex];
				chars[maxIndex] = chars[i];
				chars[i] = temp;
				return Integer.parseInt(new String(chars));
			}
		}

		return num;
	}

	public static void main(String[] args)
	{
		System.out.println(new MaximumSwap().maximumSwap(1993));
		System.out.println(new MaximumSwap().maximumSwap(2736));
		System.out.println(new MaximumSwap().maximumSwap(1234));
	}
}
