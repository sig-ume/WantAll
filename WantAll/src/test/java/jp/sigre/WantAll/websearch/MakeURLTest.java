package jp.sigre.WantAll.websearch;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MakeURLTest extends TestCase {

	@Test
	public void generateGoogleUriTest1() throws URISyntaxException {
		List<String> strList = new ArrayList<String>();
		strList.add("test");
		strList.add("test1");
		strList.add("test2");
		System.out.println(strList.toString());

		URI expected = new URI("https://www.google.co.jp/search?q=test+test1+test2&ie=utf-8&oe=utf-8&hl=ja");
		URI actual   = new MakeURL().generateGoogleUri(strList);
		System.out.println(strList.toString());
		System.out.println(actual);
		assertThat(actual, is(expected));
	}

//    @Test
//    public void testOne() {
//        String str = "りんご";
//        assertEquals(str.charAt(0), 'り');
//    }
}
