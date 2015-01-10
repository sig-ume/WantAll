package jp.sigre.WantAll.websearch;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CallBrowserTest {

	CallBrowser callBrowser = new CallBrowser();

	@Test
	public void callTest() throws URISyntaxException {
		URI uri = new URI("https://www.google.co.jp/search?q=test+test1+test2&ie=utf-8&oe=utf-8&hl=ja");
		assertThat(callBrowser.call(uri), is(true));
	}

	@Test
	public void callGoogleTest1() {
		List<String> wordList = new ArrayList<String>();
		wordList.add("test");
		wordList.add("test1");
		wordList.add("test2");

		assertThat(callBrowser.callGoogle(wordList), is(true));
	}

}
