package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/3/2020
 */
@LeetCode(id = 1603, name = "Design Parking System", url = "https://leetcode.com/problems/design-parking-system/")
public class DesignParkingSystem
{
	class ParkingSystem
	{

		int[] slots;

		public ParkingSystem(int big, int medium, int small)
		{
			slots = new int[]{0, big, medium, small};
		}

		public boolean addCar(int carType)
		{
			slots[carType]--;
			return slots[carType] >= 0;
		}
	}
}
