package helper;


import common.Difficulty;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ruslan Rakhmedov
 * @created 12/23/2023
 */
public class TaskInfoHelper {

	private static class LeetCodeTask {
		private final String className;
		private final String annotation;

		public LeetCodeTask(String className, String annotation) {
			this.className = className;
			this.annotation = annotation;
		}

		public String getClassName() {
			return className;
		}

		public String getAnnotation() {
			return annotation;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter task's urls using comma as separator");
		String urls = myObj.nextLine();
		for (LeetCodeTask leetCodeTask : processUrls(Arrays.asList(urls.split(",")))) {
			createFile(leetCodeTask.getClassName(), leetCodeTask.getAnnotation());
		}
		System.out.println("All objects got generated successfully");
	}

	private static void createFile(String fileName, String leetCodeAnnotation) throws IOException {
		Path path = Paths.get(String.format("src\\main\\java\\tasks/%s.java", fileName));
		File outputFile = path.toAbsolutePath().toFile();
		if (outputFile.createNewFile()) {
			fillInFile(outputFile, fileName, leetCodeAnnotation);
		}
	}

	private static void fillInFile(File outputFile, String fileAndClassName, String leetCodeAnnotation) throws IOException {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
			bufferedWriter.write("package tasks;");
			bufferedWriter.write("import common.Difficulty;");
			bufferedWriter.write("import common.LeetCode;");
			bufferedWriter.newLine();
			bufferedWriter.write(prepareCommentForClass());
			bufferedWriter.newLine();
			bufferedWriter.write(leetCodeAnnotation);
			bufferedWriter.newLine();
			bufferedWriter.write(String.format("public class %s {}", fileAndClassName));
			bufferedWriter.flush();
		}
	}

	private static List<LeetCodeTask> processUrls(List<String> urls) {
		List<LeetCodeTask> output = new ArrayList<>();
		urls.forEach(questionUrl -> {
			String pageContent = getPageContent(questionUrl);
			String questionId = substractQuestionId(pageContent);
			String questionName = substractQuestionName(pageContent);
			Difficulty questionDifficulty = substractQuestionDifficulty(pageContent);
			LeetCodeTask leetCodeTask = new LeetCodeTask(
					prepareClassName(questionName),
					String.format("@LeetCode(%sid = %s,%s name = \"%s\",%s url = \"%s\",%s difficulty = %s%s)",
							System.lineSeparator(),
							questionId,
							System.lineSeparator(),
							questionName,
							System.lineSeparator(),
							questionUrl,
							System.lineSeparator(),
							Difficulty.class.getSimpleName() + "." + questionDifficulty,
							System.lineSeparator())
			);

			output.add(leetCodeTask);
		});

		return output;
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
		} catch (Exception ex) {
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

	private static String prepareClassName(String questionName) {
		questionName = questionName.replace(" a ", " ");
		StringBuilder sb = new StringBuilder();
		for (String sub : questionName.split(" ")) {
			char[] chars = sub.toCharArray();
			chars[0] = Character.toUpperCase(chars[0]);
			sb.append(chars);
		}

		return sb.toString();
	}

	private static String prepareCommentForClass() {
		return String.format("/**\n" +
				" * @author Ruslan Rakhmedov\n" +
				" * @created %s\n" +
				" */", LocalDate.now().toString());
	}
}
