package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-10-26
 */
@LeetCode(
        id = 3331,
        name = "Find Subtree Sizes After Changes",
        url = "https://leetcode.com/problems/find-subtree-sizes-after-changes/description/",
        difficulty = Difficulty.MEDIUM
)
public class FindSubtreeSizesAfterChanges {
    static class TreeNode {
        int parentId;
        int id;
        char ch;
        Set<Integer> children;

        public TreeNode(int parentId, int id, char ch) {
            this.parentId = parentId;
            this.id = id;
            this.ch = ch;
            children = new HashSet<>();
        }
    }

    public int[] findSubtreeSizes(int[] parent, String s) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            TreeNode node = new TreeNode(parent[i], i, s.charAt(i));
            nodeMap.put(i, node);

            if (nodeMap.containsKey(parent[i])) {
                nodeMap.get(parent[i]).children.add(i);
            }
        }

        for (int i = 0; i < parent.length; i++) {
            if (nodeMap.containsKey(parent[i])) {
                nodeMap.get(parent[i]).children.add(i);
            }
        }

        LinkedList<Map.Entry<TreeNode, Integer[]>> stack = new LinkedList<>();
        stack.add(new java.util.AbstractMap.SimpleEntry<>(nodeMap.get(0), new Integer[26]));
        while (!stack.isEmpty()) {
            Map.Entry<TreeNode, Integer[]> entry = stack.removeFirst();
            TreeNode node = entry.getKey();
            Integer[] ancestors = entry.getValue();
            TreeNode p = nodeMap.get(node.parentId);

            if (ancestors[node.ch - 'a'] != null) {
                p.children.remove(node.id);
                node.parentId = nodeMap.get(ancestors[node.ch - 'a']).id;
                nodeMap.get(ancestors[node.ch - 'a']).children.add(node.id);
            }

            ancestors[node.ch - 'a'] = node.id;

            for (int child : node.children) {
                stack.addFirst(new java.util.AbstractMap.SimpleEntry<>(nodeMap.get(child), Arrays.copyOf(ancestors, ancestors.length)));
            }
        }

        int[] ans = new int[s.length()];
        ans[0] = dfs(0, nodeMap, ans);
        return ans;
    }

    private int dfs(int nodeId, Map<Integer, TreeNode> nodeMap, int[] ans) {
        int sum = 1;
        for (int childId : nodeMap.get(nodeId).children) {
            sum += dfs(childId, nodeMap, ans);
        }
        ans[nodeId] += sum;
        return sum;
    }
}