package common;

/**
 * @author RakhmedovRS
 * @created 07-May-20
 */
public class ListNode
{
	public static ListNode createFromArray(int[] array)
	{
		ListNode dummy = new ListNode();
		ListNode current = dummy;
		for (int val : array)
		{
			current.next = new ListNode(val);
			current = current.next;
		}

		return dummy.next;
	}

	public int val;
	public ListNode next;

	public ListNode(){}

	public ListNode(int val){ this.val = val; }

	public ListNode(int val, ListNode next)
	{
		this.val = val;
		this.next = next;
	}

	@Override
	public String toString()
	{
		return val + (next == null ? "" : "->" + next.toString());
	}
}
