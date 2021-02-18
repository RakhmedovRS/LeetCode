import common.Difficulty;
import common.LeetCode;
import common.TreeNode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 01-Feb-21
 */
@LeetCode(
        id = 431,
        name = "Encode N-ary Tree to Binary Tree",
        url = "https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/",
        difficulty = Difficulty.HARD
)
public class EncodeNaryTreeToBinaryTree
{
    class Node
    {
        public int val;
        public List<Node> children;

        public Node()
        {
        }

        public Node(int _val)
        {
            val = _val;
        }

        public Node(int _val, List<Node> _children)
        {
            val = _val;
            children = _children;
        }
    }

    class Codec
    {
        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root)
        {
            return encode(root, true);
        }

        private TreeNode encode(Node node, boolean rightChild)
        {
            if (node == null)
            {
                return null;
            }

            TreeNode treeNode = new TreeNode(node.val);
            TreeNode current = treeNode;
            if (rightChild)
            {
                for (Node child : node.children)
                {
                    current.right = encode(child, false);
                    current = current.right;
                }
            }
            else
            {
                for (Node child : node.children)
                {
                    current.left = encode(child, true);
                    current = current.left;
                }
            }

            return treeNode;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root)
        {
            return decode(root, true);
        }

        private Node decode(TreeNode treeNode, boolean rightChild)
        {
            if (treeNode == null)
            {
                return null;
            }

            Node node = new Node(treeNode.val, new ArrayList<>());
            if (rightChild)
            {
                while (treeNode.right != null)
                {
                    treeNode = treeNode.right;
                    node.children.add(decode(treeNode, false));
                }
            }
            else
            {
                while (treeNode.left != null)
                {
                    treeNode = treeNode.left;
                    node.children.add(decode(treeNode, true));
                }
            }

            return node;
        }
    }
}
