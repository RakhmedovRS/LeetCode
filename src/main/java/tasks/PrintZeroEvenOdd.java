package tasks;

import common.LeetCode;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

@LeetCode(id = 1116, name = "Print Zero Even Odd", url = "https://leetcode.com/problems/print-zero-even-odd/")
public class PrintZeroEvenOdd
{
    class ZeroEvenOdd
    {
        private int n;
        Semaphore zero;
        Semaphore even;
        Semaphore odd;

        public ZeroEvenOdd(int n)
        {
            this.n = n;
            zero = new Semaphore(1);
            even = new Semaphore(0);
            odd = new Semaphore(0);
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException
        {
            for (int i = 1; i <= n; i++)
            {
                zero.acquire();
                printNumber.accept(0);
                if (i % 2 == 0)
                {
                    even.release();
                }
                else
                {
                    odd.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException
        {
            for (int i = 2; i <= n; i += 2)
            {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException
        {
            for (int i = 1; i <= n; i += 2)
            {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        ZeroEvenOdd zeroEvenOdd = new PrintZeroEvenOdd().new ZeroEvenOdd(5);
        Executors.newSingleThreadExecutor().execute(() ->
        {
            try
            {
                zeroEvenOdd.zero(System.out::println);
            } catch (Exception ignore)
            {

            }
        });
        Executors.newSingleThreadExecutor().execute(() ->
        {
            try
            {
                zeroEvenOdd.even(System.out::println);
            } catch (Exception ignore)
            {

            }
        });
        Executors.newSingleThreadExecutor().execute(() ->
        {
            try
            {
                zeroEvenOdd.odd(System.out::println);
            } catch (Exception ignore)
            {

            }
        });

        Thread.sleep(1000);
    }
}
