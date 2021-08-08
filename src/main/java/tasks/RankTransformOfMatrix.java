package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 8/8/2021
 */
@LeetCode(
	id = 1632,
	name = "Rank Transform of a Matrix",
	url = "https://leetcode.com/problems/rank-transform-of-a-matrix/",
	difficulty = Difficulty.HARD
)
public class RankTransformOfMatrix
{
	class UF
	{
		int[] parents;

		public UF(int nodes)
		{
			parents = new int[nodes];
			for (int i = 0; i < parents.length; i++)
			{
				parents[i] = i;
			}
		}

		public int findParent(int node)
		{
			int parent = node;

			while (parents[parent] != parent)
			{
				parent = parents[parent];
			}

			int temp;
			while (parents[node] != node)
			{
				temp = parents[node];
				parents[node] = parent;
				node = temp;
			}

			return parent;
		}

		private void join(int nodeA, int nodeB)
		{
			int parentA = findParent(nodeA);
			int parentB = findParent(nodeB);
			parents[parentB] = parentA;
		}
	}

	public int[][] matrixRankTransform(int[][] matrix)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] answer = new int[rows][columns];
		TreeMap<Integer, List<int[]>> map = new TreeMap<>();
		for (int row = 0; row < rows; row++)
		{
			for (int column = 0; column < columns; column++)
			{
				map.putIfAbsent(matrix[row][column], new ArrayList<>());
				map.get(matrix[row][column]).add(new int[]{row, column});
			}
		}

		int[] minX = new int[rows];
		int[] minY = new int[columns];
		for (Map.Entry<Integer, List<int[]>> entry : map.entrySet())
		{
			List<int[]> coordinates = entry.getValue();
			UF uf = new UF(coordinates.size());

			Map<Integer, List<Integer>> xMap = new HashMap<>();
			Map<Integer, List<Integer>> yMap = new HashMap<>();
			for (int i = 0; i < coordinates.size(); i++)
			{
				int[] xy = coordinates.get(i);
				int x = xy[0];
				int y = xy[1];

				xMap.putIfAbsent(x, new ArrayList<>());
				yMap.putIfAbsent(y, new ArrayList<>());

				xMap.get(x).add(i);
				yMap.get(y).add(i);
			}

			// union by X
			for (Integer xKey : xMap.keySet())
			{
				List<Integer> xList = xMap.get(xKey);
				for (int i = 1; i < xList.size(); i++)
				{
					uf.join(xList.get(i - 1), xList.get(i));
				}
			}

			// union by Y
			for (Integer yKey : yMap.keySet())
			{
				List<Integer> yList = yMap.get(yKey);
				for (int i = 1; i < yList.size(); i++)
				{
					uf.join(yList.get(i - 1), yList.get(i));
				}
			}

			Map<Integer, List<int[]>> group = new HashMap<>();
			for (int i = 0; i < coordinates.size(); i++)
			{
				int grp = uf.findParent(i);
				group.putIfAbsent(grp, new ArrayList<>());
				group.get(grp).add(coordinates.get(i));
			}

			// SET ANSWER FOR EACH GROUP
			for (Integer grpKey : group.keySet())
			{
				int max = 1;
				List<int[]> sublist = group.get(grpKey);

				// FIND MAX-RANK FOR THIS GROUP
				for (int[] xy : sublist)
				{
					int x = xy[0];
					int y = xy[1];

					max = Math.max(max, Math.max(minX[x], minY[y]));
				}

				// UPDATE ANSWER = MAX-RANK AND SET NEW MIN-RANK FOR ROW/COL = MAX-RANK+1
				for (int[] xy : sublist)
				{
					int x = xy[0];
					int y = xy[1];
					answer[x][y] = max;
					minX[x] = max + 1;
					minY[y] = max + 1;
				}
			}
		}

		return answer;
	}
}
