import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12-Jun-20
 */
@LeetCode(id = 641, name = "Design Circular Deque", url = "https://leetcode.com/problems/design-circular-deque/")
public class DesignCircularDeque
{
	class MyCircularDeque
	{
		private class Link
		{
			private Link prev;
			private Link next;
			private int value;

			public Link(int value)
			{
				this.value = value;
			}
		}

		/**
		 * Initialize your data structure here. Set the size of the deque to be k.
		 */
		int capacity;
		int k;
		Link head;
		Link tail;

		public MyCircularDeque(int k)
		{
			this.k = k;
			capacity = k;
			head = new Link(Integer.MIN_VALUE);
			tail = new Link(Integer.MAX_VALUE);
			head.next = tail;
			tail.prev = head;
		}

		/**
		 * Adds an item at the front of Deque. Return true if the operation is successful.
		 */
		public boolean insertFront(int value)
		{
			if (capacity == 0)
			{
				return false;
			}

			Link link = new Link(value);
			head.next.prev = link;
			link.next = head.next;
			head.next = link;
			link.prev = head;

			capacity--;
			return true;
		}

		/**
		 * Adds an item at the rear of Deque. Return true if the operation is successful.
		 */
		public boolean insertLast(int value)
		{
			if (capacity == 0)
			{
				return false;
			}

			Link link = new Link(value);
			tail.prev.next = link;
			link.prev = tail.prev;
			link.next = tail;
			tail.prev = link;

			capacity--;
			return true;
		}

		/**
		 * Deletes an item from the front of Deque. Return true if the operation is successful.
		 */
		public boolean deleteFront()
		{
			if (isEmpty())
			{
				return false;
			}

			head.next.next.prev = head;
			head.next = head.next.next;

			capacity++;
			return true;
		}

		/**
		 * Deletes an item from the rear of Deque. Return true if the operation is successful.
		 */
		public boolean deleteLast()
		{
			if (isEmpty())
			{
				return false;
			}

			tail.prev.prev.next = tail;
			tail.prev = tail.prev.prev;

			capacity++;
			return true;
		}

		/**
		 * Get the front item from the deque.
		 */
		public int getFront()
		{
			if (isEmpty())
			{
				return -1;
			}
			return head.next.value;
		}

		/**
		 * Get the last item from the deque.
		 */
		public int getRear()
		{
			if (isEmpty())
			{
				return -1;
			}
			return tail.prev.value;
		}

		/**
		 * Checks whether the circular deque is empty or not.
		 */
		public boolean isEmpty()
		{
			return capacity == k;
		}

		/**
		 * Checks whether the circular deque is full or not.
		 */
		public boolean isFull()
		{
			return capacity == 0;
		}
	}

	public static void main(String[] args)
	{
		MyCircularDeque circularDeque = new DesignCircularDeque().new MyCircularDeque(8);
		System.out.println(circularDeque.insertFront(5));
		System.out.println(circularDeque.getFront());
		System.out.println(circularDeque.isEmpty());
		System.out.println(circularDeque.deleteFront());
		System.out.println(circularDeque.insertLast(3));
		System.out.println(circularDeque.getRear());
		System.out.println(circularDeque.insertLast(7));
		System.out.println(circularDeque.insertFront(7));
		System.out.println(circularDeque.deleteLast());
		System.out.println(circularDeque.insertLast(4));
		System.out.println(circularDeque.isEmpty());

	}
}
