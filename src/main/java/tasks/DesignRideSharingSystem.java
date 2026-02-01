package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-02-01
 */
@LeetCode(
        id = 3829,
        name = "Design Ride Sharing System",
        url = "https://leetcode.com/problems/design-ride-sharing-system/description/",
        difficulty = Difficulty.MEDIUM
)
public class DesignRideSharingSystem {
    class Rider {
        int riderId;
        int rideId;

        public Rider(int riderId, int rideId) {
            this.riderId = riderId;
            this.rideId = rideId;
        }
    }

    class RideSharingSystem {
        LinkedList<Rider> ridersQueue;
        LinkedList<Integer> driversQueue;
        Map<Integer, TreeSet<Integer>> activeRiders;
        Map<Integer, Integer> ids = new HashMap<>();

        public RideSharingSystem() {
            activeRiders = new HashMap<>();
            ridersQueue = new LinkedList<>();
            driversQueue = new LinkedList<>();
        }

        public void addRider(int riderId) {
            TreeSet<Integer> set = activeRiders.computeIfAbsent(riderId, R -> new TreeSet<>());
            int id = ids.getOrDefault(riderId, 0) + 1;
            ids.put(riderId, id);
            set.add(id);
            ridersQueue.addLast(new Rider(riderId, set.last()));
        }

        public void addDriver(int driverId) {
            driversQueue.addLast(driverId);
        }

        public int[] matchDriverWithRider() {
            while (!ridersQueue.isEmpty() && activeRiders.containsKey(ridersQueue.getFirst().riderId) && !activeRiders.get(ridersQueue.getFirst().riderId).contains(ridersQueue.getFirst().rideId)) {
                ridersQueue.removeFirst();
            }

            if (!ridersQueue.isEmpty() && !driversQueue.isEmpty()) {
                return new int[]{driversQueue.removeFirst(), ridersQueue.removeFirst().riderId};
            }
            return new int[]{-1, -1};
        }

        public void cancelRider(int riderId) {
            if (activeRiders.containsKey(riderId)) {
                TreeSet<Integer> set = activeRiders.get(riderId);
                if (!set.isEmpty()) {
                    set.remove(set.first());
                }
            }
        }
    }
}