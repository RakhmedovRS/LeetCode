import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 18.02.2021
 */
@LeetCode(
        id = 1466,
        name = "Reorder Routes to Make All Paths Lead to the City Zero",
        url = "https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/",
        difficulty = Difficulty.MEDIUM
)
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero
{
    public int minReorder(int n, int[][] connections)
    {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Set<Integer>> conn = new HashMap<>();
        int a;
        int b;
        for (int[] connection : connections)
        {
            a = connection[0];
            b = connection[1];

            conn.putIfAbsent(a, new HashSet<>());
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(b);
            graph.get(b).add(a);
            conn.get(a).add(b);
        }

        return dfs(0, graph, conn, new boolean[n]);
    }

    private int dfs(int node, Map<Integer, List<Integer>> graph, Map<Integer, Set<Integer>> conn, boolean[] visited)
    {
        visited[node] = true;
        int result = 0;
        for (int neighbor : graph.getOrDefault(node, Collections.emptyList()))
        {
            if (!visited[neighbor])
            {
                if (conn.getOrDefault(node, Collections.emptySet()).contains(neighbor))
                {
                    result++;
                }
                result += dfs(neighbor, graph, conn, visited);
            }
        }

        return result;
    }
}
