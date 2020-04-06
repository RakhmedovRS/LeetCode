import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
@LeetCode(id = 557, name = "Reverse Words in a String III", url = "https://leetcode.com/problems/reverse-words-in-a-string-iii/")
public class ReverseWordsInStringIII
{
	public String reverseWords(String s)
	{
		if (s == null)
		{
			return null;
		}

		char[] chars = s.toCharArray();
		int zeroPos = 0;
		int left;
		int right;
		char temp;
		while (zeroPos < chars.length)
		{
			left = zeroPos;
			while (zeroPos < chars.length && chars[zeroPos] != ' ')
			{
				zeroPos++;
			}
			right = zeroPos - 1;

			while (left < right)
			{
				temp = chars[left];
				chars[left] = chars[right];
				chars[right] = temp;
				left++;
				right--;
			}
			zeroPos++;
		}

		return String.valueOf(chars);
	}

	public static void main(String[] args)
	{
		System.out.println(new ReverseWordsInStringIII().reverseWords("I love you"));
		System.out.println(new ReverseWordsInStringIII().reverseWords("Let's take LeetCode contest"));
	}
}
