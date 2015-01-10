package jp.sigre.WantAll.websearch;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.List;

/**
 * @author sigre
 *
 */
public class CallBrowser {

	/**
	 * wordListを検索条件としてブラウザにGoogle検索画面を開く
	 * @param wordList
	 * @return
	 */
	public boolean callGoogle(List<String> wordList) {
		URI uri = new MakeURL().generateGoogleUri(wordList);
		return call(uri);
	}

	public boolean call(URI uri) {
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.browse(uri);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

