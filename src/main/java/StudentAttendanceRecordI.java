import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-May-20
 */
@LeetCode(id = 551, name = "Student Attendance Record I", url = "https://leetcode.com/problems/student-attendance-record-i/")
public class StudentAttendanceRecordI
{
	public boolean checkRecord(String s)
	{
		if (s == null || s.isEmpty())
		{
			return true;
		}

		int absentCount = 0;
		int lateCount = 0;
		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			if (ch == 'A')
			{
				absentCount++;
				lateCount = 0;
			}
			else if (ch == 'L')
			{
				lateCount++;
			}
			else
			{
				lateCount = 0;
			}

			if (absentCount > 1 || lateCount > 2)
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		System.out.println(new StudentAttendanceRecordI().checkRecord("LPLPLPLPLPL"));
	}
}
