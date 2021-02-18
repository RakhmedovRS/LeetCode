import common.Difficulty;
import common.LeetCode;
import common.ListNode;

/**
 * @author RakhmedovRS
 * @created 15-Mar-20
 */
@LeetCode(
        id = 141,
        name = "Linked List Cycle",
        url = "https://leetcode.com/problems/linked-list-cycle/",
        difficulty = Difficulty.EASY)
public class LinkedListCycle
{
    public boolean hasCycle(ListNode head)
    {
        if (head == null || head.next == null || head.next.next == null)
        {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null)
        {
            if (fast.next == null || fast.next.next == null)
            {
                break;
            }

            if (slow == fast)
            {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
