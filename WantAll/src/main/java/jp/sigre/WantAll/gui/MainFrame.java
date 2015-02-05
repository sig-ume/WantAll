/**
 *
 */
package jp.sigre.WantAll.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import jp.sigre.WantAll.gui.panel.FlagChangeListPanel;
import jp.sigre.WantAll.gui.panel.InfoDeleteListPanel;
import jp.sigre.WantAll.gui.panel.WantAllControlPanel;
import jp.sigre.WantAll.gui.panel.WantAllListPanel;

/**
 * @author sigre
 *
 */
public class MainFrame extends JFrame {

	public String[] PanelNames = {"main","Sub1","Sub2","Sub3"};
	//WantAllPanel wantAllPanel = new WantAllPanel(this, "main");
	WantAllListPanel wantAllPanel = new WantAllListPanel();
	WantAllControlPanel wantAllCtrl = new WantAllControlPanel(wantAllPanel);
	FlagChangeListPanel flagChangePanel = new FlagChangeListPanel();
	InfoDeleteListPanel infoDeletePanel = new InfoDeleteListPanel();

	JMenuItem mntmWantall;
	JMenuItem mntmInfodelete;

	public MainFrame(){
		this.setBounds(100, 100, 492, 400);

		//this.add(wantAllPanel);wantAllPanel.setVisible(true);
		getContentPane().add(wantAllPanel, BorderLayout.NORTH);
		wantAllPanel.setVisible(true);
		//this.add(wantAllCtrl);wantAllCtrl.setVisible(true);
		getContentPane().add(wantAllCtrl, BorderLayout.CENTER);
		wantAllCtrl.setLayout(null);
		//this.add(flagChangePanel);
		//getContentPane().add(flagChangePanel, BorderLayout.NORTH);
		//flagChangePanel.setVisible(false);
		//this.add(infoDeltePanel);


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("機能");
		menuBar.add(menu);

		mntmWantall = new JMenuItem("WantAll");
		mntmWantall.addActionListener(new MenuActionListener());
		menu.add(mntmWantall);

		mntmInfodelete = new JMenuItem("InfoDelete");
		mntmInfodelete.addActionListener(new MenuActionListener());

		menu.add(mntmInfodelete);
	}

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mf.setVisible(true);
	}

	private class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == mntmWantall)  {
				System.out.println("WantAll");
			}
			if(event.getSource() == mntmInfodelete)  {
				System.out.println("InfoDelete");
				changePanel("InfoDelete");
			}
		}
	}

	public void changePanel(String panelName) {
		if(panelName == "InfoDelete") {
			getContentPane().removeAll();

			getContentPane().add(infoDeletePanel, BorderLayout.NORTH);
			infoDeletePanel.setVisible(true);
			wantAllCtrl.setLayout(null);


			getContentPane().add(wantAllCtrl, BorderLayout.CENTER);
			wantAllCtrl.setLayout(null);

			repaint();
		}
	}
}