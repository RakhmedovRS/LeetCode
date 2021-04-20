package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 05-Feb-21
 */
@LeetCode(
        id = 71,
        name = "Simplify Path",
        url = "https://leetcode.com/problems/simplify-path/",
        difficulty = Difficulty.MEDIUM
)
public class SimplifyPath
{
    public String simplifyPath(String path)
    {
        String[] parts = path.split("/");
        LinkedList<String> current = new LinkedList<>();
        for (String part : parts)
        {
            if (part.equals(".."))
            {
                if (!current.isEmpty())
                {
                    current.removeLast();
                }
            }
            else if (part.length() != 0 && !part.equals("."))
            {
                current.addLast(part);
            }
        }

        if (current.isEmpty())
        {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        for (String part : current)
        {
            sb.append("/");
            sb.append(part);
        }

        return sb.toString();
    }
}
