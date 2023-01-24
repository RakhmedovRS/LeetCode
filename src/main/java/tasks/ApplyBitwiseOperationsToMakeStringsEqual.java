package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 1/24/2023
 * @$
 * @$
 */
@LeetCode(
        id = 2546,
        name = "Apply Bitwise Operations to Make Strings Equal",
        url = "https://leetcode.com/problems/apply-bitwise-operations-to-make-strings-equal/",
        difficulty = Difficulty.MEDIUM
)
public class ApplyBitwiseOperationsToMakeStringsEqual
{
    public boolean makeStringsEqual(String s, String t)
    {
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();

        boolean sOne = false;
        for (char ch : source)
        {
            if (ch == '1')
            {
                sOne = true;
                break;
            }
        }

        boolean tOne = false;
        for (char ch : target)
        {
            if (ch == '1')
            {
                tOne = true;
                break;
            }
        }

        return (sOne && tOne) || (!sOne && !tOne);
    }
}
