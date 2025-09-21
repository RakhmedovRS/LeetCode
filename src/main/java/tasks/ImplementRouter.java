package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-20
 */
@LeetCode(
        id = 3508,
        name = "Implement Router",
        url = "https://leetcode.com/problems/implement-router/description",
        difficulty = Difficulty.MEDIUM
)
public class ImplementRouter {
    class Packet {
        int source;
        int destination;
        int timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }
    }

    class Router {
        public static final long LONG = 1_000_000L;
        int memoryLimit;
        Map<Integer, Map<Integer, Set<Integer>>> seen;
        TreeMap<Integer, LinkedList<Packet>> fifo;
        Map<Integer, TreeSet<Long>> destinationToTime;

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
            seen = new HashMap<>();
            fifo = new TreeMap<>();
            destinationToTime = new HashMap<>();
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            if (seen.getOrDefault(source, Collections.emptyMap()).getOrDefault(destination, Collections.emptySet()).contains(timestamp)) {
                return false;
            }

            if (memoryLimit == 0) {
                forwardPacket();
            }

            seen.computeIfAbsent(source, s -> new HashMap<>());
            seen.get(source).computeIfAbsent(destination, d -> new HashSet<>());
            seen.get(source).get(destination).add(timestamp);

            Packet packet = new Packet(source, destination, timestamp);
            fifo.computeIfAbsent(timestamp, t -> new LinkedList<>());
            fifo.get(timestamp).addLast(packet);

            destinationToTime.putIfAbsent(destination, new TreeSet<>());
            destinationToTime.get(destination).add(timestamp * LONG + source);
            memoryLimit--;
            return true;
        }

        public int[] forwardPacket() {
            if (fifo.isEmpty()) {
                return new int[0];
            }

            memoryLimit++;

            int key = fifo.firstKey();
            Packet packet = fifo.get(key).removeFirst();
            if (fifo.get(key).isEmpty()) {
                fifo.remove(key);
            }

            destinationToTime.get(packet.destination).remove(packet.timestamp * LONG + packet.source);

            seen.get(packet.source).get(packet.destination).remove(packet.timestamp);

            return new int[]{packet.source, packet.destination, packet.timestamp};
        }

        public int getCount(int destination, int startTime, int endTime) {
            return destinationToTime.getOrDefault(destination, new TreeSet<>()).subSet(startTime * LONG, endTime * LONG + 1_000_001).size();
        }
    }
}