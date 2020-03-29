package common;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author RakhmedovRS
 * @created 29-Mar-20
 */
public class Collector
{
	public static void main(String[] args) throws Exception
	{
		List<LeetCode> annotations =
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
				.map(clazz -> clazz.getAnnotation(LeetCode.class))
				.sorted(Comparator.comparingInt(LeetCode::id))
				.collect(Collectors.toList());

		Path output = Paths.get(Paths.get("").toAbsolutePath().toString() + "\\README.MD");
		try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(output.toFile()));)
		{
			annotations.forEach(leetCode ->
			{
				try
				{
					osw.write(String.format("LeetCode %d.  [%s](%s)\n", leetCode.id(), leetCode.name(), leetCode.url()));
				}
				catch (Exception ignore)
				{

				}
			});
		}
	}
}
