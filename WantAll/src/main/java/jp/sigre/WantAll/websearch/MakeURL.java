package jp.sigre.WantAll.websearch;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class MakeURL {

	/**
	 * 検索条件に従ったURLを生成する。
	 * @param str
	 * @return strを検索するためのURL
	 */
	public URI generateGoogleUri(List<String> wordList) {
		String searchWord = makeWordListToStr(wordList);
		URI uri = generateGoogleUri(searchWord);

		return uri;
	}

	/**
	 * 検索条件に従ったURLを生成する。
	 * @param str
	 * @return strを検索するためのURL
	 */
	public URI generateGoogleUri(String searchWord) {
		String http = createGoogleURIStr(searchWord);
		System.out.println(searchWord);
		URI uri = null;
		try {
			uri = new URI(http);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return uri;
	}

	private String createGoogleURIStr(String searchWord) {
		String https = "https://www.google.co.jp/search?q=";
		String param = "&ie=utf-8&oe=utf-8&hl=ja";

		return https + searchWord + param;
	}


//	private String createGoogleURIStr(List<String> wordList) {
//		String searchWord = makeWordListToStr(wordList);
//		return createGoogleURIStr(searchWord);
//	}
//
//	private String googleURIStrWithTorrent(List<String> wordList) {
//		wordList.add("torrent");
//		return createGoogleURIStr(wordList);
//	}

	private String makeWordListToStr(List<String> wordList) {
		String searchWord = wordList.get(0);
		int size = wordList.size();
		for (int i = 1; i < size; i++) {
			searchWord += "+";
			searchWord += wordList.get(i);
		}

		return searchWord;
	}

}
