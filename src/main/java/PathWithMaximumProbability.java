import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12-Jul-20
 */
@LeetCode(id = 1514, name = "Path with Maximum Probability", url = "https://leetcode.com/problems/path-with-maximum-probability/")
public class PathWithMaximumProbability
{
	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end)
	{
		Map<Integer, List<double[]>> graph = new HashMap<>();
		Comparator<double[]> comparator = (arr1, arr2) -> Double.compare(arr2[0], arr1[0]);
		for (int i = 0; i < edges.length; i++)
		{
			List<double[]> list = graph.getOrDefault(edges[i][0], new ArrayList<>());
			list.add(new double[]{succProb[i], edges[i][1]});
			graph.put(edges[i][0], list);

			list = graph.getOrDefault(edges[i][1], new ArrayList<>());
			list.add(new double[]{succProb[i], edges[i][0]});
			graph.put(edges[i][1], list);
		}
		if (!graph.containsKey(start) || !graph.containsKey(end))
		{
			return 0;
		}

		PriorityQueue<double[]> pq = new PriorityQueue<>(comparator);
		pq.add(new double[]{1, start});
		double[] prob = new double[n];
		while (!pq.isEmpty())
		{
			double[] edge = pq.remove();

			List<double[]> list = graph.remove((int) edge[1]);
			list = list == null ? Collections.emptyList() : list;
			for (double[] next : list)
			{
				int pos = (int) next[1];
				if (next[0] * edge[0] > prob[pos])
				{
					next[0] *= edge[0];
					prob[pos] = next[0];
					pq.add(next);
				}
			}
		}

		return prob[end];
	}
}
