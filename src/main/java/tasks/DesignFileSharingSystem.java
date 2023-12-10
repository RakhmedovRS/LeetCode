package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @since 12.03.2021
 */
@LeetCode(
		id = 1500,
		name = "Design a File Sharing System",
		url = "https://leetcode.com/problems/design-a-file-sharing-system/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class DesignFileSharingSystem {
	class FileSharing {
		PriorityQueue<Integer> ids;
		Map<Integer, Set<Integer>> userToChunks;
		Map<Integer, Set<Integer>> chunkToUsers;

		public FileSharing(int m) {
			ids = new PriorityQueue<>();
			ids.add(1);

			userToChunks = new HashMap<>();
			chunkToUsers = new HashMap<>();
		}

		public int join(List<Integer> ownedChunks) {
			int id = ids.remove();
			if (ids.isEmpty()) {
				ids.add(id + 1);
			}

			Set<Integer> set = userToChunks.getOrDefault(id, new HashSet<>());
			set.addAll(ownedChunks);
			userToChunks.put(id, set);
			for (int chunk : ownedChunks) {
				chunkToUsers.putIfAbsent(chunk, new TreeSet<>());
				chunkToUsers.get(chunk).add(id);
			}

			return id;
		}

		public void leave(int userID) {
			ids.add(userID);
			for (int chunk : userToChunks.remove(userID)) {
				chunkToUsers.get(chunk).remove(userID);
			}
		}

		public List<Integer> request(int userID, int chunkID) {
			Set<Integer> set = chunkToUsers.getOrDefault(chunkID, Collections.emptySet());
			if (!set.isEmpty()) {
				List<Integer> list = new ArrayList<>(set);
				set.add(userID);
				userToChunks.putIfAbsent(userID, new HashSet<>());
				userToChunks.get(userID).add(chunkID);
				return list;
			}

			return new ArrayList<>(set);
		}
	}

	public static void main(String[] args) {
		DesignFileSharingSystem clazz = new DesignFileSharingSystem();
		FileSharing fileSharing = clazz.new FileSharing(17);
		System.out.println(fileSharing.join(Arrays.asList())); //1
		System.out.println(fileSharing.join(Arrays.asList(6, 8, 7, 15, 16, 9, 10, 4, 13, 12, 5, 14, 1, 11, 2, 17, 3))); //2
		System.out.println(fileSharing.join(Arrays.asList(9, 11, 14, 16, 10, 6, 1, 15, 12))); //3
		System.out.println(fileSharing.join(Arrays.asList())); //4
		System.out.println(fileSharing.join(Arrays.asList(17, 10, 16))); //5

		System.out.println(fileSharing.request(1, 6)); //[2,3]
		System.out.println(fileSharing.request(1, 1)); //[2,3]
		System.out.println(fileSharing.request(1, 3)); //[2]
		System.out.println(fileSharing.request(5, 15)); //[2,3]
		System.out.println(fileSharing.request(3, 5)); //[2]
		System.out.println(fileSharing.request(2, 5)); //[2,3]
		System.out.println(fileSharing.request(1, 4)); //[2]
		System.out.println(fileSharing.request(1, 7)); //[2]
		System.out.println(fileSharing.request(2, 15)); //[2,3,5]
		System.out.println(fileSharing.request(3, 5)); //[2,3]
		System.out.println(fileSharing.request(2, 1)); //[1,2,3]
	}
}
