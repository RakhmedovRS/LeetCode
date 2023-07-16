package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/15/2021
 */
@LeetCode(
		id = 690,
		name = "Employee Importance",
		url = "https://leetcode.com/problems/employee-importance/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class EmployeeImportance
{
	class Employee
	{
		public int id;
		public int importance;
		public List<Integer> subordinates;
	}

	public int getImportance(List<Employee> employees, int id)
	{
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee employee : employees)
		{
			map.put(employee.id, employee);
		}

		return calcImportance(map.get(id), map, new HashMap<>());
	}

	private int calcImportance(Employee employee, Map<Integer, Employee> map, Map<Integer, Integer> memo)
	{
		if (memo.containsKey(employee.id))
		{
			return memo.get(employee.id);
		}

		int total = employee.importance;
		for (Integer subId : map.get(employee.id).subordinates)
		{
			total += calcImportance(map.get(subId), map, memo);
		}

		memo.put(employee.id, total);

		return total;
	}
}
