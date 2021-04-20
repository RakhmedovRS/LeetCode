package tasks;

import common.LeetCode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author RakhmedovRS
 * @created 08-Jul-20
 */
@LeetCode(id = 1117, name = "Building H2O", url = "https://leetcode.com/problems/building-h2o/")
public class BuildingH2O
{
	class H2O
	{
		AtomicInteger HsCount;
		Semaphore Hs;
		Semaphore Os;

		public H2O()
		{
			HsCount = new AtomicInteger();
			Hs = new Semaphore(2);
			Os = new Semaphore(1);
		}

		public void hydrogen(Runnable releaseHydrogen) throws InterruptedException
		{
			Hs.acquire();
			releaseHydrogen.run();

			if (HsCount.incrementAndGet() == 2)
			{
				HsCount.set(0);
				Os.release();
			}
		}

		public void oxygen(Runnable releaseOxygen) throws InterruptedException
		{
			Os.acquire();
			releaseOxygen.run();
			Hs.release(2);
		}
	}
}
