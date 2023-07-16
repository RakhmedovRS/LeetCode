package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/15/2021
 */
@LeetCode(
		id = 1826,
		name = "Faulty Sensor",
		url = "https://leetcode.com/problems/faulty-sensor/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class FaultySensor
{
	public int badSensor(int[] sensor1, int[] sensor2)
	{
		for (int i = 0; i < sensor1.length - 1; i++)
		{
			if (sensor1[i] != sensor2[i])
			{
				if (match(i, i + 1, sensor1, sensor2))
				{
					return 1;
				}
				else if (match(i + 1, i, sensor1, sensor2))
				{
					return 2;
				}

				break;
			}
		}

		return -1;
	}

	private boolean match(int sensor1Pos, int sensor2Pos, int[] sensor1, int[] sensor2)
	{
		while (sensor1Pos < sensor1.length && sensor2Pos < sensor2.length)
		{
			if (sensor1[sensor1Pos++] != sensor2[sensor2Pos++])
			{
				return false;
			}
		}

		return true;
	}
}
