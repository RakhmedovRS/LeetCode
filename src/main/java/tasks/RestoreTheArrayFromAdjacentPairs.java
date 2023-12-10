package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 31-Jan-21
 */
@LeetCode(
		id = 1743,
		name = "Restore the Array From Adjacent Pairs",
		url = "https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/",
		difficulty = Difficulty.MEDIUM
)
public class RestoreTheArrayFromAdjacentPairs {
	class Link {
		Link left;
		Link right;
		int value;

		public Link(int value) {
			this.value = value;
		}
	}

	public int[] restoreArray(int[][] adjacentPairs) {
		Map<Integer, Link> map = new HashMap<>();
		Link aLink;
		Link bLink;
		for (int[] pair : adjacentPairs) {
			aLink = map.getOrDefault(pair[0], new Link(pair[0]));
			bLink = map.getOrDefault(pair[1], new Link(pair[1]));

			if (aLink.right == null) {
				aLink.right = bLink;
			}
			else {
				aLink.left = bLink;
			}

			if (bLink.left == null) {
				bLink.left = aLink;
			}
			else {
				bLink.right = aLink;
			}

			map.putIfAbsent(pair[0], aLink);
			map.putIfAbsent(pair[1], bLink);
		}

		int pos = 0;
		int[] answer = new int[adjacentPairs.length + 1];
		for (Map.Entry<Integer, Link> entry : map.entrySet()) {
			if (entry.getValue().left == null || entry.getValue().right == null) {
				Link prev = entry.getValue();
				Link current = prev.left == null ? prev.right : prev.left;
				answer[pos++] = prev.value;
				while (current != null) {
					answer[pos++] = current.value;
					if (current.left != null && current.left == prev) {
						prev = current;
						current = current.right;
					}
					else {
						prev = current;
						current = current.left;
					}

				}

				break;
			}
		}


		return answer;
	}

	public static void main(String[] args) {
		RestoreTheArrayFromAdjacentPairs clazz = new RestoreTheArrayFromAdjacentPairs();
		System.out.println(Arrays.toString(clazz.restoreArray(new int[][]
				{
						{2, 1},
						{3, 4},
						{3, 2}
				})));
	}
}
