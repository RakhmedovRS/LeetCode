package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-10-26
 */
@LeetCode(
        id = 3332,
        name = "Maximum Points Tourist Can Earn",
        url = "https://leetcode.com/problems/maximum-points-tourist-can-earn/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumPointsTouristCanEarn {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        LinkedList<int[]> list = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            list.add(new int[]{0, i, 0});
        }

        int[][] memo = new int[n + 2][k + 2];
        for (int[] arr : memo) {
            Arrays.fill(arr, 0);
        }

        while (!list.isEmpty()) {
            int[] curr = list.removeFirst();
            int day = curr[0];
            int currentCity = curr[1];
            int score = curr[2];

            if (day == k) {
                continue;
            }

            int scoreIfStay = score + stayScore[day][currentCity];
            if (memo[currentCity][day] >= scoreIfStay) {
                continue;
            }

            memo[currentCity][day] = scoreIfStay;

            max = Math.max(max, scoreIfStay);
            list.addLast(new int[]{day + 1, currentCity, scoreIfStay});

            for (int nextCity = 0; nextCity < n; nextCity++) {
                if (nextCity != currentCity) {
                    int scoreIfTravel = score + travelScore[currentCity][nextCity];
                    if (memo[nextCity][day + 1] >= scoreIfTravel) {
                        continue;
                    }
                    memo[nextCity][day + 1] = scoreIfTravel;
                    max = Math.max(max, scoreIfTravel);
                    list.addLast(new int[]{day + 1, nextCity, scoreIfTravel});
                }
            }
        }

        return max;
    }
}