import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 3/2/2021
 */
@LeetCode(
	id = 1172,
	name = "Dinner Plate Stacks",
	url = "https://leetcode.com/problems/dinner-plate-stacks/",
	difficulty = Difficulty.HARD
)
public class DinnerPlateStacks
{
	class DinnerPlates
	{
		int capacity;
		List<LinkedList<Integer>> stacks;
		TreeSet<Integer> indices;

		public DinnerPlates(int capacity)
		{
			this.capacity = capacity;
			stacks = new ArrayList<>();
			indices = new TreeSet<>();
		}

		public void push(int val)
		{
			if (!indices.isEmpty())
			{
				int index = indices.first();
				stacks.get(index).addFirst(val);
				if (stacks.get(index).size() == capacity)
				{
					indices.remove(index);
				}
			}
			else
			{
				if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == capacity)
				{
					stacks.add(new LinkedList<>());
				}
				stacks.get(stacks.size() - 1).addFirst(val);
			}
		}

		public int pop()
		{
			if (!stacks.isEmpty())
			{
				int value = stacks.get(stacks.size() - 1).removeFirst();
				while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty())
				{
					indices.remove(stacks.size() - 1);
					stacks.remove(stacks.size() - 1);
				}

				return value;
			}

			return -1;
		}

		public int popAtStack(int index)
		{
			if (index >= stacks.size() || stacks.get(index).isEmpty())
			{
				return -1;
			}

			if (index == stacks.size() - 1)
			{
				return pop();
			}

			indices.add(index);

			return stacks.get(index).removeFirst();
		}
	}
}
