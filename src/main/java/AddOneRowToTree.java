import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

/**
 * @author RakhmedovRS
 * @created 07-Jul-20
 */
@LeetCode(
        id = 623,
        name = "Add One Row to Tree",
        url = "https://leetcode.com/problems/add-one-row-to-tree/",
        difficulty = Difficulty.MEDIUM
)
public class AddOneRowToTree
{
    public TreeNode addOneRow(TreeNode root, int v, int d)
    {
        return dfs(root, v, d, true);
    }

    private TreeNode dfs(TreeNode node, int v, int d, boolean leftSubTree)
    {
        if (d == 1)
        {
            TreeNode newNode = new TreeNode(v);
            if (leftSubTree)
            {
                newNode.left = node;
            }
            else
            {
                newNode.right = node;
            }

            return newNode;
        }

        if (node == null)
        {
            return null;
        }

        node.left = dfs(node.left, v, d - 1, true);
        node.right = dfs(node.right, v, d - 1, false);
        return node;
    }
}
