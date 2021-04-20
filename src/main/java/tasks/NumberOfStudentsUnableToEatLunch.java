package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 12/26/2020
 */
@LeetCode(
	id = 1700,
	name = "Number of Students Unable to Eat Lunch",
	url = "https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/",
	difficulty = Difficulty.EASY
)
public class NumberOfStudentsUnableToEatLunch
{
	public int countStudents(int[] students, int[] sandwiches)
	{
		LinkedList<Integer> st = new LinkedList<>();
		for (int student : students)
		{
			st.add(student);
		}

		LinkedList<Integer> sa = new LinkedList<>();
		for (int sandwich : sandwiches)
		{
			sa.add(sandwich);
		}

		int prevSize = 0;
		while (!st.isEmpty() && st.size() != prevSize)
		{
			int size = st.size();
			prevSize = st.size();
			while (size-- > 0)
			{
				if (st.getFirst().equals(sa.getFirst()))
				{
					st.removeFirst();
					sa.removeFirst();
				}
				else
				{
					st.addLast(st.removeFirst());
				}
			}
		}

		return st.size();
	}

	public static void main(String[] args)
	{
		NumberOfStudentsUnableToEatLunch clazz = new NumberOfStudentsUnableToEatLunch();
		System.out.println(clazz.countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
		System.out.println(clazz.countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
	}
}
