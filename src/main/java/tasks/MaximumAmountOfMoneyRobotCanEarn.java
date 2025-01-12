package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-01-11
 */
@LeetCode(
        id = 3418,
        name = "Maximum Amount of Money Robot Can Earn",
        url = "https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumAmountOfMoneyRobotCanEarn {
    public int maximumAmount(int[][] coins) {
        int rows = coins.length;
        int columns = coins[0].length;
        Integer[][][] memo = new Integer[3][rows][columns];
        for (int skip = 0; skip < 3; skip++) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    if (skip == 0) {
                        if (coins[row][col] < 0) {
                            if (row == 0 && col == 0) {
                                memo[skip + 1][row][col] = 0;
                            }

                            Integer left = col - 1 >= 0 ? memo[skip][row][col - 1] : null;
                            Integer up = row - 1 >= 0 ? memo[skip][row - 1][col] : null;
                            if (left != null) {
                                if (memo[skip + 1][row][col] != null) {
                                    memo[skip + 1][row][col] = Math.max(memo[skip + 1][row][col], left);
                                } else {
                                    memo[skip + 1][row][col] = left;
                                }
                            }

                            if (up != null) {
                                if (memo[skip + 1][row][col] != null) {
                                    memo[skip + 1][row][col] = Math.max(memo[skip + 1][row][col], up);
                                } else {
                                    memo[skip + 1][row][col] = up;
                                }
                            }

                            int max = coins[row][col];
                            if (col - 1 >= 0 && row - 1 >= 0) {
                                max = coins[row][col] + Math.max(memo[skip][row][col - 1], memo[skip][row - 1][col]);
                            } else if (row - 1 >= 0) {
                                max = coins[row][col] + memo[skip][row - 1][col];
                            } else if (col - 1 >= 0) {
                                max = coins[row][col] + memo[skip][row][col - 1];
                            }

                            memo[skip][row][col] = max;
                        } else {
                            int max = coins[row][col];
                            if (col - 1 >= 0 && row - 1 >= 0) {
                                max = coins[row][col] + Math.max(memo[skip][row][col - 1], memo[skip][row - 1][col]);
                            } else if (row - 1 >= 0) {
                                max = coins[row][col] + memo[skip][row - 1][col];
                            } else if (col - 1 >= 0) {
                                max = coins[row][col] + memo[skip][row][col - 1];
                            }

                            memo[skip][row][col] = max;
                        }
                    } else {
                        if ((col - 1 < 0 || memo[skip][row][col - 1] == null)
                                && (row - 1 < 0 || memo[skip][row - 1][col] == null)) {
                            continue;
                        }

                        if (coins[row][col] < 0) {
                            if (skip + 1 < 3) {
                                Integer left = col - 1 >= 0 ? memo[skip][row][col - 1] : null;
                                Integer up = row - 1 >= 0 ? memo[skip][row - 1][col] : null;
                                if (left != null) {
                                    if (memo[skip + 1][row][col] != null) {
                                        memo[skip + 1][row][col] = Math.max(memo[skip + 1][row][col], left);
                                    } else {
                                        memo[skip + 1][row][col] = left;
                                    }
                                }

                                if (up != null) {
                                    if (memo[skip + 1][row][col] != null) {
                                        memo[skip + 1][row][col] = Math.max(memo[skip + 1][row][col], up);
                                    } else {
                                        memo[skip + 1][row][col] = up;
                                    }
                                }
                            }

                            int max = Integer.MIN_VALUE;
                            if (col - 1 >= 0 && memo[skip][row][col - 1] != null && row - 1 >= 0 && memo[skip][row - 1][col] != null) {
                                max = coins[row][col] + Math.max(memo[skip][row - 1][col], memo[skip][row][col - 1]);
                            } else if (col - 1 >= 0 && memo[skip][row][col - 1] != null) {
                                max = Math.max(max, coins[row][col] + memo[skip][row][col - 1]);
                            } else if (row - 1 >= 0 && memo[skip][row - 1][col] != null) {
                                max = Math.max(max, coins[row][col] + memo[skip][row - 1][col]);
                            }

                            if (memo[skip][row][col] == null) {
                                memo[skip][row][col] = (max == Integer.MIN_VALUE ? null : max);
                            } else {
                                memo[skip][row][col] = Math.max(memo[skip][row][col], (max == Integer.MIN_VALUE ? null : max));
                            }
                        } else {
                            int max = Integer.MIN_VALUE;
                            if (col - 1 >= 0 && memo[skip][row][col - 1] != null && row - 1 >= 0 && memo[skip][row - 1][col] != null) {
                                max = coins[row][col] + Math.max(memo[skip][row - 1][col], memo[skip][row][col - 1]);
                            } else if (col - 1 >= 0 && memo[skip][row][col - 1] != null) {
                                max = Math.max(max, coins[row][col] + memo[skip][row][col - 1]);
                            } else if (row - 1 >= 0 && memo[skip][row - 1][col] != null) {
                                max = Math.max(max, coins[row][col] + memo[skip][row - 1][col]);
                            }

                            if (memo[skip][row][col] == null) {
                                memo[skip][row][col] = (max == Integer.MIN_VALUE ? null : max);
                            } else {
                                memo[skip][row][col] = Math.max(memo[skip][row][col], (max == Integer.MIN_VALUE ? null : max));
                            }
                        }
                    }
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int skip = 0; skip < 3; skip++) {
            if (memo[skip][rows - 1][columns - 1] != null) {
                ans = Math.max(ans, memo[skip][rows - 1][columns - 1]);
            }
        }

        return ans;
    }
}