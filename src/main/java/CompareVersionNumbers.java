import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-Jun-20
 */
@LeetCode(id = 165, name = "Compare Version Numbers", url = "https://leetcode.com/problems/compare-version-numbers/")
public class CompareVersionNumbers
{
	public int compareVersion(String version1, String version2)
	{
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		int v1Index = 0;
		int v2Index = 0;
		int ver1;
		int ver2;
		while (v1Index < v1.length || v2Index < v2.length)
		{
			ver1 = v1Index < v1.length ? Integer.parseInt(v1[v1Index++]) : 0;
			ver2 = v2Index < v2.length ? Integer.parseInt(v2[v2Index++]) : 0;
			if (ver1 > ver2)
			{
				return 1;
			}
			else if (ver1 < ver2)
			{
				return -1;
			}
		}

		return 0;
	}

	public static void main(String[] args)
	{
		System.out.println(new CompareVersionNumbers().compareVersion("1.0", "1"));
		System.out.println(new CompareVersionNumbers().compareVersion("1", "1"));
		System.out.println(new CompareVersionNumbers().compareVersion("7.5.2.4", "7.5.3"));
	}
}
