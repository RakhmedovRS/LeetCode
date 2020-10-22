import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 10/22/2020
 */
@LeetCode(id = 1024, name = "Video Stitching", url = "https://leetcode.com/problems/video-stitching/")
public class VideoStitching
{
	public int videoStitching(int[][] clips, int T)
	{
		int[] memo = new int[T + 1];
		Arrays.fill(memo, T + 1);
		memo[0] = 0;
		for (int i = 0; i <= T; i++)
		{
			for (int[] clip : clips)
			{
				if (clip[0] <= i && i <= clip[1])
				{
					memo[i] = Math.min(memo[i], memo[clip[0]] + 1);
				}
			}
		}

		return memo[T] == T + 1 ? -1 : memo[T];
	}
}
