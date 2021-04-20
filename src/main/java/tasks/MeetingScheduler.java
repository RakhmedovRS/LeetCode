package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 03-Feb-21
 */
@LeetCode(
        id = 1229,
        name = "Meeting Scheduler",
        url = "https://leetcode.com/problems/meeting-scheduler/",
        difficulty = Difficulty.MEDIUM,
        premium = true
)
public class MeetingScheduler
{
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration)
    {
        Comparator<int[]> comparator = (a, b) ->
        {
            if (a[0] == b[0])
            {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        };

        Arrays.sort(slots1, comparator);
        Arrays.sort(slots2, comparator);


        int aPos = 0;
        int bBos = 0;
        int[] aSlot;
        int[] bSlot;
        while (aPos < slots1.length && bBos < slots2.length)
        {
            aSlot = slots1[aPos];
            bSlot = slots2[bBos];
            long start = Math.max(aSlot[0], bSlot[0]);
            long end = Math.min(aSlot[1], bSlot[1]);
            if (start + duration <= end)
            {
                return Arrays.asList((int) start, (int) start + duration);
            }

            if (aSlot[0] == start)
            {
                bBos++;
            }
            else
            {
                aPos++;
            }
        }

        return Collections.emptyList();
    }

    public static void main(String[] args)
    {
        MeetingScheduler clazz = new MeetingScheduler();

        System.out.println(clazz.minAvailableDuration(
                new int[][]{
                        {216397070, 363167701},
                        {98730764, 158208909},
                        {441003187, 466254040},
                        {558239978, 678368334},
                        {683942980, 717766451}
                },
                new int[][]{
                        {50490609, 222653186},
                        {512711631, 670791418},
                        {730229023, 802410205},
                        {812553104, 891266775},
                        {230032010, 399152578}
                },
                456085
        ));

        System.out.println(clazz.minAvailableDuration(
                new int[][]{
                        {10, 50},
                        {50, 120},
                        {140, 210}
                },
                new int[][]{
                        {0, 15},
                        {60, 70}
                },
                12
        ));
    }
}
