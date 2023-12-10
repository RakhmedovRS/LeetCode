package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 3/20/2021
 */
@LeetCode(
		id = 1797,
		name = "Design Authentication Manager",
		url = "https://leetcode.com/problems/design-authentication-manager/",
		difficulty = Difficulty.MEDIUM
)
public class DesignAuthenticationManager {
	class AuthenticationManager {
		int timeToLive;
		Map<String, Integer> tokenToExpireTime;
		TreeSet<String> expireTime;

		public AuthenticationManager(int timeToLive) {
			this.timeToLive = timeToLive;
			tokenToExpireTime = new HashMap<>();
			expireTime = new TreeSet<>(Comparator.comparingInt(a -> tokenToExpireTime.get(a)));
		}

		public void generate(String tokenId, int currentTime) {
			if (tokenToExpireTime.containsKey(tokenId)) {
				expireTime.remove(tokenId);
			}

			tokenToExpireTime.put(tokenId, currentTime + timeToLive);
			expireTime.add(tokenId);
		}

		public void renew(String tokenId, int currentTime) {
			while (!expireTime.isEmpty() && tokenToExpireTime.get(expireTime.first()) <= currentTime) {
				String token = expireTime.first();
				expireTime.remove(token);
				tokenToExpireTime.remove(token);
			}

			if (tokenToExpireTime.containsKey(tokenId)) {
				expireTime.remove(tokenId);
				tokenToExpireTime.put(tokenId, currentTime + timeToLive);
				expireTime.add(tokenId);
			}
		}

		public int countUnexpiredTokens(int currentTime) {
			while (!expireTime.isEmpty() && tokenToExpireTime.get(expireTime.first()) <= currentTime) {
				String token = expireTime.first();
				expireTime.remove(token);
				tokenToExpireTime.remove(token);
			}

			return expireTime.size();
		}
	}

	public static void main(String[] args) {
		DesignAuthenticationManager clazz = new DesignAuthenticationManager();

		AuthenticationManager authenticationManager = clazz.new AuthenticationManager(444);
		authenticationManager.generate("jvkl", 16);
		System.out.println(authenticationManager.countUnexpiredTokens(41));
		System.out.println(authenticationManager.countUnexpiredTokens(53));
		authenticationManager.renew("qvgq", 88);
		System.out.println(authenticationManager.countUnexpiredTokens(101));
		System.out.println(authenticationManager.countUnexpiredTokens(119));
		System.out.println(authenticationManager.countUnexpiredTokens(126));
		System.out.println(authenticationManager.countUnexpiredTokens(137));
		authenticationManager.generate("nesq", 150);
		System.out.println(authenticationManager.countUnexpiredTokens(161));
		System.out.println(authenticationManager.countUnexpiredTokens(161));
		authenticationManager.renew("ix", 179);
		System.out.println(authenticationManager.countUnexpiredTokens(181));
		System.out.println(authenticationManager.countUnexpiredTokens(185));
		authenticationManager.renew("kh", 195);
		authenticationManager.renew("rk", 196);
		System.out.println(authenticationManager.countUnexpiredTokens(197));
		authenticationManager.generate("rrbox", 207);
		System.out.println(authenticationManager.countUnexpiredTokens(218));
		authenticationManager.generate("wpqr", 240);
		authenticationManager.renew("prj", 274);
		System.out.println(authenticationManager.countUnexpiredTokens(296));
		System.out.println(authenticationManager.countUnexpiredTokens(298));
		System.out.println(authenticationManager.countUnexpiredTokens(320));
		System.out.println(authenticationManager.countUnexpiredTokens(336));
		authenticationManager.renew("d", 339);
		authenticationManager.renew("z", 343);
		authenticationManager.renew("ri", 354);
		authenticationManager.generate("fkpk", 404);
		System.out.println(authenticationManager.countUnexpiredTokens(429));
		authenticationManager.renew("ix", 434);
		authenticationManager.renew("ytqq", 506);
		authenticationManager.generate("fqlu", 519);
		System.out.println(authenticationManager.countUnexpiredTokens(562));
		authenticationManager.generate("wxmcw", 578);
		System.out.println(authenticationManager.countUnexpiredTokens(594));
		System.out.println(authenticationManager.countUnexpiredTokens(619));
		authenticationManager.generate("iz", 623);
		authenticationManager.generate("zaqb", 629);
		authenticationManager.renew("ugxe", 640);
		System.out.println(authenticationManager.countUnexpiredTokens(664));
		authenticationManager.generate("smeb", 665);
		authenticationManager.renew("z", 673);
		authenticationManager.renew("rihj", 674);
		authenticationManager.renew("qikse", 717);
		authenticationManager.generate("rnizc", 735);
		authenticationManager.generate("ugxe", 791);
		System.out.println(authenticationManager.countUnexpiredTokens(803));
		System.out.println(authenticationManager.countUnexpiredTokens(815));
		authenticationManager.generate("jnofa", 851);
		authenticationManager.renew("ryp", 857);
		authenticationManager.renew("jvkl", 862);
		authenticationManager.generate("l", 863);
		System.out.println(authenticationManager.countUnexpiredTokens(871));
		System.out.println(authenticationManager.countUnexpiredTokens(873));
		authenticationManager.renew("ugxe", 875);
		System.out.println(authenticationManager.countUnexpiredTokens(902));
		System.out.println(authenticationManager.countUnexpiredTokens(913));
		System.out.println(authenticationManager.countUnexpiredTokens(979));
		authenticationManager.generate("dqad", 984);

		authenticationManager = clazz.new AuthenticationManager(5);
		authenticationManager.renew("aaa", 1);
		authenticationManager.generate("aaa", 2);
		System.out.println(authenticationManager.countUnexpiredTokens(6));
		authenticationManager.generate("aaa", 8);
		authenticationManager.renew("bbb", 10);
		System.out.println(authenticationManager.countUnexpiredTokens(15));
	}
}
