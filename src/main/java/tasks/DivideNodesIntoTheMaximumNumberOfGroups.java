package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 12/12/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2493,
        name = "Divide Nodes Into the Maximum Number of Groups",
        url = "https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/",
        difficulty = Difficulty.HARD
)
public class DivideNodesIntoTheMaximumNumberOfGroups
{
    class UnionFind
    {
        int[] parents;
        int[] maxes;

        public UnionFind(int n)
        {
            parents = new int[n + 1];
            for (int i = 0; i < n; i++)
            {
                parents[i] = i;
            }

            maxes = new int[n + 1];
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

        public void join(int nodeA, int nodeB)
        {
            int parentA = findParent(nodeA);
            int parentB = findParent(nodeB);
            if (parentA != parentB)
            {
                parents[parentB] = parentA;
            }
        }
    }

    public int magnificentSets(int n, int[][] edges)
    {
        UnionFind uf = new UnionFind(n);

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges)
        {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);

            uf.join(edge[0], edge[1]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> graph.getOrDefault(a, Collections.emptyList()).size()));
        for (int i = 1; i <= n; i++)
        {
            pq.add(i);
        }

        int total = 0;
        while (!pq.isEmpty())
        {
            int start = pq.remove();

            Map<Integer, Integer> groups = new HashMap<>();
            groups.put(start, 1);

            if (dfs(Collections.singletonList(start), graph, groups))
            {
                Set<Integer> set = new HashSet<>(groups.values());
                int parent = uf.findParent(start);
                uf.maxes[parent] = Math.max(uf.maxes[parent], set.size());
            }
            else
            {
                return -1;
            }
        }

        for (int max: uf.maxes)
        {
            total += max;
        }

        return total == 0 ? -1 : total;
    }

    private boolean dfs(List<Integer> starts, Map<Integer, List<Integer>> graph, Map<Integer, Integer> groups)
    {
        if (starts.isEmpty())
        {
            return true;
        }

        List<Integer> nextNodes = new ArrayList<>();
        for (int start: starts)
        {
            for (int next : graph.getOrDefault(start, Collections.emptyList()))
            {
                if (groups.containsKey(next))
                {
                    if (Math.abs(groups.get(start) - groups.get(next)) != 1)
                    {
                        return false;
                    }
                }
                else
                {
                    groups.put(next, groups.get(start) + 1);
                    nextNodes.add(next);
                }
            }
        }

        return dfs(nextNodes, graph, groups);
    }
}
