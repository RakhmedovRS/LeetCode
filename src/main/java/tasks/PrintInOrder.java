package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 03-Jun-20
 */
@LeetCode(id = 1114, name = "Print in Order", url = "https://leetcode.com/problems/print-in-order/")
public class PrintInOrder {
	class Foo {
		final boolean[] state;

		public Foo() {
			state = new boolean[4];
			state[0] = true;
		}

		private void checkAndUpdate(int i) throws InterruptedException {
			while (!state[i]) {
				synchronized (state) {
					state[i] = state[i - 1];
				}
				Thread.sleep(1);
			}

			synchronized (state) {
				if (i == 3 && state[i]) {
					Arrays.fill(state, 1, 3, false);
				}
			}
		}

		public void first(Runnable printFirst) throws InterruptedException {
			checkAndUpdate(1);
			printFirst.run();
		}

		public void second(Runnable printSecond) throws InterruptedException {
			checkAndUpdate(2);
			printSecond.run();
		}

		public void third(Runnable printThird) throws InterruptedException {
			checkAndUpdate(3);
			printThird.run();
		}
	}
}
