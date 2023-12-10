package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 01-Aug-20
 */
@LeetCode(
		id = 224,
		name = "Basic Calculator",
		url = "https://leetcode.com/problems/basic-calculator/",
		difficulty = Difficulty.HARD
)
public class BasicCalculator {
	public int calculate(String s) {
		Deque<Integer> stack = new LinkedList<>();
		int result = 0;
		int sign = 1;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == ' ') {
				continue;
			}

			if (Character.isDigit(ch)) {
				int number = ch - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					number *= 10;
					number += s.charAt(i + 1) - '0';
					i++;
				}
				result += sign * number;
			}
			else if (ch == '+') {
				sign = 1;
			}
			else if (ch == '-') {
				sign = -1;
			}
			else if (ch == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = 1;
			}
			else if (ch == ')') {
				int prevSign = stack.pop();
				int prevNumber = stack.pop();
				result = prevSign * result + prevNumber;
			}

		}

		return result;
	}

	//584 ms
	public int calculateReq(String s) {
		if (s.isEmpty()) {
			return 0;
		}

		if (s.contains("(")) {
			int startPos = 0;
			int endPos = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					startPos = i;
				}
				else if (s.charAt(i) == ')') {
					endPos = i;
					break;
				}
			}

			StringBuilder leftPart = new StringBuilder(s.substring(0, startPos));
			int middleRes = calculateReq(s.substring(startPos + 1, endPos));
			String rightPart = s.substring(endPos + 1);
			if (middleRes < 0 && leftPart.length() != 0 && leftPart.charAt(leftPart.length() - 1) == '-') {
				middleRes *= -1;
				leftPart.setCharAt(leftPart.length() - 1, '+');
			}

			return calculateReq(leftPart.append(middleRes).append(rightPart).toString());
		}
		else if (s.contains("+")) {
			String[] parts = s.split("\\+");
			int res = calculateReq(parts[0]);
			for (int i = 1; i < parts.length; i++) {
				res += calculateReq(parts[i]);
			}
			return res;
		}
		else if (s.contains("-")) {
			String[] parts = s.split("-");
			int res = calculateReq(parts[0]);
			for (int i = 1; i < parts.length; i++) {
				res -= calculateReq(parts[i]);
			}
			return res;
		}
		else {
			return Integer.parseInt(s);
		}
	}

	public static void main(String[] args) {
		System.out.println(new BasicCalculator().calculate("2-(5-6)"));
		System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(new BasicCalculator().calculate(" 2-1 + 2 "));
		System.out.println(new BasicCalculator().calculate("1 + 1"));
	}
}
