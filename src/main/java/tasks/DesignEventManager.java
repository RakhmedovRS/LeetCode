package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-28
 */
@LeetCode(
        id = 3885,
        name = "Design Event Manager",
        url = "https://leetcode.com/problems/design-event-manager/description/",
        difficulty = Difficulty.MEDIUM
)
public class DesignEventManager {
    class EventManager {

        Map<Integer, Integer> events = new HashMap<>();
        TreeSet<Integer> sorted;

        public EventManager(int[][] EVENTS) {
            for (int[] event : EVENTS) {
                events.put(event[0], event[1]);
            }

            sorted = new TreeSet<>((a, b) -> {
                if (events.get(a).equals(events.get(b))) {
                    return a - b;
                } else {
                    return events.get(b) - events.get(a);
                }
            });

            sorted.addAll(events.keySet());
        }

        public void updatePriority(int eventId, int newPriority) {
            sorted.remove(eventId);
            events.put(eventId, newPriority);
            sorted.add(eventId);
        }

        public int pollHighest() {
            if (sorted.isEmpty()) {
                return -1;
            }

            int eventId = sorted.first();
            sorted.remove(eventId);
            events.remove(eventId);
            return eventId;
        }
    }
}