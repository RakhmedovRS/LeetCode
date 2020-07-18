import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 18-Jul-20
 */
@LeetCode(id = 1006, name = "Clumsy Factorial", url = "Clumsy Factorial")
public class ClumsyFactorial
{
	public int clumsy(int N)
	{
		int sum = calSub(N) * 2;
		while (N > 0)
		{
			sum -= calSub(N);
			N -= 3;
			if (N > 0)
			{
				sum += N;
				N--;
			}
		}

		return sum;
	}

	private int calSub(int N)
	{
		return N * (N > 1 ? N - 1 : 1) / (N > 2 ? N - 2 : 1);
	}

	public static void main(String[] args)
	{
		System.out.println(new ClumsyFactorial().clumsy(1));
		System.out.println(new ClumsyFactorial().clumsy(10));
		System.out.println(new ClumsyFactorial().clumsy(4));
	}
}
