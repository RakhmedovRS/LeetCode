package tasks;

import common.LeetCode;

import java.util.TreeMap;
import java.util.TreeSet;

@LeetCode(id = 220, name = "Contains Duplicate III", url = "https://leetcode.com/problems/contains-duplicate-iii/")
public class ContainsDuplicateIII
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        if (k >= nums.length - 1)
        {
            long key;
            TreeSet<Long> treeSet = new TreeSet<>();
            for (int num : nums)
            {
                key = num;
                Long ceiling = treeSet.ceiling(key);
                Long floor = treeSet.floor(key);
                if (ceiling != null && Math.abs(ceiling - key) <= t)
                {
                    return true;
                }
                if (floor != null && Math.abs(key - floor) <= t)
                {
                    return true;
                }

                treeSet.add(key);
            }
        }
        else
        {
            TreeMap<Long, Integer> treeMap = new TreeMap<>();
            long key;
            int left = 0;
            for (int right = 0; right < nums.length; right++)
            {
                if (right - left > k)
                {
                    key = nums[left++];
                    int count = treeMap.remove(key) - 1;
                    if (count > 0)
                    {
                        treeMap.put(key, count);
                    }
                }

                key = nums[right];
                Long ceiling = treeMap.ceilingKey(key);
                Long floor = treeMap.floorKey(key);
                if (ceiling != null && Math.abs(ceiling - key) <= t)
                {
                    return true;
                }
                if (floor != null && Math.abs(key - floor) <= t)
                {
                    return true;
                }

                treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);
            }
        }

        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{-3, 3}, 2, 4));
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
    }
}
