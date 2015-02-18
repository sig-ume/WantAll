/**
 *
 */
package jp.sigre.WantAll.gui.text;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.PrintStream;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author sigre
 *
 */
public class ConsolePanel extends JPanel {

	public ConsolePanel() {
		this.setLayout(null);
		this.setSize(420,150);

		JTextArea area = new JTextArea(20,10);
        //area.setEditable(false);  // ReadOnly に
		//area.setPreferredSize(new Dimension(380, 180));
        JTextAreaStream stream = new JTextAreaStream(area);
        PrintStream out = new PrintStream(stream, true);
        System.setOut(out);    // true は AutoFlush の設定
        System.setErr(out);

        JScrollPane sp = new JScrollPane(area);
		sp.setPreferredSize(new Dimension(420, 140));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.add(sp);

	}

}
