package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 10/2/2022
 * @$
 * @$
 */
@LeetCode(
        id = 2424,
        name = "Longest Uploaded Prefix",
        url = "https://leetcode.com/problems/longest-uploaded-prefix/",
        difficulty = Difficulty.MEDIUM
)
public class LongestUploadedPrefix
{
    class LUPrefix
    {
        class UnionFind
        {
            private final int[] parent;
            public final int[] rank;

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

                if (rank[rootA] < rank[rootB] || rootB == 1)
                {
                    rank[rootB] += rank[rootA];
                    parent[rootA] = rootB;
                }
                else
                {
                    rank[rootA] += rank[rootB];
                    parent[rootB] = rootA;
                }
            }
        }

        UnionFind unionFind;
        boolean[] seen;

        public LUPrefix(int n)
        {
            unionFind = new UnionFind(n + 1);
            seen = new boolean[n + 1];
        }

        public void upload(int video)
        {
            seen[video] = true;
            if (video > 0 && seen[video - 1])
            {
                unionFind.unify(video - 1, video);
            }

            if (video + 1 < seen.length && seen[video + 1])
            {
                unionFind.unify(video + 1, video);
            }
        }

        public int longest()
        {
            if (seen[1])
            {
                return unionFind.rank[1];
            }
            else
            {
                return 0;
            }
        }
    }
}
