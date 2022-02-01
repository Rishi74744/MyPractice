package com.questions.leetcode.amazon.prep;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {

	class Codec {
		Map<String, String> urlMapShortUrl = new HashMap<>();

		public String encode(String longUrl) {
			StringBuilder tinyUrl = new StringBuilder("http://tinyurl.com/").append(getAlphaNumericString());
			urlMapShortUrl.put(tinyUrl.toString(), longUrl);
			return tinyUrl.toString();
		}

		public String decode(String shortUrl) {
			return urlMapShortUrl.get(shortUrl);
		}

		public String getAlphaNumericString() {
			String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
			StringBuilder randomString = new StringBuilder(7);
			for (int i = 0; i < 7; i++) {
				int index = (int) (alphaNumericString.length() * Math.random());
				randomString.append(alphaNumericString.charAt(index));
			}
			return randomString.toString();
		}
	}

}
