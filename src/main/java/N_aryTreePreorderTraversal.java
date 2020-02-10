import java.util.LinkedList;
import java.util.List;

/**
 * N-ary Tree Preorder Traversal
 * LeetCode 589
 *
 * @author RakhmedovRS
 * @created 10-Feb-20
 */
public class N_aryTreePreorderTraversal
{
	class Node
	{
		public int val;
		public List<Node> children;

		public Node(){}

		public Node(int val)
		{
			this.val = val;
		}

		public Node(int val, List<Node> children)
		{
			this.val = val;
			this.children = children;
		}
	}

	private void preorder(Node root, List<Integer> result)
	{
		if (root == null)
		{
			return;
		}

		result.add(root.val);
		for (Node node : root.children)
		{
			preorder(node, result);
		}
	}

	public List<Integer> preorder(Node root)
	{
		List<Integer> result = new LinkedList<>();
		preorder(root, result);
		return result;
	}
}
