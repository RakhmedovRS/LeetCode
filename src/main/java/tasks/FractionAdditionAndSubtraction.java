package tasks;

import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 03-Jul-20
 */
@LeetCode(id = 592, name = "Fraction Addition and Subtraction", url = "https://leetcode.com/problems/fraction-addition-and-subtraction/")
public class FractionAdditionAndSubtraction {
	private class Term {
		boolean negative;
		int dividend;
		int divisor;

		public Term() {
		}

		public Term(boolean negative, int dividend, int divisor) {
			this.negative = negative;
			this.dividend = dividend;
			this.divisor = divisor;
		}

		public boolean isNegative() {
			return negative;
		}

		@Override
		public String toString() {
			return (negative ? "-" : "") + dividend + "/" + divisor;
		}
	}

	public String fractionAddition(String expression) {
		if (expression == null || expression.length() == 0) {
			return expression;
		}

		LinkedList<Term> terms = new LinkedList<>();
		int[] pos = new int[]{0};
		while (pos[0] < expression.length()) {
			boolean negative = expression.charAt(pos[0]) == '-';
			if (negative || expression.charAt(pos[0]) == '+') {
				pos[0]++;
			}
			int dividend = getNumber(expression, pos);
			pos[0]++;
			int divisor = getNumber(expression, pos);

			terms.add(new Term(negative, dividend, divisor));
		}

		while (terms.size() != 1) {
			add(terms);
		}

		return terms.getFirst().toString();
	}

	private int getNumber(String expression, int[] pos) {
		if (pos[0] + 1 == expression.length() || !Character.isDigit(expression.charAt(pos[0] + 1))) {
			return expression.charAt(pos[0]++) - '0';
		}

		return (expression.charAt(pos[0]++) - '0') * 10 + expression.charAt(pos[0]++) - '0';
	}

	private void add(LinkedList<Term> terms) {
		Term term1 = terms.removeFirst();
		Term term2 = terms.removeFirst();

		Term result = new Term();
		int multiplicator = term1.divisor == term2.divisor ? term2.divisor : term1.divisor * term2.divisor;
		result.divisor = multiplicator;
		term1.dividend = (term1.dividend * multiplicator) / term1.divisor;
		term2.dividend = (term2.dividend * multiplicator) / term2.divisor;
		if (term1.isNegative() && term2.isNegative()) {
			result.negative = true;
			result.dividend = term1.dividend + term2.dividend;
		}
		else if (!term1.isNegative() && !term2.isNegative()) {
			result.negative = false;
			result.dividend = term1.dividend + term2.dividend;
		}
		else if (term1.isNegative()) {
			result.negative = term2.dividend - term1.dividend < 0;
			result.dividend = Math.abs(term1.dividend - term2.dividend);
		}
		else {
			result.negative = term1.dividend - term2.dividend < 0;
			result.dividend = Math.abs(term1.dividend - term2.dividend);
		}

		int lcd = lcd(result.dividend, result.divisor);
		result.dividend /= lcd;
		result.divisor /= lcd;

		terms.addLast(result);
	}

	private int lcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return lcd(b % a, a);
	}
}
