package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-10-18
 */
@LeetCode(
        id = 4080,
        name = "Design Bus Seat Booking System",
        url = "https://leetcode.com/problems/design-bus-seat-booking-system/description/",
        difficulty = Difficulty.MEDIUM
)
public class DesignBusSeatBookingSystem {
    class BusBooking {

        Integer[][] seats;
        int totalTime;
        int minTime;
        int wallClock;

        public BusBooking(int n) {
            seats = new Integer[n][4];
        }

        public void toggle(String seat) {
            char[] chars = seat.toCharArray();
            int row = Integer.parseInt(seat.substring(1)) - 1;
            int col = chars[0] - 'A';
            if (seats[row][col] != null) {
                int seatTime = seats[row][col];
                totalTime -= seatTime;
                seats[row][col] = null;
                minTime--;
            } else {
                int cost = 1;

                if (col == 0 && seats[row][1] != null) {
                    cost = 3;
                } else if (col == 3 && seats[row][2] != null) {
                    cost = 3;
                }

                seats[row][col] = cost;
                totalTime += cost;
                minTime++;
            }

            wallClock++;
        }

        public int getTotalTime() {
            return totalTime;
        }

        public int getMinTime() {
            return minTime;
        }
    }
}