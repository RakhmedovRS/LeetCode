import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * N-ary Tree Level Order Traversal
 * LeetCode 429
 *
 * @author RakhmedovRS
 * @created 09-Mar-20
 */
public class NaryTreeLevelOrderTraversal
{
	static class Node
	{
		public int val;
		public List<Node> children;

		public Node(){}

		public Node(int val)
		{
			this.val = val;
			this.children = new ArrayList<>();
		}

		public Node(int val, List<Node> children)
		{
			this.val = val;
			this.children = children;
		}
	}

	public List<List<Integer>> levelOrder(Node root)
	{
		if (root == null)
		{
			return new ArrayList<>();
		}

		List<List<Integer>> result = new LinkedList<>();
		LinkedList<Node> tempo = new LinkedList<>();
		tempo.addLast(root);
		int currentLevelSize;
		List<Integer> currentLevelNodes;
		while (!tempo.isEmpty())
		{
			currentLevelSize = tempo.size();
			currentLevelNodes = new LinkedList<>();
			while (currentLevelSize > 0)
			{
				Node node = tempo.removeFirst();
				for (Node successor : node.children)
				{
					if (successor != null)
					{
						tempo.addLast(successor);
					}
				}
				currentLevelNodes.add(node.val);
				currentLevelSize--;
			}
			result.add(currentLevelNodes);
		}

		return result;
	}

	public static void main(String[] args)
	{
		Node child = new Node(3, Arrays.asList(new Node(5), new Node(6)));
		Node root = new Node(1, Arrays.asList(child, new Node(2), new Node(4)));
		new NaryTreeLevelOrderTraversal().levelOrder(root);
	}
}
