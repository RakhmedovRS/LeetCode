package tasks;

import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 9/24/2022
 */
@LeetCode(
        id = 2415,
        name = "Reverse Odd Levels of Binary Tree",
        url = "https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/",
        difficulty = Difficulty.MEDIUM
)
public class ReverseOddLevelsOfBinaryTree
{
    public TreeNode reverseOddLevels(TreeNode root)
    {
        List<List<TreeNode>> levels = new ArrayList<>();
        dfs(0, root, levels);
        for (int i = 0; i < levels.size(); i++)
        {
            if (i % 2 == 1)
            {
                Collections.reverse(levels.get(i));
            }
        }

        for (int i = 0; i < levels.size() - 1; i++)
        {
            for (int j = 0; j < levels.get(i).size(); j++)
            {
                levels.get(i).get(j).left = levels.get(i + 1).get(j * 2);
                levels.get(i).get(j).right = levels.get(i + 1).get(j * 2 + 1);
            }
        }

        return levels.get(0).get(0);
    }


    private void dfs(int level, TreeNode root, List<List<TreeNode>> levels)
    {
        if (root == null)
        {
            return;
        }

        if (level >= levels.size())
        {
            levels.add(new LinkedList<>());
        }

        levels.get(level).add(root);
        dfs(level + 1, root.left, levels);
        dfs(level + 1, root.right, levels);
    }
}
