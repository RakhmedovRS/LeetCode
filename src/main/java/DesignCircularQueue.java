import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/10/2020
 */
@LeetCode(
	id = 622,
	name = "Design Circular Queue",
	url = "https://leetcode.com/problems/design-circular-queue/",
	difficulty = Difficulty.MEDIUM
)
public class DesignCircularQueue
{
	class Node
	{
		Node next;
		Node prev;
		int value;

		public Node(int value)
		{
			this.value = value;
		}
	}

	class MyCircularQueue
	{
		int currentSize;
		int maxSize;
		Node head;
		Node tail;

		public MyCircularQueue(int k)
		{
			currentSize = 0;
			maxSize = k;

			head = new Node(Integer.MIN_VALUE);
			tail = new Node(Integer.MAX_VALUE);

			head.next = tail;
			tail.prev = head;
		}

		public boolean enQueue(int value)
		{
			if (currentSize == maxSize)
			{
				return false;
			}

			Node next = head.next;
			Node node = new Node(value);

			head.next = node;
			node.prev = head;

			node.next = next;
			next.prev = node;

			currentSize++;

			return true;
		}

		public boolean deQueue()
		{
			if (currentSize == 0)
			{
				return false;
			}

			Node prev = tail.prev;
			Node prevPrev = prev.prev;

			tail.prev = prevPrev;
			prevPrev.next = tail;

			currentSize--;

			return true;
		}

		public int Front()
		{
			if (isEmpty())
			{
				return -1;
			}

			return tail.prev.value;
		}

		public int Rear()
		{
			if (isEmpty())
			{
				return -1;
			}

			return head.next.value;
		}

		public boolean isEmpty()
		{
			return currentSize == 0;
		}

		public boolean isFull()
		{
			return currentSize == maxSize;
		}
	}

	public static void main(String[] args)
	{
		MyCircularQueue circularQueue = new DesignCircularQueue().new MyCircularQueue(6);
		System.out.println(circularQueue.enQueue(6));
		System.out.println(circularQueue.Rear());
		System.out.println(circularQueue.Rear());
		System.out.println(circularQueue.deQueue());
		System.out.println(circularQueue.enQueue(5));
		System.out.println(circularQueue.Rear());
		System.out.println(circularQueue.deQueue());
		System.out.println(circularQueue.Front());
	}
}
