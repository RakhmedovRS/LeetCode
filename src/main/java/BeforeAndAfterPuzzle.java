import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/20/2020
 */
@LeetCode(
	id = 1181,
	name = "Before and After Puzzle",
	url = "https://leetcode.com/problems/before-and-after-puzzle/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class BeforeAndAfterPuzzle
{
	public List<String> beforeAndAfterPuzzles(String[] phrases)
	{
		TreeSet<String> answer = new TreeSet<>();
		String a;
		String b;
		String[] aParts;
		String[] bParts;
		for (int i = 0; i < phrases.length; i++)
		{
			a = phrases[i];
			aParts = a.split(" ");
			for (int j = 0; j < phrases.length; j++)
			{
				if (i != j)
				{
					b = phrases[j];
					bParts = b.split(" ");

					if (aParts[aParts.length - 1].equals(bParts[0]))
					{
						List<String> list = new ArrayList<>();
						for (int x = 0; x < aParts.length - 1; x++)
						{
							list.add(aParts[x]);
						}

						for (String bPart : bParts)
						{
							list.add(bPart);
						}

						answer.add(String.join(" ", list));
					}
				}
			}
		}

		return new ArrayList<>(answer);
	}

	public static void main(String[] args)
	{
		BeforeAndAfterPuzzle clazz = new BeforeAndAfterPuzzle();

		System.out.println(clazz.beforeAndAfterPuzzles(new String[]
			{
				"mission statement",
				"a quick bite to eat",
				"a chip off the old block",
				"chocolate bar",
				"mission impossible",
				"a man on a mission",
				"block party",
				"eat my words",
				"bar of soap"
			}));

		System.out.println(clazz.beforeAndAfterPuzzles(new String[]
			{"nrop xshcva twecfm twecfm twecfm xshcva twecfm",
				"ggwznmv twecfm nrop nrop nrop xshcva ggwznmv ggwznmv p twecfm nrop xshcva p p",
				"p p nrop ggwznmv twecfm nrop p p",
				"xshcva twecfm ggwznmv twecfm nrop p ggwznmv p twecfm", "xshcva"
			}));

		System.out.println(clazz.beforeAndAfterPuzzles(new String[]
			{
				"a", "b", "a"
			}));
	}
}
