import common.LeetCode;
import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@LeetCode(id = 382, name = "Linked List Random Node", url = "https://leetcode.com/problems/linked-list-random-node/")
public class LinkedListRandomNode
{
	class Solution
	{
		private ListNode head;
		private Random random;
		private List<ListNode> nodes;

		public Solution(ListNode head)
		{
			this.head = head;
			this.nodes = new ArrayList<>();
			this.random = new Random();

			ListNode listNode = head;
			while (listNode != null)
			{
				nodes.add(listNode);
				listNode = listNode.next;
			}
		}

		public int getRandom()
		{
			if (nodes.size() == 1)
			{
				return nodes.get(0).val;
			}

			return nodes.get(random.nextInt(nodes.size())).val;
		}
	}

	public static void main(String[] args)
	{
		Solution solution = new LinkedListRandomNode().new Solution(new ListNode(1));

		System.out.println(solution.getRandom());
	}
}
