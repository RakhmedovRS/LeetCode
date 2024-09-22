package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-09-21
 */
@LeetCode(
        id = 3295,
        name = "Report Spam Message",
        url = "https://leetcode.com/problems/report-spam-message/description/",
        difficulty = Difficulty.MEDIUM
)
public class ReportSpamMessage {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Map<String, Integer> seen = new HashMap<>();
        for (String word : message) {
            seen.put(word, seen.getOrDefault(word, 0) + 1);
        }

        int seenCount = 0;
        Set<String> bannedWordsSet = new HashSet<>(Arrays.asList(bannedWords));
        for (String bannedWord : bannedWordsSet) {
            seenCount += seen.getOrDefault(bannedWord, 0);
        }

        return seenCount >= 2;
    }
}