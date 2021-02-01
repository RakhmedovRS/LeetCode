import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 31-Jan-21
 */
@LeetCode(
        id = 1102,
        name = "Path With Maximum Minimum Value",
        url = "https://leetcode.com/problems/path-with-maximum-minimum-value/",
        difficulty = Difficulty.MEDIUM
)
public class PathWithMaximumMinimumValue
{
    class UnionFind
    {
        int[] parents;

        public UnionFind(int n)
        {
            parents = new int[n];
            for (int i = 0; i < n; i++)
            {
                parents[i] = i;
            }
        }

        public int findParent(int node)
        {
            int parent = node;
            while (parent != parents[parent])
            {
                parent = parents[parent];
            }

            int temp;
            while (node != parents[node])
            {
                temp = parents[node];
                parents[node] = parent;
                node = temp;
            }

            return parent;
        }


        public void union(int nodeA, int nodeB)
        {
            int parentA = findParent(nodeA);
            int parentB = findParent(nodeB);

            if (parentA != parentB)
            {
                parents[parentB] = parentA;
            }
        }
    }


    public int maximumMinimumPath(int[][] A)
    {
        int rows = A.length;
        int columns = A[0].length;
        int[][] steps = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        List<int[]> coordinates = new ArrayList<>(rows * columns);
        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column < columns; column++)
            {
                coordinates.add(new int[]{row, column});
            }
        }

        coordinates.sort((a, b) -> A[b[0]][b[1]] - A[a[0]][a[1]]);

        boolean[][] visited = new boolean[rows][columns];
        int row;
        int column;
        int nextRow;
        int nextColumn;
        UnionFind uf = new UnionFind(rows * columns);
        for (int[] coordinate : coordinates)
        {
            row = coordinate[0];
            column = coordinate[1];
            visited[row][column] = true;
            for (int[] step : steps)
            {
                nextRow = row + step[0];
                nextColumn = column + step[1];
                if (nextRow >= 0 && nextRow < rows && nextColumn >= 0 && nextColumn < columns && visited[nextRow][nextColumn])
                {
                    uf.union(row * columns + column, nextRow * columns + nextColumn);
                }

                if (uf.findParent(0) == uf.findParent(rows * columns - 1))
                {
                    return A[row][column];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        PathWithMaximumMinimumValue clazz = new PathWithMaximumMinimumValue();
        System.out.println(clazz.maximumMinimumPath(new int[][]
                {
                        {5, 4, 5},
                        {1, 2, 6},
                        {7, 4, 6}
                }));
    }
}
