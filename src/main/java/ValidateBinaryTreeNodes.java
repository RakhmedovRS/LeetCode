import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 19-Jul-20
 */
@LeetCode(id = 1361, name = "Validate Binary Tree Nodes", url = "https://leetcode.com/problems/validate-binary-tree-nodes/")
public class ValidateBinaryTreeNodes
{
	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild)
	{
		Set<Integer> connected = new HashSet<>();
		for (int i = 0; i < n; i++)
		{
			if (leftChild[i] != -1)
			{
				if (!connected.add(leftChild[i]))
				{
					return false;
				}
			}
			if (rightChild[i] != -1)
			{
				if (!connected.add(rightChild[i]))
				{
					return false;
				}
			}
			if (leftChild[i] == -1 && rightChild[i] == -1 && !connected.isEmpty() && !connected.contains(i))
			{
				return false;
			}
		}
		return connected.size() == n - 1;
	}
}
