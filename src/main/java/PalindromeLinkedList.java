import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 15-Mar-20
 */
@LeetCode(id = 234, name = "Palindrome Linked List", url = "https://leetcode.com/problems/palindrome-linked-list/")
public class PalindromeLinkedList
{
	public boolean isPalindrome(ListNode head)
	{
		if (head == null || head.next == null)
		{
			return true;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		int count = 0;
		while (head != null)
		{
			head = head.next;
			count++;
		}

		if (count == 2)
		{
			return dummy.next.val == dummy.next.next.val;
		}

		head = dummy.next;
		ListNode slow = head;
		ListNode fast = head.next.next;
		while (fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode secondHead;
		if (count % 2 != 0)
		{
			secondHead = reverseList(slow.next.next);
			slow.next = null;
		}
		else
		{
			secondHead = reverseList(slow.next);
			slow.next = null;
		}

		while (true)
		{
			if (head == null && secondHead == null)
			{
				break;
			}

			if (head == null || secondHead == null)
			{
				return false;
			}

			if (head.val != secondHead.val)
			{
				return false;
			}

			head = head.next;
			secondHead = secondHead.next;
		}

		return true;
	}

	private ListNode reverseList(ListNode current)
	{
		ListNode prev = null;
		ListNode next;
		while (current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
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
