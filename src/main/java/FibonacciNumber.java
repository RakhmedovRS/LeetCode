/**
 * Fibonacci Number
 * LeetCode 509
 *
 * @author RakhmedovRS
 * @created 13-Feb-20
 */
public class FibonacciNumber
{
	static int[] FIB = new int[31];
	static {
		FIB[0] = 0;
		FIB[1] = 1;
		for (int i = 2; i < FIB.length; i++)
		{
			FIB[i] = FIB[i-2] + FIB[i-1];
		}
	}

	public int fib(int N) {
		return FIB[N];
	}
}
