package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/7/2020
 */
@LeetCode(id = 1401, name = "Circle and Rectangle Overlapping", url = "https://leetcode.com/problems/circle-and-rectangle-overlapping/")
public class CircleAndRectangleOverlapping
{
	class Circle
	{
		int x;
		int y;
		int radius;

		public Circle(int x, int y, int radius)
		{
			this.x = x;
			this.y = y;
			this.radius = radius;
		}

		boolean isPointInside(int x, int y)
		{
			return radius * radius >= (int) Math.pow(this.x - x, 2) + (int) Math.pow(this.y - y, 2);
		}
	}

	public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2)
	{
		Circle circle = new Circle(x_center, y_center, radius);

		for (int x = x1; x <= x2; x++)
		{
			for (int y = y2; y >= y1; y--)
			{
				if (circle.isPointInside(x, y))
				{
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		System.out.println(new CircleAndRectangleOverlapping().checkOverlap(18, 11, 19, 7, 12, 10, 20));
		System.out.println(new CircleAndRectangleOverlapping().checkOverlap(1, 0, 0, 1, -1, 3, 1));
	}
}
