/**
 * @author RakhmedovRS
 * @created 12-Mar-20
 */
@LeetCode(id = 334, name = "Reverse String", url = "https://leetcode.com/problems/reverse-string/")
public class ReverseString
{
	public void reverseString(char[] s)
	{
		int left = 0;
		int right = s.length - 1;
		while (left < right)
		{
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}
}
