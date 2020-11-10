import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/10/2020
 */
@LeetCode(id = 552, name = "Student Attendance Record II", url = "https://leetcode.com/problems/student-attendance-record-ii/")
public class StudentAttendanceRecordII
{
	int MOD = 1_000_000_007;

	public int checkRecord(int n)
	{
		return dfs(n, 0, 0, new Integer[n + 1][2][3]);
	}

	private int dfs(int n, int A, int L, Integer[][][] memo)
	{
		if (n == 0)
		{
			return 1;
		}

		if (memo[n][A][L] != null)
		{
			return memo[n][A][L];
		}

		int result = 0;
		if (A == 0)
		{
			result += dfs(n - 1, 1, 0, memo);
			result %= MOD;
		}

		if (L < 2)
		{
			result += dfs(n - 1, A, L + 1, memo);
			result %= MOD;
		}

		result += dfs(n - 1, A, 0, memo);
		result %= MOD;
		memo[n][A][L] = result;

		return result;
	}
}
