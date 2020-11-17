import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 15-Mar-20
 */
@LeetCode(
	id = 234,
	name = "Palindrome Linked List",
	url = "https://leetcode.com/problems/palindrome-linked-list/",
	difficulty = Difficulty.EASY
)
public class PalindromeLinkedList
{
	public boolean isPalindrome(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return true;
		}

		int size = 0;
		ListNode temp = head;
		while (temp != null)
		{
			size++;
			temp = temp.next;
		}

		temp = head;
		ListNode prev = head;
		for (int i = 0; i < size / 2; i++)
		{
			prev = temp;
			temp = temp.next;
		}

		ListNode middle = null;
		ListNode head2;
		if (size % 2 == 0)
		{
			head2 = reverse(temp);
		}
		else
		{
			middle = prev.next;
			head2 = reverse(middle.next);
			middle.next = null;
		}
		prev.next = null;

		ListNode a = head;
		ListNode b = head2;

		while (a != null && b != null)
		{
			if (a.val != b.val)
			{
				break;
			}

			a = a.next;
			b = b.next;
		}

		if (size % 2 == 0)
		{
			prev.next = reverse(head2);
		}
		else
		{
			prev.next = middle;
			middle.next = reverse(head2);
		}

		return a == null && b == null;
	}

	private ListNode reverse(ListNode head)
	{
		ListNode prev = null;
		ListNode next;
		while (head != null)
		{
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}

	public static void main(String[] args)
	{
		ListNode root = new ListNode(1);
		root.next = new ListNode(0);
		root.next.next = new ListNode(1);
		System.out.println(new PalindromeLinkedList().isPalindrome(root));

		root = new ListNode(0);
		root.next = new ListNode(0);
		System.out.println(new PalindromeLinkedList().isPalindrome(root));

		root = new ListNode(0);
		root.next = new ListNode(1);
		root.next.next = new ListNode(1);
		System.out.println(new PalindromeLinkedList().isPalindrome(root));

		root = new ListNode(1);
		root.next = new ListNode(1);
		root.next.next = new ListNode(1);
		root.next.next.next = new ListNode(1);
		System.out.println(new PalindromeLinkedList().isPalindrome(root));
	}
}
