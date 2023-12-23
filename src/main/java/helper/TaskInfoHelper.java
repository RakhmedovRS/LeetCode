package helper;


import common.Difficulty;

import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ruslan Rakhmedov
 * @created 12/23/2023
 */
public class TaskInfoHelper {


	public static void main(String[] args) {
		processUls(Arrays.asList(
				"https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i/"
		));
	}


	private static void processUls(List<String> urls) {
		urls.forEach(questionUrl -> {
			String pageContent = getPageContent(questionUrl);
			String questionId = substractQuestionId(pageContent);
			String questionName = substractQuestionName(pageContent);
			Difficulty questionDifficulty = substractQuestionDifficulty(pageContent);
			System.out.printf("%s@LeetCode(%sid = %s,%s name = \"%s\",%s url = \"%s\",%s difficulty = %s%s)",
					System.lineSeparator(),
					System.lineSeparator(),
					questionId,
					System.lineSeparator(),
					questionName,
					System.lineSeparator(),
					questionUrl,
					System.lineSeparator(),
					Difficulty.class.getSimpleName() + "." + questionDifficulty,
					System.lineSeparator());
		});
	}

	private static String getPageContent(String url) {
		String content = "";
		URLConnection connection;
		try {
			connection = new URL(url).openConnection();
			Scanner scanner = new Scanner(connection.getInputStream());
			scanner.useDelimiter(System.lineSeparator());
			content = scanner.next();
			scanner.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

		return content;
	}

	private static String substractQuestionId(String pageContent) {
		String questionIdFieldName = "\"questionFrontendId\":\"";
		int startPosition = pageContent.indexOf(questionIdFieldName) + questionIdFieldName.length();
		int endPosition = pageContent.indexOf("\"", startPosition + 1);
		return pageContent.substring(startPosition, endPosition);
	}

	private static String substractQuestionName(String pageContent) {
		String questionTitleFieldName = "\"questionTitle\":\"";
		int startPosition = pageContent.indexOf(questionTitleFieldName) + questionTitleFieldName.length();
		int endPosition = pageContent.indexOf("\"", startPosition + 1);
		return pageContent.substring(startPosition, endPosition);
	}

	private static Difficulty substractQuestionDifficulty(String pageContent) {
		String questionDifficultyFieldName = "\"difficulty\":\"";
		int startPosition = pageContent.indexOf(questionDifficultyFieldName) + questionDifficultyFieldName.length();
		int endPosition = pageContent.indexOf("\"", startPosition + 1);
		return Difficulty.getByName(pageContent.substring(startPosition, endPosition));
	}
}
