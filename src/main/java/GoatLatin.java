import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 09-Jun-20
 */
@LeetCode(id = 824, name = "Goat Latin", url = "https://leetcode.com/problems/goat-latin/")
public class GoatLatin
{
	public String toGoatLatin(String S)
	{
		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder a = new StringBuilder().append("a");
		int left = 0;
		for (int right = 0; right < S.length(); right++)
		{
			if (S.charAt(right) == ' ' || right == S.length() - 1)
			{
				char firstLetter = Character.toLowerCase(S.charAt(left));
				int end = right == S.length() - 1 ? right + 1 : right;
				if (firstLetter == 'a'
					|| firstLetter == 'e'
					|| firstLetter == 'i'
					|| firstLetter == 'o'
					|| firstLetter == 'u')
				{
					stringBuilder.append(S, left, end);
				}
				else
				{
					stringBuilder.append(S, left + 1, end);
					stringBuilder.append(S.charAt(left));
				}

				stringBuilder.append("ma");
				stringBuilder.append(a);
				if (right != S.length() - 1)
				{
					stringBuilder.append(" ");
				}
				a.append("a");
				left = right + 1;
			}
		}

		return stringBuilder.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new GoatLatin().toGoatLatin("I speak Goat Latin"));
	}
}
