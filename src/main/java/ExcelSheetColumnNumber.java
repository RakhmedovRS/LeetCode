import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Apr-20
 */
@LeetCode(id = 171, name = "Excel Sheet Column Number", url = "https://leetcode.com/problems/excel-sheet-column-number/")
public class ExcelSheetColumnNumber
{
	public int titleToNumber(String s)
	{
		if (s == null || s.length() == 0)
		{
			return 0;
		}

		char[] chars = s.toCharArray();
		int pos = 0;
		int result = 0;
		for (int i = chars.length - 1; i >= 0; i--)
		{
			int val = (int)Math.pow(26, pos) * (chars[i] - 64);
			result += val;
			pos++;
		}

		return result;
	}

	public static void main(String[] args)
	{
		System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZY"));
		System.out.println(new ExcelSheetColumnNumber().titleToNumber("AA"));
		System.out.println(new ExcelSheetColumnNumber().titleToNumber("AB"));
	}
}
