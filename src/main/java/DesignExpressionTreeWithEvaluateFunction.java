import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 1/22/2021
 */
@LeetCode(
	id = 1628,
	name = "Design an Expression Tree With Evaluate Function",
	url = "https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class DesignExpressionTreeWithEvaluateFunction
{
	abstract class Node
	{
		public abstract int evaluate();
		// define your fields here
	}

	;

	class NodeImpl extends Node
	{
		String[] postfix;

		public NodeImpl(String[] postfix)
		{
			this.postfix = postfix;
		}

		@Override
		public int evaluate()
		{
			LinkedList<Integer> stack = new LinkedList<>();
			int a;
			int b;
			for (int i = 0; i < postfix.length; i++)
			{
				if (Character.isDigit(postfix[i].charAt(0)))
				{
					stack.push(Integer.parseInt(postfix[i]));
				}
				else
				{
					b = stack.pop();
					a = stack.pop();
					if ("+".equals(postfix[i]))
					{
						stack.push(a + b);
					}
					else if ("-".equals(postfix[i]))
					{
						stack.push(a - b);
					}
					else if ("*".equals(postfix[i]))
					{
						stack.push(a * b);
					}
					else
					{
						stack.push(a / b);
					}
				}
			}

			return stack.peek();
		}
	}

	class TreeBuilder
	{
		Node buildTree(String[] postfix)
		{
			return new NodeImpl(postfix);
		}
	}
}
