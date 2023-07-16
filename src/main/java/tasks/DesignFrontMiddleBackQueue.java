package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/28/2020
 */
@LeetCode(
		id = 1670,
		name = "Design Front Middle Back Queue",
		url = "https://leetcode.com/problems/design-front-middle-back-queue/",
		difficulty = Difficulty.MEDIUM
)
public class DesignFrontMiddleBackQueue
{
	class Link
	{
		int value;
		Link prev;
		Link next;

		public Link(int value)
		{
			this.value = value;
		}
	}

	class FrontMiddleBackQueue
	{
		Link front;
		Link back;
		int elements;

		public FrontMiddleBackQueue()
		{
			front = new Link(0);
			back = new Link(0);

			front.next = back;
			back.prev = front;

			elements = 0;
		}

		public void pushFront(int val)
		{
			Link newLink = new Link(val);
			Link next = front.next;

			newLink.next = next;
			next.prev = newLink;

			front.next = newLink;
			newLink.prev = front;

			elements++;
		}

		public void pushMiddle(int val)
		{
			Link current = front;
			for (int i = 0; i < elements / 2; i++)
			{
				current = current.next;
			}

			Link next = current.next;
			Link newLink = new Link(val);

			current.next = newLink;
			newLink.prev = current;

			newLink.next = next;
			next.prev = newLink;
			elements++;
		}

		public void pushBack(int val)
		{
			Link newLink = new Link(val);
			Link prev = back.prev;

			prev.next = newLink;
			newLink.prev = prev;

			newLink.next = back;
			back.prev = newLink;

			elements++;
		}

		public int popFront()
		{
			if (elements == 0)
			{
				return -1;
			}

			Link removed = front.next;

			front.next = removed.next;
			removed.next.prev = front;

			elements--;
			return removed.value;
		}

		public int popMiddle()
		{
			if (elements == 0)
			{
				return -1;
			}
			else if (elements == 1)
			{
				return popFront();
			}

			Link removed = elements % 2 == 0 ? front : front.next;
			for (int i = 0; i < elements / 2; i++)
			{
				removed = removed.next;
			}

			Link prev = removed.prev;
			Link next = removed.next;

			prev.next = next;
			next.prev = prev;

			elements--;

			return removed.value;
		}

		public int popBack()
		{
			if (elements == 0)
			{
				return -1;
			}

			Link removed = back.prev;

			removed.prev.next = back;
			back.prev = removed.prev;

			elements--;
			return removed.value;
		}
	}

	public static void main(String[] args)
	{
		FrontMiddleBackQueue q = new DesignFrontMiddleBackQueue().new FrontMiddleBackQueue();
		q.pushMiddle(1);
		q.pushMiddle(2);
		q.pushMiddle(3);
		System.out.println(q.popMiddle()); //3
		System.out.println(q.popMiddle()); //2
		System.out.println(q.popMiddle()); //1

		System.out.println();

		q = new DesignFrontMiddleBackQueue().new FrontMiddleBackQueue();
		System.out.println(q.popMiddle()); //-1
		System.out.println(q.popMiddle()); //-1
		q.pushMiddle(8);
		System.out.println(q.popBack()); //8
		System.out.println(q.popBack()); //-1
		System.out.println(q.popMiddle()); //-1

		System.out.println();

		q = new DesignFrontMiddleBackQueue().new FrontMiddleBackQueue();
		q.pushFront(1);   // [1]
		q.pushBack(2);    // [1, 2]
		q.pushMiddle(3);  // [1, 3, 2]
		q.pushMiddle(4);  // [1, 4, 3, 2]
		System.out.println(q.popFront()); // return 1 -> [4, 3, 2]
		System.out.println(q.popMiddle()); // return 3 -> [4, 2]
		System.out.println(q.popMiddle()); // return 4 -> [2]
		System.out.println(q.popBack()); // return 2 -> []
		System.out.println(q.popFront()); // return -1 -> [] (The queue is empty)
	}
}
