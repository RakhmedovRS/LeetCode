package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 20-May-20
 */
@LeetCode(id = 1025, name = "Divisor Game", url = "https://leetcode.com/problems/divisor-game/")
public class DivisorGame {
	public boolean divisorGame(int N) {
		return N % 2 == 0;
	}
}
