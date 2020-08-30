import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

@LeetCode(id = 952, name = "Largest Component Size by Common Factor", url = "https://leetcode.com/problems/largest-component-size-by-common-factor/")
public class LargestComponentSizeByCommonFactor
{
    class UnionFind
    {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int size)
        {
            this.parent = new int[size];
            this.rank = new int[size];

            for (int i = 0; i < size; i++)
            {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int findParent(int node)
        {
            int root = node;
            while (root != parent[root])
            {
                root = parent[root];
            }

            while (node != parent[node])
            {
                int next = parent[node];
                parent[node] = root;
                node = next;
            }

            return root;
        }

        private void unify(int nodeA, int nodeB)
        {
            int rootA = findParent(nodeA);
            int rootB = findParent(nodeB);
            if (rootA == rootB)
            {
                return;
            }

            if (rank[rootA] < rank[rootB])
            {
                rank[nodeB] += rank[rootA];
                parent[rootA] = rootB;
            }
            else
            {
                rank[rootA] += rank[rootB];
                parent[rootB] = rootA;
            }
        }
    }

    public int largestComponentSize(int[] nums)
    {
        int maxNumber = 0;
        for (int num : nums)
        {
            maxNumber = Math.max(maxNumber, num);
        }

        UnionFind unionFind = new UnionFind(maxNumber + 1);
        for (int num : nums)
        {
            for (int factor = 2; factor * factor <= num; factor++)
            {
                if (num % factor == 0)
                {
                    unionFind.unify(num, factor);
                    unionFind.unify(num, num / factor);
                }
            }
        }

        int max = 1;
        Map<Integer, Integer> parents = new HashMap<>();
        int parent;
        for (int num : nums)
        {
            parent = unionFind.findParent(num);
            parents.put(parent, parents.getOrDefault(parent, 0) + 1);
            max = Math.max(max, parents.get(parent));
        }

        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(new LargestComponentSizeByCommonFactor().largestComponentSize(new int[]{2, 3, 6, 7, 4, 12, 21, 39}));
    }
}
