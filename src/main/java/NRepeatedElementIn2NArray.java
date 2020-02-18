import java.util.HashSet;
import java.util.Set;

/**
 * N-Repeated Element in Size 2N Array
 * LeetCode 961
 *
 * @author RakhmedovRS
 * @created 18-Feb-20
 */
public class NRepeatedElementIn2NArray
{
	public int repeatedNTimes(int[] A)
	{
		Set<Integer> cache = new HashSet<>();
		for (int val : A)
		{
			if (!cache.add(val))
			{
				return val;
			}
		}

		return -1;
	}
}
