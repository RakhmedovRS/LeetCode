package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/9/2020
 */
@LeetCode(
	id = 1352,
	name = "Product of the Last K Numbers",
	url = "https://leetcode.com/problems/product-of-the-last-k-numbers/",
	difficulty = Difficulty.MEDIUM
)
public class ProductOfTheLastKNumbers
{
	class ProductOfNumbers
	{

		List<Integer> numbers;

		public ProductOfNumbers()
		{
			numbers = new ArrayList<>();
		}

		public void add(int num)
		{
			if (num == 0)
			{
				numbers = new ArrayList<>();
			}
			else if (numbers.isEmpty())
			{
				numbers.add(num);
			}
			else
			{
				numbers.add(num * numbers.get(numbers.size() - 1));
			}
		}

		public int getProduct(int k)
		{
			if (k > numbers.size())
			{
				return 0;
			}
			else if (k == numbers.size())
			{
				return numbers.get(numbers.size() - 1);
			}
			else
			{
				return numbers.get(numbers.size() - 1) / numbers.get(numbers.size() - k - 1);
			}
		}
	}

	public static void main(String[] args)
	{
		ProductOfNumbers productOfNumbers = new ProductOfTheLastKNumbers().new ProductOfNumbers();
		productOfNumbers.add(3);        // [3]
		productOfNumbers.add(0);        // [3,0]
		productOfNumbers.add(2);        // [3,0,2]
		productOfNumbers.add(5);        // [3,0,2,5]
		productOfNumbers.add(4);        // [3,0,2,5,4]
		System.out.println(productOfNumbers.getProduct(2)); // return 20. The product of the last 2 numbers is 5 * 4 = 20
		System.out.println(productOfNumbers.getProduct(3)); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
		System.out.println(productOfNumbers.getProduct(4)); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
		productOfNumbers.add(8);        // [3,0,2,5,4,8]
		System.out.println(productOfNumbers.getProduct(2)); // return 32. The product of the last 2 numbers is 4 * 8 = 32
	}
}
