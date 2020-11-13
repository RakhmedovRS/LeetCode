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
				osw.write(String.format("![Logo](https://github.com/RakhmedovRS/LeetCode/blob/master/src/main/resources/LeetCodeLogo.png)%s", System.lineSeparator()));
				osw.write(
					String.format("### This file was created automatically by [%s.java](https://github.com/RakhmedovRS/LeetCode/tree/master/src/main/java/common/%s.java)%s",
						Collector.class.getSimpleName(), Collector.class.getSimpleName(), System.lineSeparator()));
				osw.write(String.format("Count of solved tasks: %s", annotations.size() + System.lineSeparator()));
				osw.write(System.lineSeparator());
				osw.write("| LeetCode ID        | Name           | Solution       |" + System.lineSeparator());
				osw.write("| :-----------------:|:--------------:|:--------------:|" + System.lineSeparator());

				String table = annotations
					.stream()
					.map(entry ->
					{
						try
						{
							String url = String.format("[%s.java](https://github.com/RakhmedovRS/LeetCode/tree/master/src/main/java/%s.java)", entry.getValue(), entry.getValue());
							LeetCode leetCode = entry.getKey();
							return String.format("|%d|[%s](%s)|%s", leetCode.id(), leetCode.name(), leetCode.url(), url);
						}
						catch (Exception ignore)
						{
							return "";
						}
					})
					.collect(Collectors.joining(System.lineSeparator()));

				osw.write(table);
			}
		}
	}
}
