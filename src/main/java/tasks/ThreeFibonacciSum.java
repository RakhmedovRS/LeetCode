package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-10-18
 */
@LeetCode(
        id = 4078,
        name = "Three Fibonacci Sum",
        url = "https://leetcode.com/problems/three-fibonacci-sum/description/",
        difficulty = Difficulty.EASY
)
public class ThreeFibonacciSum {
    public boolean threeFibonacciSum(int n) {
        long a = 0;
        long b = 1;
        long c = 1;

        while (a + b + c < n) {
            long temp = c;
            c = b + c;
            a = b;
            b = temp;
        }

        return a + b + c == n;
    }
}