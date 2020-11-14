package common;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author RakhmedovRS
 * @created 29-Mar-20
 */
public class Collector
{
	private static final String HEADER = "| LeetCode ID        | Difficulty     | Name           | Solution       |";
	private static final String LINE = "| :-----------------:|:--------------:|:--------------:|:--------------:|";
	private static final String GENERAL_INFO_PATTERN = "### This file was created automatically by [%s.java](https://github.com/RakhmedovRS/LeetCode/tree/master/src/main/java/common/%s.java)";
	private static final String GENERAL_PATTERN = "|%d|%s|[%s](%s)|%s";
	private static final String URL_PATTERN = "[%s.java](https://github.com/RakhmedovRS/LeetCode/tree/master/src/main/java/%s.java)";

	public static void main(String[] args) throws Exception
	{
		try (Stream<Path> pathStream = Files.list(Paths.get(Paths.get("").toAbsolutePath().toString() + "\\src\\main\\java")))
		{
			List<Map.Entry<LeetCode, String>> annotations =
				pathStream.map(path ->
				{
					try
					{
						return Class.forName(path.getFileName().toString().replaceAll(".java", ""));
					}
					catch (Exception ignore)
					{
						return null;
					}
				})
					.filter(clazz -> clazz != null && clazz.isAnnotationPresent(LeetCode.class))
					.map(clazz -> new AbstractMap.SimpleEntry<>(clazz.getAnnotation(LeetCode.class), clazz.getName()))
					.sorted(Comparator.comparingInt(entry -> entry.getKey().id()))
					.collect(Collectors.toList());

			Path output = Paths.get(Paths.get("").toAbsolutePath().toString() + "\\README.MD");
			try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(output.toFile()));)
			{
				osw.write(preprocess("![Logo](https://github.com/RakhmedovRS/LeetCode/blob/master/src/main/resources/LeetCodeLogo.png"));
				osw.write(preprocess(String.format(GENERAL_INFO_PATTERN, Collector.class.getSimpleName(), Collector.class.getSimpleName())));
				osw.write(preprocess(String.format("Count of solved tasks: %s", annotations.size())));
				osw.write(preprocess("<details>"));
				osw.write(preprocess("<summary>Table of all solved tasks</summary>"));
				osw.write(preprocess("<p>"));
				osw.write(System.lineSeparator());
				osw.write(preprocess(HEADER));
				osw.write(preprocess(LINE));

				String table = annotations
					.stream()
					.map(entry ->
					{
						try
						{
							String url = String.format(URL_PATTERN, entry.getValue(), entry.getValue());
							LeetCode leetCode = entry.getKey();
							return String.format(GENERAL_PATTERN, leetCode.id(), leetCode.difficulty().name, leetCode.name(), leetCode.url(), url);
						}
						catch (Exception ignore)
						{
							return "";
						}
					})
					.collect(Collectors.joining(System.lineSeparator()));

				osw.write(table);
				osw.write(preprocess("</p>"));
				osw.write(preprocess("</details>"));
			}
		}
	}

	private static String preprocess(String string)
	{
		return string + System.lineSeparator();
	}
}
