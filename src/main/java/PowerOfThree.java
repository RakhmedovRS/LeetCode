import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Mar-20
 */
@LeetCode(id = 326, name = "Power of Three", url = "https://leetcode.com/problems/power-of-three/")
public class PowerOfThree
{
	public boolean isPowerOfThree(int n)
	{
		if (n == 1)
		{
			return true;
		}

		if (n == 0 || n % 3 != 0)
		{
			return false;
		}
		else
		{
			return isPowerOfThree(n / 3);
		}
	}
}
