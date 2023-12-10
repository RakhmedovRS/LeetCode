package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 9/18/2022
 */
@LeetCode(
		id = 2409,
		name = "Count Days Spent Together",
		url = "https://leetcode.com/problems/count-days-spent-together/",
		difficulty = Difficulty.EASY
)
public class CountDaysSpentTogether {
	public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
		int[] days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int together = 0;
		int aliceM = Integer.parseInt(arriveAlice.split("-")[0]);
		int aliceD = Integer.parseInt(arriveAlice.split("-")[1]);
		int aliceLeftM = Integer.parseInt(leaveAlice.split("-")[0]);
		int aliceLeftD = Integer.parseInt(leaveAlice.split("-")[1]);


		Map<Integer, int[]> memo = new HashMap<>();
		for (int i = 1; i < days.length; i++) {
			memo.put(i, new int[days[i] + 2]);
		}

		while (aliceM <= aliceLeftM) {
			if (aliceD == days[aliceM]) {
				memo.get(aliceM)[aliceD]++;
				aliceD = 1;
				aliceM++;
			}

			if (aliceM <= aliceLeftM) {
				memo.get(aliceM)[aliceD++]++;
			}

			if (aliceD >= aliceLeftD && aliceM == aliceLeftM) {
				if (aliceD == aliceLeftD) {
					memo.get(aliceM)[aliceD]++;
				}
				break;
			}
		}


		int bobM = Integer.parseInt(arriveBob.split("-")[0]);
		int bobD = Integer.parseInt(arriveBob.split("-")[1]);
		int bobLeftM = Integer.parseInt(leaveBob.split("-")[0]);
		int bobLeftD = Integer.parseInt(leaveBob.split("-")[1]);

		while (bobM <= bobLeftM) {
			if (bobD == days[bobM]) {
				memo.get(bobM)[bobD]++;
				bobD = 1;
				bobM++;
			}

			if (bobM <= bobLeftM) {
				memo.get(bobM)[bobD++]++;
			}

			if (bobD >= bobLeftD && bobM == bobLeftM) {
				if (bobD == bobLeftD) {
					memo.get(bobM)[bobD]++;
				}
				break;
			}
		}

		for (int[] arr : memo.values()) {
			for (int val : arr) {
				if (val == 2) {
					together++;
				}
			}
		}

		return together;
	}
}
