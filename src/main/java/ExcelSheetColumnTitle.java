import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 31-May-20
 */
@LeetCode(id = 168, name = "Excel Sheet Column Title", url = "https://leetcode.com/problems/excel-sheet-column-title/")
public class ExcelSheetColumnTitle
{
	public String convertToTitle(int n)
	{
		StringBuilder stringBuilder = new StringBuilder();
		char[] chars = "_ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		while (n > 0)
		{
			n--;
			stringBuilder.append(chars[1 + n % 26]);
			n /= 26;
		}
		return stringBuilder.reverse().toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));
	}
}
