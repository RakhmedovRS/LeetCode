import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Feb-21
 */
@LeetCode(
        id = 426,
        name = "Convert Binary Search Tree to Sorted Doubly Linked List",
        url = "https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/",
        difficulty = Difficulty.MEDIUM,
        premium = true
)
public class ConvertBinarySearchTreeToSortedDoublyLinkedList
{
    class Node
    {
        public int val;
        public Node left;
        public Node right;

        public Node()
        {
        }

        public Node(int _val)
        {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right)
        {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root)
    {
        if (root == null)
        {
            return null;
        }

        Node head = new Node();
        Node tail = new Node();

        head.right = tail;
        tail.left = head;

        inorder(root, new Node[]{head});

        Node realHead = head.right;
        Node realTail = tail.left;

        realHead.left = realTail;
        realTail.right = realHead;

        return realHead;
    }

    private void inorder(Node node, Node[] prev)
    {
        if (node == null)
        {
            return;
        }

        Node left = node.left;
        Node right = node.right;

        inorder(left, prev);

        Node previous = prev[0];
        Node next = prev[0].right;

        previous.right = node;
        node.left = previous;
        node.right = next;
        next.left = node;

        prev[0] = node;

        inorder(right, prev);
    }
}
