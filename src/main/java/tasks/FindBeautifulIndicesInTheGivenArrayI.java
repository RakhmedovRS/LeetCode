package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 1/14/2024
 */
@LeetCode(
		id = 3006,
		name = "Find Beautiful Indices in the Given Array I",
		url = "https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindBeautifulIndicesInTheGivenArrayI {
	public List<Integer> beautifulIndices(String s, String a, String b, int k) {
		TreeSet<Integer> indicesA = buildList(s, a);
		TreeSet<Integer> indicesB = buildList(s, b);
		List<Integer> answer = new ArrayList<>();
		for (int indexA : indicesA) {
			if (!indicesB.subSet(indexA - k, true, indexA + k, true).isEmpty()){
				answer.add(indexA);
			}
		}

		return answer;
	}

	private TreeSet<Integer> buildList(String source, String target) {
		TreeSet<Integer> indices = new TreeSet<>();
		int startIndex = 0;
		while (startIndex != -1) {
			int start = source.indexOf(target, startIndex);
			if (start != -1) {
				indices.add(start);
				startIndex = start + 1;
			} else {
				startIndex = start;
			}
		}

		return indices;
	}
}
