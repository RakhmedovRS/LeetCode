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

/**
 * @author RakhmedovRS
 * @created 29-Mar-20
 */
public class Collector
{
	public static void main(String[] args) throws Exception
	{
		List<Map.Entry<LeetCode, String>> annotations =
			Files.list(Paths.get(Paths.get("").toAbsolutePath().toString() + "\\src\\main\\java"))
				.map(path ->
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
			osw.write(String.format("### This file was created automatically by [%s.java](https://github.com/RakhmedovRS/LeetCode/tree/master/src/main/java/common/%s.java)\n",
				Collector.class.getSimpleName(), Collector.class.getSimpleName()));
			osw.write("| LeetCode ID        | Name           | Solution       |\n");
			osw.write("| :-----------------:|:--------------:|:--------------:|\n");

			annotations.forEach(entry ->
			{
				try
				{
					String url = String.format("[%s.java](https://github.com/RakhmedovRS/LeetCode/tree/master/src/main/java/%s.java)", entry.getValue(), entry.getValue());
					LeetCode leetCode = entry.getKey();
					osw.write(String.format("|%d|[%s](%s)|%s\n", leetCode.id(), leetCode.name(), leetCode.url(), url));
				}
				catch (Exception ignore)
				{

				}
			});
		}
	}
}
