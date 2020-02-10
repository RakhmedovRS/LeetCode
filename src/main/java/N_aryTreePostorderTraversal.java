import java.util.LinkedList;
import java.util.List;

/**
 * N-ary Tree Postorder Traversal
 * LeetCode 589
 *
 * @author RakhmedovRS
 * @created 10-Feb-20
 */
public class N_aryTreePostorderTraversal
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

	private void postorder(Node root, List<Integer> result)
	{
		if (root == null)
		{
			return;
		}

		for (Node node : root.children)
		{
			postorder(node, result);
		}
		result.add(root.val);
	}

	public List<Integer> postorder(Node root)
	{
		List<Integer> result = new LinkedList<>();
		postorder(root, result);
		return result;
	}
}
