package tasks;

import common.Difficulty;
import common.LeetCode;
import common.ListNode;

import java.util.Random;

/**
 * @author RakhmedovRS
 * @created 03-May-20
 */
@LeetCode(
		id = 382,
		name = "Linked List Random Node",
		url = "https://leetcode.com/problems/linked-list-random-node/",
		difficulty = Difficulty.MEDIUM
)
public class LinkedListRandomNode
{
	class Solution
	{
		ListNode head;
		ListNode current;
		int size;
		Random random;

		public Solution(ListNode head)
		{
			this.head = head;
			current = head;
			size = 1;
			while (head.next != null)
			{
				head = head.next;
				size++;
			}

			head.next = this.head;

			random = new Random();
		}

		public int getRandom()
		{
			int pos = random.nextInt(size);
			while (pos-- > 0)
			{
				current = current.next;
			}


			return current.val;
		}
	}

	public static void main(String[] args)
	{
		Solution solution = new LinkedListRandomNode().new Solution(new ListNode(1));

		System.out.println(solution.getRandom());
	}
}
