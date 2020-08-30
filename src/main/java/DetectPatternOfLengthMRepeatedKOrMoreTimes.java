import common.LeetCode;

@LeetCode(id = 1566, name = "Detect Pattern of Length M Repeated K or More Times", url = "https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/")
public class DetectPatternOfLengthMRepeatedKOrMoreTimes
{
    public boolean containsPattern(int[] arr, int m, int k)
    {
        for (int startPos = 0; startPos < m; startPos++)
        {
            String prev = null;
            int count = 0;
            for (int i = startPos; i < arr.length; i += m)
            {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m && j + i < arr.length; j++)
                {
                    sb.append(arr[i + j]);
                }
                String key = sb.toString();
                if (prev != null && prev.equals(key))
                {
                    count++;
                }
                else
                {
                    prev = key;
                    count = 1;
                }

                if (count >= k)
                {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(new DetectPatternOfLengthMRepeatedKOrMoreTimes().containsPattern(new int[]{1, 2, 3, 1, 2}, 2, 2));
        System.out.println(new DetectPatternOfLengthMRepeatedKOrMoreTimes().containsPattern(new int[]{1, 2, 1, 2, 1, 3}, 2, 3));
    }
}
