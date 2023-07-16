package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 23-May-20
 */
@LeetCode(
		id = 1189,
		name = "Maximum Number of Balloons",
		url = "https://leetcode.com/problems/maximum-number-of-balloons/",
		difficulty = Difficulty.EASY
)
public class MaximumNumberOfBalloons
{
	public int maxNumberOfBalloons(String text)
	{
		int[] current = new int[26];
		int answer = Integer.MAX_VALUE;
		for (char ch : text.toCharArray())
		{
			current[ch - 'a']++;
		}

		answer = Math.min(answer, current['b' - 'a']);
		answer = Math.min(answer, current['a' - 'a']);
		answer = Math.min(answer, current['l' - 'a'] / 2);
		answer = Math.min(answer, current['o' - 'a'] / 2);
		answer = Math.min(answer, current['n' - 'a']);

		return answer;
	}

	public static void main(String[] args)
	{
		System.out.println(new MaximumNumberOfBalloons().maxNumberOfBalloons("loonbalxballpoon"));
		System.out.println(new MaximumNumberOfBalloons().maxNumberOfBalloons("krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw"));
	}
}
