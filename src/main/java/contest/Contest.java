package contest;

import common.TreeNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 9/27/2020
 */
public class Contest
{

	public int goodNodes(TreeNode root)
	{
		return dfs(root.val, root);
	}

	private int dfs(int val, TreeNode treeNode)
	{
		if (treeNode == null)
		{
			return 0;
		}

		if (treeNode.left == null && treeNode.right == null)
		{
			return 1;
		}

		return dfs(val, treeNode.left) + dfs(val, treeNode.right) + dfs(treeNode.val, treeNode.left) + + dfs(treeNode.val, treeNode.right);
	}

	public static void main(String[] args) throws Exception
	{
		Contest clazz = new Contest();
	}

	private static String readBigTestCase() throws IOException
	{
		try (BufferedReader br = new BufferedReader(new FileReader(Thread.currentThread().getContextClassLoader().getResource("TestCase.txt").getFile())))
		{
			return br.lines().collect(Collectors.joining());
		}
	}
}
