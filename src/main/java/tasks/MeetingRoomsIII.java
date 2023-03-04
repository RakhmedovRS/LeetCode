package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 9/10/2022
 */
@LeetCode(
        id = 2402,
        name = "Meeting Rooms III",
        url = "https://leetcode.com/problems/meeting-rooms-iii/",
        difficulty = Difficulty.HARD
)
public class MeetingRoomsIII
{
    public int mostBooked(int n, int[][] meetings)
    {
        Arrays.sort(meetings, Comparator.comparingInt(value -> value[0]));

        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            map.put(i, 0L);
        }

        int[] count = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b)))
            {
                return a - b;
            }

            return map.get(a).compareTo(map.get(b));
        });


        boolean[] roomInUse = new boolean[n];
        for (int[] meeting : meetings)
        {
            while (!pq.isEmpty() && map.get(pq.peek()) <= meeting[0])
            {
                int room = pq.remove();
                roomInUse[room] = false;
            }

            if (pq.isEmpty() || map.get(pq.peek()) > meeting[0])
            {
                for (int i = 0; i < roomInUse.length; i++)
                {
                    if (!roomInUse[i])
                    {
                        map.put(i, (long) meeting[0]);
                        roomInUse[i] = true;
                        pq.add(i);
                        break;
                    }
                }
            }

            int room = pq.remove();
            count[room]++;

            long endTime = map.get(room);
            map.put(room, Math.max(endTime, meeting[0]) + (meeting[1] - meeting[0]));
            pq.add(room);
        }


        int maxCount = 0;
        int pos = 0;
        for (int i = 0; i < count.length; i++)
        {
            if (count[i] > maxCount)
            {
                maxCount = count[i];
                pos = i;
            }
        }

        return pos;
    }
}
