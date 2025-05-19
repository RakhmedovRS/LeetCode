package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-05-18
 */
@LeetCode(
        id = 3552,
        name = "Grid Teleportation Traversal",
        url = "https://leetcode.com/problems/grid-teleportation-traversal/description/",
        difficulty = Difficulty.MEDIUM
)
public class GridTeleportationTraversal {
    class Position {
        int row;
        int column;
        int stepsMade;
        boolean[] usedPortals;

        public Position(int row, int column, int stepsMade) {
            this.row = row;
            this.column = column;
            this.stepsMade = stepsMade;
        }

        public Position(int row, int column, int stepsMade, boolean[] usedPortals) {
            this.row = row;
            this.column = column;
            this.stepsMade = stepsMade;
            this.usedPortals = usedPortals;
        }
    }

    public int minMoves(String[] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length();
        char[][] grid = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            grid[row] = matrix[row].toCharArray();
        }

        Map<Character, List<int[]>> portals = new HashMap<>();
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (Character.isAlphabetic(grid[row][column])) {
                    portals.computeIfAbsent(grid[row][column], c -> new ArrayList<>());
                    portals.get(grid[row][column]).add(new int[]{row, column});
                }
            }
        }

        if (grid[0][0] == '#' || grid[rows - 1][columns - 1] == '#') {
            return -1;
        }

        PriorityQueue<Position> positions = new PriorityQueue<>(Comparator.comparingInt(p -> p.stepsMade));
        positions.add(new Position(0, 0, 0));
        int[][] memo = new int[rows][columns];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!positions.isEmpty()) {
            Position position = positions.remove();
            if (memo[position.row][position.column] <= position.stepsMade) {
                continue;
            }

            if (position.row == rows - 1 && position.column == columns - 1) {
                return position.stepsMade;
            }

            memo[position.row][position.column] = position.stepsMade;
            char currentChar = grid[position.row][position.column];
            if (Character.isAlphabetic(currentChar) && (position.usedPortals == null || !position.usedPortals[currentChar - 'A'])) {
                for (int[] portal : portals.getOrDefault(currentChar, Collections.emptyList())) {
                    if (portal[0] == position.row && portal[1] == position.column) {
                        continue;
                    }

                    if (memo[portal[0]][portal[1]] <= position.stepsMade) {
                        continue;
                    }

                    Position nextPosition = new Position(portal[0], portal[1], position.stepsMade, new boolean[26]);
                    nextPosition.usedPortals[currentChar - 'A'] = true;
                    positions.add(nextPosition);
                }
            }

            if (currentChar != '#') {
                for (int[] direction : directions) {
                    int r = position.row + direction[0];
                    int c = position.column + direction[1];

                    if (r >= 0 && r < rows && c >= 0 && c < columns) {
                        Position nextPosition = new Position(r, c, position.stepsMade + 1);
                        if (memo[r][c] <= position.stepsMade + 1) {
                            continue;
                        }
                        positions.add(nextPosition);
                    }
                }
            }
        }

        return memo[rows - 1][columns - 1] == Integer.MAX_VALUE ? -1 : memo[rows - 1][columns - 1];
    }
}