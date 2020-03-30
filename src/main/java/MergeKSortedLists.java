import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11-Feb-20
 */
@LeetCode(id = 23, name = "Merge k Sorted Lists", url = "https://leetcode.com/problems/merge-k-sorted-lists/")
public class MergeKSortedLists
{
	public class ListNode
	{
		int val;
		ListNode next;

		ListNode(int x){ val = x; }
	}

	class BinaryHeap
	{
		ListNode[] heapArray;
		int elementsNumber;

		public BinaryHeap(int size)
		{
			this.heapArray = new ListNode[size];
		}

		public void insert(ListNode newNode)
		{
			if (elementsNumber + 1 == heapArray.length)
			{
				ListNode[] temp = new ListNode[heapArray.length * 2];
				System.arraycopy(heapArray, 0, temp, 0, heapArray.length);
				heapArray = temp;
			}

			heapArray[elementsNumber++] = newNode;
			restoreHeap(false);
		}

		public ListNode remove()
		{
			if (!isEmpty())
			{
				ListNode topNode = heapArray[0];
				heapArray[0] = heapArray[--elementsNumber];
				restoreHeap(true);
				return topNode;
			}
			return null;
		}

		public boolean isEmpty()
		{
			return elementsNumber == 0;
		}

		private void restoreHeap(boolean pushDown)
		{
			if (pushDown)
			{
				int child;
				int currentPosition = 0;
				while (currentPosition != elementsNumber - 1)
				{
					int leftChild = currentPosition * 2 + 1;
					int rightChild = currentPosition * 2 + 2;
					if (leftChild >= 0 && leftChild <= elementsNumber && rightChild >= 0 && rightChild <= elementsNumber)
					{
						child = heapArray[leftChild].val < heapArray[rightChild].val ? leftChild : rightChild;
					}
					else if (leftChild >= 0 && leftChild <= elementsNumber)
					{
						child = leftChild;
					}
					else
					{
						break;
					}

					if (heapArray[currentPosition].val > heapArray[child].val)
					{
						swap(currentPosition, child);
						currentPosition = child;
					}
					else
					{
						break;
					}
				}
			}
			else
			{
				int parent;
				int currentPosition = elementsNumber - 1;
				while (currentPosition != 0)
				{
					parent = currentPosition % 2 == 0 ? currentPosition / 2 - 1 : currentPosition / 2;
					if (heapArray[parent].val > heapArray[currentPosition].val)
					{
						swap(parent, currentPosition);
						currentPosition = parent;
					}
					else
					{
						break;
					}
				}
			}
		}

		private void swap(int first, int second)
		{
			ListNode temp = heapArray[first];
			heapArray[first] = heapArray[second];
			heapArray[second] = temp;
		}
	}

	public ListNode mergeKLists(ListNode[] lists)
	{
		if (lists == null)
		{
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode current;
		BinaryHeap heap = new BinaryHeap(lists.length);
		for (ListNode node : lists)
		{
			if (node != null)
			{
				heap.insert(node);
			}
		}

		ListNode prev = dummy;
		while (!heap.isEmpty())
		{
			current = heap.remove();
			prev.next = current;
			if (current.next != null)
			{
				heap.insert(current.next);
			}
			prev = prev.next;
		}

		return dummy.next;
	}
}
