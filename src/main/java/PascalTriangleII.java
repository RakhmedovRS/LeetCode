import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 05-May-20
 */
@LeetCode(id = 119, name = "Pascal's Triangle II", url = "https://leetcode.com/problems/pascals-triangle-ii/")
public class PascalTriangleII
{
	public List<Integer> getRow(int rowIndex)
	{
		List<Integer> prevRow = new ArrayList<>();
		prevRow.add(1);

		List<Integer> currentRow = new ArrayList<>(prevRow);
		while (rowIndex-- >= 0)
		{
			prevRow = new ArrayList<>(currentRow);
			currentRow = new ArrayList<>();
			for (int i = 0; i <= prevRow.size(); i++)
			{
				int left = i == 0 ? 0 : prevRow.get(i - 1);
				int right = i == prevRow.size() ? 0 : prevRow.get(i);
				currentRow.add(left + right);
			}
		}

		return prevRow;
	}

	public static void main(String[] args)
	{
		System.out.println(new PascalTriangleII().getRow(3));
	}
}
