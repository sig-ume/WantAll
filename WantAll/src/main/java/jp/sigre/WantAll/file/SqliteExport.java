/**
 *
 */
package jp.sigre.WantAll.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author sigre
 *
 */
public class SqliteExport {
	JFrame jFrame;
	public SqliteExport(JFrame frame) {
		jFrame = frame;
	}

	public void dialogExportFile() {
		JFileChooser filechooser = new JFileChooser("C:\\Users\\sigre\\git\\WantAll\\WantAll\\db");
		int selected = filechooser.showOpenDialog(jFrame);
		if (selected == JFileChooser.APPROVE_OPTION){
			File file = filechooser.getSelectedFile();
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			try (FileChannel outChannel = new FileOutputStream(file).getChannel();
					FileChannel inChannel = new FileInputStream(getSqliteFile()).getChannel();) {
				System.out.println(outChannel.isOpen() + " & " + inChannel.isOpen());
				if (outChannel.isOpen() && inChannel.isOpen()) {
					inChannel.transferTo(0, inChannel.size(), outChannel);
				} else {
					System.out.println(outChannel.isOpen() + " & " + inChannel.isOpen());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}else if (selected == JFileChooser.CANCEL_OPTION){
			//label.setText("キャンセルされました");
		}else if (selected == JFileChooser.ERROR_OPTION){
			//label.setText("エラー又は取消しがありました");
		}
	}

	private File getSqliteFile() {
		File file = new File("db/ProductInfo.db");

		return file;
	}

}
