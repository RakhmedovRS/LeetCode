package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 14-Sep-20
 */
@LeetCode(id = 385, name = "Mini Parser", url = "https://leetcode.com/problems/mini-parser/")
public class MiniParser
{
	class NestedInteger
	{
		private List<NestedInteger> list;
		private Integer integer;

		public NestedInteger(List<NestedInteger> list)
		{
			this.list = list;
		}

		public void add(NestedInteger nestedInteger)
		{
			if (this.list != null)
			{
				this.list.add(nestedInteger);
			}
			else
			{
				this.list = new ArrayList<>();
				this.list.add(nestedInteger);
			}
		}

		public void setInteger(int num)
		{
			this.integer = num;
		}

		public NestedInteger(Integer integer)
		{
			this.integer = integer;
		}

		public NestedInteger()
		{
			this.list = new ArrayList<>();
		}

		public boolean isInteger()
		{
			return integer != null;
		}

		public Integer getInteger()
		{
			return integer;
		}

		public List<NestedInteger> getList()
		{
			return list;
		}

		public String printNi(NestedInteger thisNi, StringBuilder sb)
		{
			if (thisNi.isInteger())
			{
				sb.append(thisNi.integer);
				sb.append(",");
			}
			sb.append("[");
			for (NestedInteger ni : thisNi.list)
			{
				if (ni.isInteger())
				{
					sb.append(ni.integer);
					sb.append(",");
				}
				else
				{
					printNi(ni, sb);
				}
			}
			sb.append("]");
			return sb.toString();
		}
	}

	public NestedInteger deserialize(String s)
	{
		if (s.isEmpty())
		{
			return null;
		}

		if (s.charAt(0) != '[')
		{
			return new NestedInteger(Integer.parseInt(s));
		}

		NestedInteger current = null;
		Deque<NestedInteger> stack = new LinkedList<>();

		int left = 0;
		for (int right = 0; right < s.length(); right++)
		{
			char ch = s.charAt(right);
			if (ch == '[')
			{
				if (current != null)
				{
					stack.push(current);
				}

				current = new NestedInteger();
				left = right + 1;
			}
			else if (ch == ']')
			{
				String sub = s.substring(left, right);
				if (!sub.isEmpty())
				{
					current.add(new NestedInteger(Integer.parseInt(sub)));
				}

				if (!stack.isEmpty())
				{
					NestedInteger prev = stack.pop();
					prev.add(current);
					current = prev;
				}

				left = right + 1;
			}
			else if (ch == ',')
			{
				if (s.charAt(right - 1) != ']')
				{
					String sub = s.substring(left, right);
					current.add(new NestedInteger(Integer.parseInt(sub)));
				}

				left = right + 1;
			}
		}

		return current;
	}
}
