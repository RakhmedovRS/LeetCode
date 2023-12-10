package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/25/2021
 */
@LeetCode(
		id = 2115,
		name = "Find All Possible Recipes from Given Supplies",
		url = "https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/",
		difficulty = Difficulty.MEDIUM
)
public class FindAllPossibleRecipesFromGivenSupplies {
	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
		List<String> answer = new ArrayList<>();
		Set<String> supSet = new HashSet<>(Arrays.asList(supplies));

		boolean[] used = new boolean[recipes.length];

		boolean created = true;
		while (created) {
			created = false;

			outer:
			for (int i = 0; i < recipes.length; i++) {
				if (used[i]) {
					continue;
				}

				for (String ingredient : ingredients.get(i)) {
					if (!supSet.contains(ingredient)) {
						continue outer;
					}
				}

				answer.add(recipes[i]);
				supSet.add(recipes[i]);
				used[i] = true;
				created = true;
			}
		}

		return answer;
	}
}
