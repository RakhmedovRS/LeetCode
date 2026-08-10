package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-08-09
 */
@LeetCode(
        id = 4015,
        name = "Weighted Sum of a Tree",
        url = "https://leetcode.com/problems/weighted-sum-of-a-tree/description/",
        difficulty = Difficulty.MEDIUM
)
public class WeightedSumOfTree {
    class Node {
        int weight;
        List<Node> children;

        public Node(int weight) {
            this.weight = weight;
            children = new ArrayList<>();
        }
    }

    public long weightedSum(int[] parent, int[] nums) {
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            nodes.put(i, new Node(nums[i]));
        }

        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                nodes.get(parent[i]).children.add(nodes.get(i));
            }
        }

        LinkedList<Node> temp = new LinkedList<>();
        temp.add(nodes.get(0));
        int h = 0;
        while (!temp.isEmpty()) {
            int size = temp.size();
            while (size-- > 0) {
                Node curr = temp.removeFirst();
                if (!curr.children.isEmpty()) {
                    temp.addAll(curr.children);
                }
            }
            h++;
        }

        long ans = 0;
        int d = 1;
        temp.add(nodes.get(0));
        while (!temp.isEmpty()) {
            int size = temp.size();
            while (size-- > 0) {
                Node curr = temp.removeFirst();
                ans += ((long) curr.weight * (h - d + 1));
                if (!curr.children.isEmpty()) {
                    temp.addAll(curr.children);
                }
            }
            d++;
        }
        return ans;
    }
}