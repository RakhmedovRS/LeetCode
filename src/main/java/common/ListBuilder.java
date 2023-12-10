package common;

/**
 * @author RakhmedovRS
 * @created 26-Jul-20
 */
public class ListBuilder {
	ListNode deserializeList(int[] list) {
		ListNode lastnode = null;
		for (int k = list.length - 1; k >= 0; k--) {
			ListNode node = new ListNode(list[k]);
			node.next = lastnode;
			lastnode = node;
		}
		return lastnode;
	}
}
