package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 28-May-20
 */
@LeetCode(id = 796, name = "Rotate String", url = "https://leetcode.com/problems/rotate-string/")
public class RotateString
{
	public boolean rotateString(String A, String B)
	{
		if (A == null && B == null)
		{
			return true;
		}
		else if (A == null || B == null)
		{
			return false;
		}
		else if (A.isEmpty() && B.isEmpty())
		{
			return true;
		}
		else if (A.length() != B.length())
		{
			return false;
		}

		List<Integer> startPositions = new ArrayList<>();
		char firstLetter = A.charAt(0);
		for (int i = 0; i < B.length(); i++)
		{
			if (B.charAt(i) == firstLetter)
			{
				startPositions.add(i);
			}
		}

		for (int index : startPositions)
		{
			int aIndex = 0;
			int bIndex = index;
			while (bIndex < B.length() && A.charAt(aIndex) == B.charAt(bIndex))
			{
				aIndex++;
				bIndex++;
				if (bIndex == B.length())
				{
					bIndex = 0;
				}

				if (bIndex == index)
				{
					return true;
				}
			}
		}

		return false;
	}
}
