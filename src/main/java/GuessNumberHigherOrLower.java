import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-May-20
 */
@LeetCode(id = 374, name = "Guess Number Higher or Lower", url = "https://leetcode.com/problems/guess-number-higher-or-lower/")
public abstract class GuessNumberHigherOrLower
{
	abstract int guess(int num);

	public int guessNumber(int n)
	{
		int left = 1;
		int right = n;
		int middle;
		while (left < right)
		{
			middle = left + (right - left) / 2;
			int g = guess(middle);
			if (g == 0)
			{
				return middle;
			}
			else if (g < 0)
			{
				right = middle - 1;
			}
			else
			{
				left = middle + 1;
			}
		}
		return left;
	}
}
