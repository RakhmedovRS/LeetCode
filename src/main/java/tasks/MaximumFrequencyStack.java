package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 10/6/2020
 */
@LeetCode(
		id = 895,
		name = "Maximum Frequency Stack",
		url = "https://leetcode.com/problems/maximum-frequency-stack/",
		difficulty = Difficulty.HARD
)
public class MaximumFrequencyStack {
	class FreqStack {
		int counter;
		TreeSet<Integer> treeSet;
		Map<Integer, List<Integer>> map;

		public FreqStack() {
			treeSet = new TreeSet<>((a, b) ->
			{
				List<Integer> listA = map.get(a);
				List<Integer> listB = map.get(b);
				if (listA == null && listB == null) {
					return 0;
				}
				else if (listA == null) {
					return 1;
				}
				else if (listB == null) {
					return -1;
				}

				if (listA.size() == listB.size()) {
					if (!listA.isEmpty()) {
						return listB.get(listB.size() - 1) - listA.get(listA.size() - 1);
					}
					return 0;
				}

				return listB.size() - listA.size();
			});

			map = new HashMap<>();
		}

		public void push(int x) {
			treeSet.remove(x);
			List<Integer> list = map.getOrDefault(x, new ArrayList<>());
			list.add(counter++);
			map.put(x, list);
			treeSet.add(x);
		}

		public int pop() {
			int first = treeSet.first();
			treeSet.remove(first);
			List<Integer> list = map.remove(first);
			list.remove(list.size() - 1);
			map.put(first, list);
			treeSet.add(first);
			return first;
		}
	}

	public static void main(String[] args) {
		MaximumFrequencyStack clazz = new MaximumFrequencyStack();
		FreqStack freqStack = clazz.new FreqStack();
		freqStack.push(5);
		freqStack.push(7);
		freqStack.push(5);
		freqStack.push(7);
		freqStack.push(4);
		freqStack.push(5);

		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
		System.out.println(freqStack.pop());
	}
}
