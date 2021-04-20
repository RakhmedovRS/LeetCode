package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 04-Feb-21
 */
@LeetCode(
        id = 428,
        name = "Serialize and Deserialize N-ary Tree",
        url = "https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/",
        difficulty = Difficulty.HARD,
        premium = true
)
public class SerializeAndDeserializeNaryTree
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
        // Encodes a tree to a single string.
        public String serialize(Node root)
        {
            if (root == null)
            {
                return "null";
            }

            StringBuilder sb = new StringBuilder();
            dfs(null, root, new HashMap<>(), new HashMap<>(), sb);
            return sb.toString();
        }

        private void dfs(Node parent, Node current,
                         Map<Integer, Integer> nodes,
                         Map<Node, Integer> nodeIds,
                         StringBuilder sb)
        {
            if (current == null)
            {
                return;
            }

            if (current.children != null)
            {
                for (Node child : current.children)
                {
                    dfs(current, child, nodes, nodeIds, sb);
                }
            }

            if (sb.length() != 0)
            {
                sb.append("|");
            }

            if (parent == null)
            {
                sb.append("null");
            }
            else
            {
                int pid;
                if (!nodeIds.containsKey(parent))
                {
                    pid = nodes.getOrDefault(parent.val, 0) + 1;
                    nodes.put(parent.val, pid);
                    nodeIds.put(parent, pid);
                }
                else
                {
                    pid = nodeIds.get(parent);
                }

                sb.append(parent.val);
                sb.append(",");
                sb.append(pid);
            }

            int cid;
            if (!nodeIds.containsKey(current))
            {
                cid = nodes.getOrDefault(current.val, 0) + 1;
                nodes.put(current.val, cid);
                nodeIds.put(current, cid);
            }
            else
            {
                cid = nodeIds.get(current);
            }

            sb.append(",");
            sb.append(current.val);
            sb.append(",");
            sb.append(cid);
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data)
        {
            if (data == null || data.equals("null"))
            {
                return null;
            }

            Map<Integer, Map<Integer, Node>> map = new HashMap<>();

            Node root = null;
            String[] childToParents = data.split("\\|");
            int pValue;
            int pid;
            int cValue;
            int cid;
            for (String childToParent : childToParents)
            {
                String[] parts = childToParent.split(",");
                if (parts[0].equals("null"))
                {
                    cValue = Integer.parseInt(parts[1]);
                    cid = Integer.parseInt(parts[2]);

                    map.putIfAbsent(cValue, new HashMap<>());
                    map.get(cValue).putIfAbsent(cid, new Node(cValue, new ArrayList<>()));

                    root = map.get(cValue).get(cid);
                }
                else
                {
                    pValue = Integer.parseInt(parts[0]);
                    pid = Integer.parseInt(parts[1]);
                    cValue = Integer.parseInt(parts[2]);
                    cid = Integer.parseInt(parts[3]);

                    map.putIfAbsent(pValue, new HashMap<>());
                    map.get(pValue).putIfAbsent(pid, new Node(pValue, new ArrayList<>()));

                    map.putIfAbsent(cValue, new HashMap<>());
                    map.get(cValue).putIfAbsent(cid, new Node(cValue, new ArrayList<>()));

                    Node parent = map.get(pValue).get(pid);
                    Node current = map.get(cValue).get(cid);

                    parent.children.add(current);
                }
            }

            return root;
        }
    }

    public static void main(String[] args)
    {
        SerializeAndDeserializeNaryTree clazz = new SerializeAndDeserializeNaryTree();
        Codec codec = clazz.new Codec();

        Node root = clazz.new Node(1);

        Node a = clazz.new Node(3);
        Node b = clazz.new Node(2);
        Node c = clazz.new Node(4);

        root.children = new ArrayList<>();
        root.children.add(a);
        root.children.add(b);
        root.children.add(c);

        Node aa = clazz.new Node(5);
        Node ab = clazz.new Node(6);

        a.children = new ArrayList<>();
        a.children.add(aa);
        a.children.add(ab);

        System.out.println(codec.serialize(aa));
        codec.deserialize(codec.serialize(aa));

        System.out.println(codec.serialize(null));
        codec.deserialize(codec.serialize(null));

        System.out.println(codec.serialize(root));
        codec.deserialize(codec.serialize(root));
    }
}
