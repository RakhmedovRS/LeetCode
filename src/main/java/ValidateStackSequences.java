import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 02-Feb-21
 */
@LeetCode(
        id = 946,
        name = "Validate Stack Sequences",
        url = "https://leetcode.com/problems/validate-stack-sequences/",
        difficulty = Difficulty.MEDIUM
)
public class ValidateStackSequences
{
    public boolean validateStackSequences(int[] pushed, int[] popped)
    {
        int pushedPos = 0;
        int poppedPos = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < pushed.length + popped.length; i++)
        {
            while (!stack.isEmpty() && poppedPos < popped.length && stack.peek() == popped[poppedPos])
            {
                poppedPos++;
                stack.pop();
            }
            if (pushedPos < pushed.length)
            {
                stack.push(pushed[pushedPos++]);
            }
        }

        return stack.isEmpty() && pushedPos == pushed.length && poppedPos == popped.length;
    }

    public static void main(String[] args)
    {
        ValidateStackSequences clazz = new ValidateStackSequences();
        System.out.println(clazz.validateStackSequences(new int[]{0}, new int[]{0}));
        System.out.println(clazz.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
