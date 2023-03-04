package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 11/24/2022
 */
@LeetCode(
        id = 2476,
        name = "Closest Nodes Queries in a Binary Search Tree",
        url = "https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/",
        difficulty = Difficulty.MEDIUM
)
public class ClosestNodesQueriesInBinarySearchTree
{
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries)
    {
        TreeSet<Integer> ints = new TreeSet<>();
        dfs(root, ints);

        List<List<Integer>> answer = new ArrayList<>();
        for (int q : queries)
        {
            Integer left = ints.floor(q);
            Integer right = ints.ceiling(q);

            answer.add(Arrays.asList((left == null ? -1 : left), (right == null ? -1 : right)));
        }

        return answer;
    }

    private void dfs(TreeNode root, TreeSet<Integer> ints)
    {
        if (root == null)
        {
            return;
        }

        ints.add(root.val);
        dfs(root.left, ints);
        dfs(root.right, ints);
    }
}
