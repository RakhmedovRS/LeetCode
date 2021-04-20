package tasks;

import common.LeetCode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author RakhmedovRS
 * @created 27-Jun-20
 */
@LeetCode(id = 1195, name = "Fizz Buzz Multithreaded", url = "https://leetcode.com/problems/fizz-buzz-multithreaded/")
public class FizzBuzzMultithreaded
{
	class FizzBuzz
	{
		private int n;
		private Semaphore semaphore;
		private AtomicInteger current;

		public FizzBuzz(int n)
		{
			this.n = n;
			semaphore = new Semaphore(1);
			current = new AtomicInteger(1);
		}

		// printFizz.run() outputs "fizz".
		public void fizz(Runnable printFizz) throws InterruptedException
		{
			int steps = n / 3 - n / 15;
			int step = 0;
			while (step < steps)
			{
				try
				{
					semaphore.acquire();
					if (current.get() % 3 == 0 && current.get() % 15 != 0)
					{
						printFizz.run();
						current.incrementAndGet();
						step++;
					}
				}
				finally
				{
					semaphore.release();
				}
			}
		}

		// printBuzz.run() outputs "buzz".
		public void buzz(Runnable printBuzz) throws InterruptedException
		{
			int steps = n / 5 - n / 15;
			int step = 0;
			while (step < steps)
			{
				try
				{
					semaphore.acquire();
					if (current.get() % 5 == 0 && current.get() % 15 != 0)
					{
						printBuzz.run();
						current.incrementAndGet();
						step++;
					}
				}
				finally
				{
					semaphore.release();
				}
			}
		}

		// printFizzBuzz.run() outputs "fizzbuzz".
		public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException
		{
			int steps = n / 15;
			int step = 0;
			while (step < steps)
			{
				try
				{
					semaphore.acquire();
					if (current.get() % 15 == 0)
					{
						printFizzBuzz.run();
						current.incrementAndGet();
						step++;
					}
				}
				finally
				{
					semaphore.release();
				}
			}
		}

		// printNumber.accept(x) outputs "x", where x is an integer.
		public void number(IntConsumer printNumber) throws InterruptedException
		{
			int steps = n - n / 3 - n / 5 + n / 15;
			int step = 0;
			while (step < steps)
			{
				try
				{
					semaphore.acquire();
					if (current.get() % 3 != 0 && current.get() % 5 != 0)
					{
						printNumber.accept(current.intValue());
						current.incrementAndGet();
						step++;
					}
				}
				finally
				{
					semaphore.release();
				}
			}
		}
	}
}
