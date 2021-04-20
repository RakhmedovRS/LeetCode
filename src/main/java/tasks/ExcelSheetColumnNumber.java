package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Apr-20
 */
@LeetCode(id = 171, name = "Excel Sheet Column Number", url = "https://leetcode.com/problems/excel-sheet-column-number/")
public class ExcelSheetColumnNumber
{
	public int titleToNumber(String s) {
		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			result += Math.pow(26, s.length() - 1 - i) * (s.charAt(i) - ('A' - 1));
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
