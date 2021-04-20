package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 09-Jun-20
 */
@LeetCode(id = 1472, name = "Design Browser History", url = "https://leetcode.com/problems/design-browser-history/")
public class DesignBrowserHistory
{
	class BrowserHistory
	{
		private class Link
		{
			private Link previous;
			private Link next;
			private String url;

			public Link(String url)
			{
				this.url = url;
			}
		}

		private Link current;

		public BrowserHistory(String homepage)
		{
			current = new Link(homepage);
		}

		public void visit(String url)
		{
			Link visit = new Link(url);
			visit.previous = current;
			current.next = visit;
			current = visit;
		}

		public String back(int steps)
		{
			while (current.previous != null && steps-- > 0)
			{
				current = current.previous;
			}

			return current.url;
		}

		public String forward(int steps)
		{
			while (current.next != null && steps-- > 0)
			{
				current = current.next;
			}

			return current.url;
		}
	}

	public static void main(String[] args)
	{
		BrowserHistory browserHistory = new DesignBrowserHistory().new BrowserHistory("leetcode.com");
		browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
		browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
		browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
		System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
		System.out.println(browserHistory.back(1));                   // You are in "facebook.com", move back to "google.com" return "google.com"
		System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
		browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
		System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
		System.out.println(browserHistory.back(2));                       // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
		System.out.println(browserHistory.back(7));                     // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
	}
}
