import common.LeetCode;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author RakhmedovRS
 * @created 27-Jul-20
 */
@LeetCode(id = 1115, name = "Print FooBar Alternately", url = "https://leetcode.com/problems/print-foobar-alternately/")
public class PrintFooBarAlternately
{
	class FooBar
	{
		private int n;
		private AtomicBoolean needPrintFoo;

		public FooBar(int n)
		{
			this.n = n;
			this.needPrintFoo = new AtomicBoolean(true);
		}

		public void foo(Runnable printFoo) throws InterruptedException
		{

			for (int i = 0; i < n; i++)
			{
				while (!needPrintFoo.get())
				{
					Thread.sleep(1);
				}
				printFoo.run();
				needPrintFoo.set(false);
			}
		}

		public void bar(Runnable printBar) throws InterruptedException
		{
			for (int i = 0; i < n; i++)
			{
				while (needPrintFoo.get())
				{
					Thread.sleep(1);
				}
				printBar.run();
				needPrintFoo.set(true);
			}
		}
	}
}
