package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 9/1/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
        id = 2385,
        name = "Amount of Time for Binary Tree to Be Infected",
        url = "https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/",
        difficulty = Difficulty.MEDIUM
)
public class AmountOfTimeForBinaryTreeToBeInfected
{
    public int amountOfTime(TreeNode root, int start)
    {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode[] infected = new TreeNode[1];
        dfs(null, root, parents, infected, start);

        int time = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(infected[0]);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(infected[0]);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            while (size-- > 0)
            {
                TreeNode current = queue.remove();

                if (parents.containsKey(current) && parents.get(current) != null && visited.add(parents.get(current)))
                {
                    queue.add(parents.get(current));
                }

                if (current.left != null && visited.add(current.left))
                {
                    queue.add(current.left);
                }

                if (current.right != null && visited.add(current.right))
                {
                    queue.add(current.right);
                }
            }

            if (!queue.isEmpty())
            {
                time++;
            }
        }


        return time;
    }

    private void dfs(TreeNode parent, TreeNode node, Map<TreeNode, TreeNode> parents, TreeNode[] infected, int value)
    {
        if (node == null)
        {
            return;
        }

        if (node.val == value)
        {
            infected[0] = node;
        }

        parents.put(node, parent);
        dfs(node, node.left, parents, infected, value);
        dfs(node, node.right, parents, infected, value);
    }
}
