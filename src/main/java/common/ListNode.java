package common;

/**
 * @author RakhmedovRS
 * @created 07-May-20
 */
public class ListNode
{
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
		return val + (next == null ? "" : next.toString());
	}
}
