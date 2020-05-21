import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-May-20
 */
@LeetCode(id = 434, name = "Number of Segments in a String", url = "https://leetcode.com/problems/number-of-segments-in-a-string/")
public class NumberOfSegmentsInString
{
	public int countSegments(String s)
	{
		if (s == null || s.isEmpty())
		{
			return 0;
		}

		int count = 0;
		String[] values = s.split(" ");
		for (String value : values)
		{
			if (!value.isEmpty())
			{
				count++;
			}
		}

		return count;
	}
}
