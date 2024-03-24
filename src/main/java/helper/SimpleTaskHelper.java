package helper;

import common.Difficulty;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Ruslan Rakhmedov
 * @created 3/23/2024
 */
public class SimpleTaskHelper {
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
		System.out.println("Enter task's number");
		String taskNumber = myObj.nextLine();
		System.out.println("Enter task's name");
		String taskName = myObj.nextLine();
		System.out.println("Enter task's difficulty");
		String taskDifficulty = myObj.nextLine().toUpperCase();
		System.out.println("Enter task's url");
		String taskUrl = myObj.nextLine();

		LeetCodeTask leetCodeTask = new LeetCodeTask(
				prepareClassName(taskName),
				String.format("@LeetCode(%sid = %s,%s name = \"%s\",%s url = \"%s\",%s difficulty = %s%s)",
						System.lineSeparator(),
						taskNumber,
						System.lineSeparator(),
						taskName,
						System.lineSeparator(),
						taskUrl,
						System.lineSeparator(),
						Difficulty.class.getSimpleName() + "." + taskDifficulty,
						System.lineSeparator())
		);

		createFile(leetCodeTask.getClassName(), leetCodeTask.getAnnotation());
	}

	private static String prepareClassName(String questionName) {
		questionName = questionName.replace(" a ", " ");
		questionName = questionName.replace("-", "");
		StringBuilder sb = new StringBuilder();
		for (String sub : questionName.split(" ")) {
			char[] chars = sub.toCharArray();
			chars[0] = Character.toUpperCase(chars[0]);
			sb.append(chars);
		}

		return sb.toString();
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
			bufferedWriter.write("package tasks;" + System.lineSeparator());
			bufferedWriter.write("import common.Difficulty;" + System.lineSeparator());
			bufferedWriter.write("import common.LeetCode;" + System.lineSeparator());
			bufferedWriter.write("import java.util.*;" + System.lineSeparator());
			bufferedWriter.newLine();
			bufferedWriter.write(prepareCommentForClass());
			bufferedWriter.newLine();
			bufferedWriter.write(leetCodeAnnotation);
			bufferedWriter.newLine();
			bufferedWriter.write(String.format("public class %s {}", fileAndClassName));
			bufferedWriter.flush();
		}
	}

	private static String prepareCommentForClass() {
		return String.format("/**\n" +
				" * @author Ruslan Rakhmedov\n" +
				" * @created %s\n" +
				" */", LocalDate.now());
	}
}
