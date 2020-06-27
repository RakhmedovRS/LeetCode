import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 27-Jun-20
 */
@LeetCode(id = 1491, name = "Average Salary Excluding the Minimum and Maximum Salary", url = "https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/")
public class AverageSalaryExcludingTheMinimumAndMaximumSalary
{
	public double average(int[] salary)
	{
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		double sum = 0;
		for (double val : salary)
		{
			sum += val;
			min = Math.min(min, val);
			max = Math.max(max, val);
		}

		sum -= min;
		sum -= max;

		return sum / (salary.length - 2);
	}
}
