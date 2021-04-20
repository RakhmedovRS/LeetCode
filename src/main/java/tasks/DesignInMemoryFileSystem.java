package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/5/2020
 */
@LeetCode(
	id = 588,
	name = "Design In-Memory File System",
	url = "https://leetcode.com/problems/design-in-memory-file-system/",
	difficulty = Difficulty.HARD,
	premium = true
)
public class DesignInMemoryFileSystem
{
	interface Entry
	{
		boolean isFile();

		String getName();

		String getContent();

		Entry getChild(String name);

		Map<String, Entry> getData();

		void append(String data);
	}

	class Path implements Entry
	{
		TreeMap<String, Entry> data;
		String name;

		public Path(String name)
		{
			this.name = name;
			data = new TreeMap<>();
		}

		@Override
		public boolean isFile()
		{
			return false;
		}

		@Override
		public String getName()
		{
			return name;
		}

		@Override
		public String getContent()
		{
			return null;
		}

		@Override
		public Entry getChild(String name)
		{
			return data.get(name);
		}

		@Override
		public Map<String, Entry> getData()
		{
			return data;
		}

		@Override
		public void append(String data)
		{

		}
	}

	class File implements Entry
	{
		String name;
		StringBuilder content;

		public File(String name)
		{
			this.name = name;
			content = new StringBuilder();
		}

		@Override
		public boolean isFile()
		{
			return true;
		}

		@Override
		public String getName()
		{
			return name;
		}

		@Override
		public String getContent()
		{
			return content.toString();
		}

		@Override
		public Entry getChild(String name)
		{
			return null;
		}

		@Override
		public Map<String, Entry> getData()
		{
			return null;
		}

		@Override
		public void append(String data)
		{
			content.append(data);
		}
	}

	class FileSystem
	{
		Entry root;

		public FileSystem()
		{
			root = new Path("/");
		}

		public List<String> ls(String path)
		{
			String[] paths = path.split("/");
			Entry current = root;
			for (String p : paths)
			{
				if (p.isEmpty())
				{
					continue;
				}
				current = current.getChild(p);
			}

			if (current.isFile())
			{
				return Arrays.asList(current.getName());
			}
			else
			{
				return new ArrayList<>(current.getData().keySet());
			}
		}

		public void mkdir(String path)
		{
			String[] paths = path.split("/");
			Entry current = root;
			for (String p : paths)
			{
				if (p.isEmpty())
				{
					continue;
				}
				if (current.getChild(p) == null)
				{
					current.getData().put(p, new Path(p));
				}

				current = current.getChild(p);
			}
		}

		public void addContentToFile(String filePath, String content)
		{
			String[] paths = filePath.split("/");
			Entry current = root;
			for (int i = 0; i < paths.length - 1; i++)
			{
				if (paths[i].isEmpty())
				{
					continue;
				}
				if (current.getChild(paths[i]) == null)
				{
					current.getData().put(paths[i], new Path(paths[i]));
				}

				current = current.getChild(paths[i]);
			}

			current.append(content);

			String fileName = paths[paths.length - 1];
			if (current.getChild(fileName) == null)
			{

				current.getData().put(fileName, new File(fileName));
			}

			current.getChild(fileName).append(content);
		}

		public String readContentFromFile(String filePath)
		{
			String[] paths = filePath.split("/");
			Entry current = root;
			for (String p : paths)
			{
				if (p.isEmpty())
				{
					continue;
				}
				current = current.getChild(p);
			}

			return current.getContent();
		}
	}

	public static void main(String[] args)
	{
		FileSystem fs = new DesignInMemoryFileSystem().new FileSystem();
		fs.ls("/");
		fs.mkdir("/a/b/c");
		fs.addContentToFile("/a/b/c/d", "hello");
		fs.ls("/");
		System.out.println(fs.readContentFromFile("/a/b/c/d"));
	}
}
