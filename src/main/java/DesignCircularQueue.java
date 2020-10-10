import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/10/2020
 */
@LeetCode(id = 622, name = "Design Circular Queue", url = "https://leetcode.com/problems/design-circular-queue/")
public class DesignCircularQueue
{
	class Node
	{
		Node prev;
		Node next;
		int val;

		public Node(int val)
		{
			this.val = val;
		}
	}

	class MyCircularQueue
	{
		int size;
		int maxSize;
		Node head;
		Node tail;

		public MyCircularQueue(int k)
		{
			size = 0;
			maxSize = k;
			head = new Node(Integer.MIN_VALUE);
			tail = new Node(Integer.MAX_VALUE);

			head.next = tail;
			head.prev = tail;
			tail.next = head;
			tail.prev = head;
		}

		/**
		 * Insert an element into the circular queue. Return true if the operation is successful.
		 */
		public boolean enQueue(int value)
		{
			if (size < maxSize)
			{
				Node prev = tail.prev;
				Node newNode = new Node(value);
				newNode.next = tail;
				tail.prev = newNode;
				prev.next = newNode;
				newNode.prev = prev;
				size++;
				return true;
			}
			return false;
		}

		/**
		 * Delete an element from the circular queue. Return true if the operation is successful.
		 */
		public boolean deQueue()
		{
			if (size == 0)
			{
				return false;
			}

			head.next = head.next.next;
			head.next.prev = head;

			size--;
			return true;
		}

		/**
		 * Get the front item from the queue.
		 */
		public int Front()
		{
			if (size == 0)
			{
				return -1;
			}
			return head.next.val;
		}

		/**
		 * Get the last item from the queue.
		 */
		public int Rear()
		{
			if (size == 0)
			{
				return -1;
			}
			return tail.prev.val;
		}

		/**
		 * Checks whether the circular queue is empty or not.
		 */
		public boolean isEmpty()
		{
			return size == 0;
		}

		/**
		 * Checks whether the circular queue is full or not.
		 */
		public boolean isFull()
		{
			return size == maxSize;
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
