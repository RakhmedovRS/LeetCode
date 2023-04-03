package contest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 9/27/2020
 * <pre>
 * input size    | required time complexity
 * n <= 11       | O(n!), O(n^6)
 * n <= 15..18   | O(2^n * n^2)
 * n <= 18..22   | O(2^n * n)
 * n <= 100      | O(n^4)
 * n <= 400      | O(n^3)
 * n <= 2000     | O(n^2 * log n)
 * n <= 10^5     | O(n^2)
 * n <= 10^6     | O(n log n) or O(n)
 * n <= 10^8     | O(n), O(log n), O(1)
 * n <= 10^9     | O(1)
 * </pre>
 *
 * <pre>
 * Two Pointers
 * Binary Search
 * Stack
 * Sorting
 * Trie
 * Dynamic Programming
 * Math
 * Greedy
 * Heap
 * Sliding Window
 * Graph
 * Recursion
 * Prefix Sum
 * XOR
 * </pre>
 */
public class Contest
{
    int MOD = 1_000_000_007;

    public int findTheLongestBalancedSubstring(String s)
    {
        int max = 0;
        int pos = 0;
        while (pos < s.length())
        {
            int z = 0;
            int o = 0;
            while (pos < s.length() && s.charAt(pos) == '0')
            {
                z++;
                pos++;
            }

            while (pos < s.length() && s.charAt(pos) == '1')
            {
                o++;
                if (z >= o)
                {
                    max = Math.max(max, o * 2);
                }
                pos++;
            }
        }

        return max;
    }

    public static void main(String[] args) throws Exception
    {
        Contest clazz = new Contest();
    }

    private static String readBigTestCase() throws IOException
    {
        try (BufferedReader br = new BufferedReader(new FileReader(Thread.currentThread().getContextClassLoader().getResource("TestCase.txt").getFile())))
        {
            return br.lines().collect(Collectors.joining());
        }
    }

    private static void outputFormattedInput(String input)
    {
        System.out.println(Arrays.stream(input.split("\n")).map(Contest::replaceBracketsWithBraces).collect(Collectors.joining(",\n")));
    }

    private static String replaceBracketsWithBraces(String input)
    {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] == '[')
            {
                chars[i] = '{';
            }

            if (chars[i] == ']')
            {
                chars[i] = '}';
            }
        }
        return String.valueOf(chars);
    }
}
