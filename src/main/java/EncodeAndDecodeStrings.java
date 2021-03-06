import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 1/8/2021
 */
@LeetCode(
	id = 271,
	name = "Encode and Decode Strings",
	url = "https://leetcode.com/problems/encode-and-decode-strings/",
	difficulty = Difficulty.MEDIUM,
	premium = true
)
public class EncodeAndDecodeStrings
{
	public class Codec
	{
		private String charSeparator = "-";
		private String beginAndEndMark = "_";
		private String wordSeparator = "&";
		private String emptyList = "E";

		// Encodes a list of strings to a single string.
		public String encode(List<String> strs)
		{
			if (strs.isEmpty())
			{
				return emptyList;
			}

			List<String> encodedWords = new ArrayList<>();
			List<String> chars;
			for (String string : strs)
			{
				chars = new ArrayList<>();
				for (char ch : string.toCharArray())
				{
					chars.add(String.valueOf((int) ch));
				}

				encodedWords.add(beginAndEndMark + String.join(charSeparator, chars) + beginAndEndMark);
			}

			return String.join(wordSeparator, encodedWords);
		}

		// Decodes a single string to a list of strings.
		public List<String> decode(String s)
		{
			List<String> decoded = new ArrayList<>();
			if (s.equals(emptyList))
			{
				return decoded;
			}

			String[] encodedWords = s.split(wordSeparator);
			String[] encodedChars;
			StringBuilder decodedWord;
			for (String encodedWord : encodedWords)
			{
				decodedWord = new StringBuilder();
				if (encodedWord.length() > 2)
				{
					encodedWord = encodedWord.substring(1, encodedWord.length() - 1);
					encodedChars = encodedWord.split(charSeparator);
					for (String encodedChar : encodedChars)
					{
						decodedWord.append((char) Integer.parseInt(encodedChar));
					}
				}

				decoded.add(decodedWord.toString());
			}

			return decoded;
		}
	}

	public static void main(String[] args)
	{
		Codec codec = new EncodeAndDecodeStrings().new Codec();
		String encoded = codec.encode(Arrays.asList(" ", ""));
		List<String> decoded = codec.decode(encoded);

		System.out.println(encoded);
		System.out.println(decoded);
	}
}
