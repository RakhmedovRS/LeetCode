import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/5/2021
 */
@LeetCode(
	id = 1634,
	name = "Add Two Polynomials Represented as Linked Lists",
	url = "https://leetcode.com/problems/add-two-polynomials-represented-as-linked-lists/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class AddTwoPolynomialsRepresentedAsLinkedLists
{
	class PolyNode
	{
		int coefficient, power;

		PolyNode next = null;

		PolyNode(){}

		PolyNode(int x, int y)
		{
			this.coefficient = x;
			this.power = y;
		}

		PolyNode(int x, int y, PolyNode next)
		{
			this.coefficient = x;
			this.power = y;
			this.next = next;
		}
	}

	public PolyNode addPoly(PolyNode poly1, PolyNode poly2)
	{
		if (poly1 == null)
		{
			return poly2;
		}
		else if (poly2 == null)
		{
			return poly1;
		}

		if (poly1.power > poly2.power)
		{
			poly1.next = addPoly(poly1.next, poly2);
			return poly1;
		}
		else if (poly2.power > poly1.power)
		{
			poly2.next = addPoly(poly1, poly2.next);
			return poly2;
		}
		else
		{
			if (poly1.coefficient + poly2.coefficient == 0)
			{
				return addPoly(poly1.next, poly2.next);
			}
			else
			{
				poly1.coefficient += poly2.coefficient;
				poly1.next = addPoly(poly1.next, poly2.next);
				return poly1;
			}
		}
	}
}
