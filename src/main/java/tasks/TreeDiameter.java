package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @since 16.03.2021
 */
@LeetCode(
        id  = 1245,
        name = "Tree Diameter",
        url = "https://leetcode.com/problems/tree-diameter/",
        difficulty = Difficulty.MEDIUM,
        premium = true
)
public class TreeDiameter
{
    public int treeDiameter(int[][] edges)
    {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i <= edges.length; i++)
        {
            graph.put(i, new HashSet<>());
        }

        for (int[] edge : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] distance = bfs(0, graph);
        distance = bfs(distance[0], graph);

        return distance[1];
    }

    private int[] bfs(int startNode, Map<Integer, Set<Integer>> graph)
    {
        boolean[] visited = new boolean[graph.size()];
        visited[startNode] = true;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        int lastNode = startNode;
        int distance = -1;
        int nextNode;
        int size;
        while (!queue.isEmpty())
        {
            size = queue.size();
            while (size-- > 0)
            {
                nextNode = queue.removeFirst();
                for (int neighbor : graph.get(nextNode))
                {
                    if (!visited[neighbor])
                    {
                        visited[neighbor] = true;
                        queue.addLast(neighbor);
                        lastNode = neighbor;
                    }
                }
            }

            distance++;
        }

        return new int[]{lastNode, distance};
    }
}
