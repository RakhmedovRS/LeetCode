package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 11-Jul-20
 */
@LeetCode(id = 1507, name = "Reformat Date", url = "https://leetcode.com/problems/reformat-date/")
public class ReformatDate {
	public String reformatDate(String date) {
		String[] mouths = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < mouths.length; i++) {
			map.put(mouths[i], i + 1);
		}

		String[] parts = date.split(" ");
		StringBuilder sb = new StringBuilder();
		sb.append(parts[2]);
		sb.append("-");
		sb.append(map.get(parts[1]) > 9 ? map.get(parts[1]) : "0" + map.get(parts[1]));
		sb.append("-");
		if (Character.isDigit(parts[0].charAt(0)) && Character.isDigit(parts[0].charAt(1))) {
			sb.append(parts[0].charAt(0));
			sb.append(parts[0].charAt(1));
		}
		else {
			sb.append(0);
			sb.append(parts[0].charAt(0));
		}

		return sb.toString();
	}
}
