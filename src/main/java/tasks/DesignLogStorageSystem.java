package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author RakhmedovRS
 * @created 5/18/2021
 */
@LeetCode(
		id = 635,
		name = "Design Log Storage System",
		url = "https://leetcode.com/problems/design-log-storage-system/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class DesignLogStorageSystem {
	class LogSystem {

		class Log implements Comparable<Log> {
			int year;
			int month;
			int day;
			int hour;
			int minute;
			int second;

			public Log(int year, int month, int day, int hour, int minute, int second) {
				this.year = year;
				this.month = month;
				this.day = day;
				this.hour = hour;
				this.minute = minute;
				this.second = second;
			}

			@Override
			public int compareTo(Log o) {
				if (year == o.year) {
					if (month == o.month) {
						if (day == o.day) {
							if (hour == o.hour) {
								if (minute == o.minute) {
									return second - o.second;
								}
								else {
									return minute - o.minute;
								}
							}
							else {
								return hour - o.hour;
							}
						}
						else {
							return day - o.day;
						}
					}
					else {
						return month - o.month;
					}
				}
				else {
					return year - o.year;
				}
			}
		}

		TreeMap<Log, List<Integer>> logs;

		public LogSystem() {
			logs = new TreeMap<>();
		}

		public void put(int id, String timestamp) {
			Log log = parseLog(timestamp);

			logs.putIfAbsent(log, new ArrayList<>());
			logs.get(log).add(id);
		}

		public List<Integer> retrieve(String start, String end, String granularity) {
			List<Integer> ids = new ArrayList<>();

			Log startLog = parseLog(start);
			Log endLog = parseLog(end);

			switch (granularity) {
				case "Year": {
					startLog.month = 0;
					startLog.day = 0;
					startLog.hour = 0;
					startLog.minute = 0;
					startLog.second = 0;

					endLog.month = 12;
					endLog.day = 31;
					endLog.hour = 23;
					endLog.minute = 59;
					endLog.second = 59;

					break;
				}
				case "Month": {
					startLog.day = 0;
					startLog.hour = 0;
					startLog.minute = 0;
					startLog.second = 0;

					endLog.day = 31;
					endLog.hour = 23;
					endLog.minute = 59;
					endLog.second = 59;

					break;
				}
				case "Day": {
					startLog.hour = 0;
					startLog.minute = 0;
					startLog.second = 0;

					endLog.hour = 23;
					endLog.minute = 59;
					endLog.second = 59;

					break;
				}

				case "Hour": {
					startLog.minute = 0;
					startLog.second = 0;

					endLog.minute = 59;
					endLog.second = 59;
					break;
				}

				case "Minute": {
					startLog.second = 0;

					endLog.second = 59;
					break;
				}
			}

			for (List<Integer> idsList : logs.tailMap(startLog, true).headMap(endLog, true).values()) {
				ids.addAll(idsList);
			}

			return ids;
		}

		private Log parseLog(String timestamp) {
			String[] parts = timestamp.split(":");

			return new Log(
					Integer.parseInt(parts[0]),
					Integer.parseInt(parts[1]),
					Integer.parseInt(parts[2]),
					Integer.parseInt(parts[3]),
					Integer.parseInt(parts[4]),
					Integer.parseInt(parts[5])
			);
		}
	}
}
