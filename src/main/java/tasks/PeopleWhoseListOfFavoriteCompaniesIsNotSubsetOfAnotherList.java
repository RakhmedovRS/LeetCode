package tasks;

import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 15-Aug-20
 */
@LeetCode(id = 1452, name = "People Whose List of Favorite Companies Is Not a Subset of Another List", url = "https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/")
public class PeopleWhoseListOfFavoriteCompaniesIsNotSubsetOfAnotherList
{
	public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
		List<Integer> answer = new ArrayList<>();
		List<Set<String>> sets = new ArrayList<>(favoriteCompanies.size());
		for (List<String> list: favoriteCompanies) {
			sets.add(new HashSet<>(list));
		}

		outer:
		for (int i = 0; i < favoriteCompanies.size(); i++) {
			for (int j = 0; j < favoriteCompanies.size(); j++) {
				if (i != j) {
					if (sets.get(j).containsAll(favoriteCompanies.get(i))) {
						continue outer;
					}
				}
			}
			answer.add(i);
		}

		return answer;
	}

	public static void main(String[] args)
	{

	}
}
