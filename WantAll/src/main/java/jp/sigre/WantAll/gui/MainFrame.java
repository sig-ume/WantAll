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

import jp.sigre.WantAll.gui.panel.FlagChangeControlPanel;
import jp.sigre.WantAll.gui.panel.FlagChangeListPanel;
import jp.sigre.WantAll.gui.panel.InfoDeleteControlPanel;
import jp.sigre.WantAll.gui.panel.InfoDeleteListPanel;
import jp.sigre.WantAll.gui.panel.InfoInsertControlPanel;
import jp.sigre.WantAll.gui.panel.InfoInsertListPanel;
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
	FlagChangeControlPanel flagChangeCtrl = new FlagChangeControlPanel(flagChangePanel);
	InfoDeleteListPanel infoDeletePanel = new InfoDeleteListPanel();
	InfoDeleteControlPanel infoDeleteCtrl = new InfoDeleteControlPanel(infoDeletePanel);
	InfoInsertListPanel infoInsertPanel = new InfoInsertListPanel();
	InfoInsertControlPanel infoInsertCtrl = new InfoInsertControlPanel(infoInsertPanel);

	JMenuItem mntmWantall;
	JMenuItem mntmInfodelete;
	JMenuItem mntmFlagChange;
	JMenuItem mntmInfoInsert;

	JMenu wantAllMenu;
	JMenu infoInsertMenu;
	JMenu infoDeleteMenu;
	JMenu flagChangeMenu;

	public MainFrame(){
		this.setBounds(100, 100, 492, 400);

		setTitle("WantAll");

		//getContentPane().add(infoDeletePanel, BorderLayout.NORTH);
		//infoDeletePanel.setLayout(null);
		//this.add(wantAllPanel);wantAllPanel.setVisible(true);
		getContentPane().add(wantAllPanel, BorderLayout.NORTH);
		wantAllPanel.setVisible(true);
		//this.add(wantAllCtrl);wantAllCtrl.setVisible(true);
		getContentPane().add(wantAllCtrl, BorderLayout.CENTER);
		wantAllCtrl.setLayout(null);
		//this.add(flagChangePanel);

		//this.add(infoDeltePanel);


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

//		wantAllMenu = new JMenu("WantAll");
//		wantAllMenu.addActionListener(new MenuActionListener());
//		menuBar.add(wantAllMenu);
//
//		infoDeleteMenu = new JMenu("InfoDelete");
//		infoDeleteMenu.addActionListener(new MenuActionListener());
//		menuBar.add(infoDeleteMenu);
//
//		infoInsertMenu = new JMenu("InfoInsert");
//		infoInsertMenu.addActionListener(new MenuActionListener());
//		menuBar.add(infoInsertMenu);
//
//		flagChangeMenu = new JMenu("FlagChange");
//		flagChangeMenu.addActionListener(new MenuActionListener());
//		menuBar.add(flagChangeMenu);

		//JMenu menu = new JMenu("機能");
		//menuBar.add(menu);

		mntmWantall = new JMenuItem("WantAll");
		mntmWantall.addActionListener(new MenuActionListener());
		//menu.add(mntmWantall);
		menuBar.add(mntmWantall);

		mntmInfodelete = new JMenuItem("InfoDelete");
		mntmInfodelete.addActionListener(new MenuActionListener());
		//menu.add(mntmInfodelete);
		menuBar.add(mntmInfodelete);

		mntmFlagChange = new JMenuItem("FlagChange");
		mntmFlagChange.addActionListener(new MenuActionListener());
		//menu.add(mntmFlagChange);
		menuBar.add(mntmFlagChange);

		mntmInfoInsert = new JMenuItem("InfoInsert");
		mntmInfoInsert.addActionListener(new MenuActionListener());
		//menu.add(mntmInfoInsert);
		menuBar.add(mntmInfoInsert);
	}

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mf.setVisible(true);
	}

	private class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == mntmWantall | event.getSource() == wantAllMenu)  {
				changePanel("WantAll");
			}
			if(event.getSource() == mntmInfodelete | event.getSource() == infoDeleteMenu)  {
				//System.out.println("InfoDelete");
				changePanel("InfoDelete");
			}
			if(event.getSource() == mntmFlagChange | event.getSource() == flagChangeMenu)  {
				//System.out.println("InfoDelete");
				changePanel("FlagChange");
			}
			if(event.getSource() == mntmInfoInsert | event.getSource() == infoInsertMenu) {
				//System.out.println("InfoDelete");
				changePanel("InfoInsert");
			}
		}
	}

	public void changePanel(String panelName) {
		if(panelName == "InfoDelete") {
			getContentPane().removeAll();

			setTitle(panelName);

			getContentPane().add(infoDeletePanel, BorderLayout.NORTH);
			//infoDeletePanel.setVisible(true);

			getContentPane().add(infoDeleteCtrl, BorderLayout.CENTER);
			//infoDeleteCtrl.setVisible(true);
			infoDeleteCtrl.setLayout(null);

			//repaint();
			//revalidate();
			setVisible(true);
			repaint();
			revalidate();
		}

		if (panelName == "FlagChange") {
			getContentPane().removeAll();

			setTitle(panelName);

			getContentPane().add(flagChangePanel, BorderLayout.NORTH);
			//flagChangePanel.setVisible(true);

			getContentPane().add(flagChangeCtrl, BorderLayout.CENTER);
			//flagChangeCtrl.setVisible(true);
			flagChangeCtrl.setLayout(null);

			//repaint();
			//revalidate();
			setVisible(true);
			repaint();
			revalidate();
		}

		if (panelName == "WantAll") {
			getContentPane().removeAll();

			setTitle(panelName);

			getContentPane().add(wantAllPanel, BorderLayout.NORTH);
			//wantAllPanel.setVisible(true);

			getContentPane().add(wantAllCtrl, BorderLayout.CENTER);
			//wantAllCtrl.setVisible(true);
			wantAllCtrl.setLayout(null);

			//repaint();
			//revalidate();
			setVisible(true);
			repaint();
			revalidate();
		}

		if (panelName == "InfoInsert") {
			getContentPane().removeAll();

			setTitle(panelName);

			getContentPane().add(infoInsertPanel, BorderLayout.NORTH);
			//wantAllPanel.setVisible(true);

			getContentPane().add(infoInsertCtrl, BorderLayout.CENTER);
			//wantAllCtrl.setVisible(true);
			infoInsertCtrl.setLayout(null);

			//repaint();
			//revalidate();
			setVisible(true);
			repaint();
			revalidate();
		}
	}
}