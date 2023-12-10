package tasks;

import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 05-Mar-20
 */
@LeetCode(id = 232, name = "Implement Queue using Stacks", url = "https://leetcode.com/problems/implement-queue-using-stacks/")
public class QueueUsingStacks {
	class MyQueue {
		Deque<Integer> frontStack;
		Deque<Integer> backStack;

		/**
		 * Initialize your data structure here.
		 */
		public MyQueue() {
			frontStack = new LinkedList<>();
			backStack = new LinkedList<>();
		}

		/**
		 * Push element x to the back of queue.
		 */
		public void push(int x) {
			backStack.push(x);
		}

		/**
		 * Removes the element from in front of queue and returns that element.
		 */
		public int pop() {
			if (!frontStack.isEmpty()) {
				return frontStack.pop();
			}
			else {
				while (!backStack.isEmpty()) {
					frontStack.push(backStack.remove());
				}
			}
			return frontStack.pop();
		}

		/**
		 * Get the front element.
		 */
		public int peek() {
			if (!frontStack.isEmpty()) {
				return frontStack.peek();
			}
			else {
				while (!backStack.isEmpty()) {
					frontStack.push(backStack.remove());
				}
			}
			return frontStack.peek();
		}

		/**
		 * Returns whether the queue is empty.
		 */
		public boolean empty() {
			return backStack.isEmpty() && frontStack.isEmpty();
		}
	}
}
