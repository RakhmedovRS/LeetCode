package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 12/10/2020
 */
@LeetCode(
	id = 1236,
	name = "Web Crawler",
	url = "https://leetcode.com/problems/web-crawler/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class WebCrawler
{
	interface HtmlParser
	{
		List<String> getUrls(String url);
	}

	public List<String> crawl(String startUrl, HtmlParser htmlParser)
	{
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(startUrl);

		String current;
		StringBuilder sb = new StringBuilder();
		for (int i = startUrl.contains("http://") ? 7 : 0; i < startUrl.length(); i++)
		{
			if (Character.isLetter(startUrl.charAt(i)) || startUrl.charAt(i) == '.')
			{
				sb.append(startUrl.charAt(i));
			}
			else
			{
				break;
			}
		}

		String hostName = sb.toString();
		while (!queue.isEmpty())
		{
			current = queue.remove();
			if (!current.contains(hostName) || !visited.add(current))
			{
				continue;
			}

			queue.addAll(htmlParser.getUrls(current));
		}

		return new ArrayList<>(visited);
	}

	public static void main(String[] args)
	{
		System.out.println(new WebCrawler().crawl("http://news.google.com",
			(url) -> Arrays.asList("http://news.yahoo.com/news/topics/", "http://news.yahoo.com/news", "http://news.yahoo.com", "http://news.google.com")));
	}
}
