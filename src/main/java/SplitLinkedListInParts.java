import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 22-Apr-20
 */
@LeetCode(id = 725, name = "Split Linked List in Parts", url = "https://leetcode.com/problems/split-linked-list-in-parts/")
public class SplitLinkedListInParts
{
	public ListNode[] splitListToParts(ListNode root, int k)
	{
		if (k == 1)
		{
			return new ListNode[]{root};
		}

		ListNode curr = root;
		int nodeCount = 0;
		while (curr != null)
		{
			curr = curr.next;
			nodeCount++;
		}

		ListNode[] roots = new ListNode[k];
		if (nodeCount < k)
		{
			ListNode prev = root;
			for (int i = 0; i < k; i++)
			{
				roots[i] = prev;
				if (prev != null)
				{
					prev = prev.next;
					roots[i].next = null;
				}
			}
		}
		else
		{
			int add = nodeCount % k;
			int normal = nodeCount / k;
			ListNode prev = root;
			for (int i = 0; i < k; i++)
			{
				roots[i] = prev;
				int count = 1;
				while (count++ < normal)
				{
					prev = prev.next;
				}
				if (add > 0)
				{
					add--;
					prev = prev.next;
				}
				ListNode temp = prev;
				prev = prev.next;
				temp.next = null;
			}
		}

		return roots;
	}

	public static void main(String[] args)
	{
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		root.next.next.next.next.next = new ListNode(6);
		root.next.next.next.next.next.next = new ListNode(7);
		root.next.next.next.next.next.next.next = new ListNode(8);

		ListNode[] nodes = new SplitLinkedListInParts().splitListToParts(root, 7);
	}
}
