package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 24-Jun-20
 */
@LeetCode(id = 1418, name = "Display Table of Food Orders in a Restaurant", url = "https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/")
public class DisplayTableOfFoodOrdersInRestaurant {
	public List<List<String>> displayTable(List<List<String>> orders) {
		TreeSet<String> dishes = new TreeSet<>();
		TreeSet<Integer> tables = new TreeSet<>();
		Map<String, Integer> tableToDishes = new HashMap<>();

		for (List<String> order : orders) {
			String dish = order.get(2);
			String table = order.get(1);

			dishes.add(dish);
			tables.add(Integer.parseInt(table));

			String dishAndTable = table + "_" + dish;
			tableToDishes.put(dishAndTable, tableToDishes.getOrDefault(dishAndTable, 0) + 1);
		}

		List<List<String>> result = new ArrayList<>();
		if (dishes.isEmpty()) {
			return result;
		}

		List<String> header = new ArrayList<>();
		header.add("Table");
		header.addAll(dishes);
		result.add(header);

		for (int tableInt : tables) {
			String table = String.valueOf(tableInt);
			List<String> row = new ArrayList<>();
			row.add(table);
			for (String dish : dishes) {
				row.add(String.valueOf(tableToDishes.getOrDefault(table + "_" + dish, 0)));
			}
			result.add(row);
		}

		return result;
	}
}
