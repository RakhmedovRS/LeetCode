package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 12/5/2020
 */
@LeetCode(
		id = 1166,
		name = "Design File System",
		url = "https://leetcode.com/problems/design-file-system/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class DesignFileSystem {
	class Path {
		int value;
		Map<String, Path> data;

		public Path() {
			value = -1;
			data = new HashMap<>();
		}

		Path getChild(String name) {
			return data.get(name);
		}

		public Map<String, Path> getData() {
			return data;
		}
	}

	class FileSystem {
		Path root;

		public FileSystem() {
			root = new Path();
		}

		public boolean createPath(String path, int value) {
			String[] paths = path.split("/");
			Path current = root;
			for (int i = 1; i < paths.length - 1; i++) {
				if (current == null) {
					return false;
				}

				current = current.getChild(paths[i]);
			}

			String name = paths[paths.length - 1];

			if (current == null || current.getChild(name) != null) {
				return false;
			}

			Path newPath = new Path();
			newPath.value = value;
			current.getData().put(name, newPath);
			return true;
		}

		public int get(String path) {
			String[] paths = path.split("/");
			Path current = root;
			for (int i = 1; i < paths.length; i++) {
				if (current == null) {
					return -1;
				}

				current = current.getChild(paths[i]);
			}

			if (current == null) {
				return -1;
			}

			return current.value;
		}
	}

	public static void main(String[] args) {
		FileSystem fs = new DesignFileSystem().new FileSystem();
		System.out.println(fs.createPath("/leet", 1));
		System.out.println(fs.createPath("/leet/code", 2));
		System.out.println(fs.get("/leet/code"));
		System.out.println(fs.createPath("/c/d", 1));
		System.out.println(fs.get("/c"));

		System.out.println();

		fs = new DesignFileSystem().new FileSystem();
		System.out.println(fs.createPath("/a", 1));
		System.out.println(fs.get("/a"));
	}
}
