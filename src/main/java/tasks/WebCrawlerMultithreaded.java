package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author RakhmedovRS
 * @created 12/18/2020
 */
@LeetCode(
	id = 1242,
	name = "Web Crawler Multithreaded",
	url = "https://leetcode.com/problems/web-crawler-multithreaded/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class WebCrawlerMultithreaded
{
	interface HtmlParser
	{
		List<String> getUrls(String url);
	}

	class HtmlParserImpl implements HtmlParser
	{
		Map<String, List<String>> map;

		public HtmlParserImpl()
		{
			map = new HashMap<>();
			map.put("http://news.google.com", Arrays.asList("http://news.yahoo.com/news",
				"http://news.yahoo.com/news/topics/",
				"http://news.google.com"));

			map.put("http://news.yahoo.com", Arrays.asList("http://news.yahoo.com/news/topics/"));
			map.put("http://news.yahoo.com/news/topics/", Arrays.asList("http://news.yahoo.com/news"));
		}

		@Override
		public List<String> getUrls(String url)
		{
			return map.get(url);
		}
	}

	public List<String> crawl(String startUrl, HtmlParser htmlParser)
	{
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

		Set<String> visited = Collections.synchronizedSet(new HashSet<>());
		visited.add(startUrl);

		return crawl(hostName, startUrl, htmlParser, visited).collect(Collectors.toList());
	}

	private Stream<String> crawl(String hostName, String startURL, HtmlParser htmlParser, Set<String> visited)
	{
		Stream<String> stream = htmlParser
			.getUrls(startURL)
			.parallelStream()
			.filter(url -> url.contains(hostName))
			.filter(visited::add)
			.flatMap(url -> crawl(hostName, url, htmlParser, visited));

		return Stream.concat(Stream.of(startURL), stream);
	}
}
