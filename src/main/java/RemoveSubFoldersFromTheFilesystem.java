import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 1/19/2021
 */
@LeetCode(
	id = 1233,
	name = "Remove Sub-Folders from the Filesystem",
	url = "https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/",
	difficulty = Difficulty.MEDIUM
)
public class RemoveSubFoldersFromTheFilesystem
{
	public List<String> removeSubfolders(String[] folders)
	{
		List<String> answer = new ArrayList<>();
		Arrays.sort(folders);
		for (String folder : folders)
		{
			if (answer.isEmpty() || !folder.startsWith(answer.get(answer.size() - 1) + "/"))
			{
				answer.add(folder);
			}
		}

		return answer;
	}
}
