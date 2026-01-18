package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-01-17
 */
@LeetCode(
        id = 3815,
        name = "Design Auction System",
        url = "https://leetcode.com/problems/design-auction-system/description/",
        difficulty = Difficulty.MEDIUM
)
public class DesignAuctionSystem {
    class AuctionSystem {

        Map<Integer, Map<Integer, Integer>> userToBid;
        Map<Integer, PriorityQueue<int[]>> itemsToBids;
        Comparator<int[]> comparator;

        public AuctionSystem() {
            userToBid = new HashMap<>();
            itemsToBids = new HashMap<>();
            comparator = ((a, b) -> {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return b[0] - a[0];
                }
            });
        }

        public void addBid(int userId, int itemId, int bidAmount) {
            userToBid.computeIfAbsent(userId, U -> new HashMap<>()).put(itemId, bidAmount);
            itemsToBids.computeIfAbsent(itemId, I -> new PriorityQueue<>(comparator)).add(new int[]{bidAmount, userId});
        }

        public void updateBid(int userId, int itemId, int newAmount) {
            userToBid.computeIfAbsent(userId, U -> new HashMap<>()).put(itemId, newAmount);
            itemsToBids.computeIfAbsent(itemId, I -> new PriorityQueue<>(comparator)).add(new int[]{newAmount, userId});
        }

        public void removeBid(int userId, int itemId) {
            userToBid.computeIfAbsent(userId, U -> new HashMap<>()).put(itemId, -1);
        }

        public int getHighestBidder(int itemId) {
            PriorityQueue<int[]> pq = itemsToBids.get(itemId);
            if (pq != null) {
                while (!pq.isEmpty()) {
                    int[] curr = pq.remove();
                    int amount = curr[0];
                    int userId = curr[1];
                    if (!userToBid.containsKey(userId) || userToBid.get(userId).get(itemId) != amount) {
                        continue;
                    }
                    pq.add(curr);
                    return userId;
                }
            } else {
                return -1;
            }
            return -1;
        }
    }
}