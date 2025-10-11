package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-10-11
 */
@LeetCode(
        id = 3709,
        name = "Design Exam Scores Tracker",
        url = "https://leetcode.com/problems/design-exam-scores-tracker/description/",
        difficulty = Difficulty.MEDIUM
)
public class DesignExamScoresTracker {
    class ExamTracker {

        long totalScore;
        TreeMap<Integer, Integer> positions;
        List<Long> scores;

        public ExamTracker() {
            positions = new TreeMap<>();
            scores = new ArrayList<>();
        }

        public void record(int time, int score) {
            int index = scores.size();

            if (index != 0) {
                scores.add(scores.get(scores.size() - 1) + score);
            } else {
                scores.add((long) score);
            }

            positions.put(time, index);
        }

        public long totalScore(int startTime, int endTime) {
            Integer endKey = positions.floorKey(endTime);
            Integer startKey = positions.ceilingKey(startTime);

            if (startKey != null && endKey != null) {
                int start = positions.get(startKey);
                int end = positions.get(endKey);

                if (start > 0) {
                    return scores.get(end) - scores.get(start - 1);
                }

                return scores.get(end);
            }
            return 0;
        }
    }
}