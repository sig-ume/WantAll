/**
 *
 */
package jp.sigre.WantAll.gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import jp.sigre.WantAll.file.SqliteExport;
import jp.sigre.WantAll.file.SqliteImport;
import jp.sigre.WantAll.gui.panel.control.ControlPanel;
import jp.sigre.WantAll.gui.panel.control.FlagChangeControlPanel;
import jp.sigre.WantAll.gui.panel.control.InfoDeleteControlPanel;
import jp.sigre.WantAll.gui.panel.control.InfoInsertControlPanel;
import jp.sigre.WantAll.gui.panel.control.WantAllControlPanel;
import jp.sigre.WantAll.gui.panel.table.FlagChangeTablePanel;
import jp.sigre.WantAll.gui.panel.table.InfoDeleteTablePanel;
import jp.sigre.WantAll.gui.panel.table.InfoInsertTablePanel;
import jp.sigre.WantAll.gui.panel.table.TablePanel;
import jp.sigre.WantAll.gui.panel.table.WantAllTablePanel;

/**
 * @author sigre
 *
 */
public class MainFrame extends JFrame {
	TablePanel tablePanel;
	ControlPanel ctrlPanel;

	WantAllTablePanel		wantAllPanel	= new WantAllTablePanel();
	WantAllControlPanel		wantAllCtrl		= new WantAllControlPanel(wantAllPanel);
	FlagChangeTablePanel 	flagChangePanel = new FlagChangeTablePanel();
	FlagChangeControlPanel	flagChangeCtrl	= new FlagChangeControlPanel(flagChangePanel);
	InfoDeleteTablePanel	infoDeletePanel = new InfoDeleteTablePanel();
	InfoDeleteControlPanel	infoDeleteCtrl	= new InfoDeleteControlPanel(infoDeletePanel);
	InfoInsertTablePanel 	infoInsertPanel	= new InfoInsertTablePanel();
	InfoInsertControlPanel	infoInsertCtrl	= new InfoInsertControlPanel(infoInsertPanel);

	JMenuItem mntmWantall;
	JMenuItem mntmInfodelete;
	JMenuItem mntmFlagChange;
	JMenuItem mntmInfoInsert;
	JMenuItem mntmCheckBox;
	JMenuItem mntmReset;
	JMenuItem mntmExport;
	JMenuItem mntmImport;

	SqliteExport sqliteExport = new SqliteExport(this);
	SqliteImport sqliteImport = new SqliteImport(this);

	public MainFrame(){
		this.setBounds(100, 100, 492, 400);

		setTitle("WantAll");

		tablePanel = wantAllPanel;
		ctrlPanel = wantAllCtrl;

		setPanels();

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mntmWantall = new JMenuItem("WantAll");
		mntmWantall.addActionListener(new MenuActionListener());
		menuBar.add(mntmWantall);

		mntmInfodelete = new JMenuItem("InfoDelete");
		mntmInfodelete.addActionListener(new MenuActionListener());
		menuBar.add(mntmInfodelete);

		mntmFlagChange = new JMenuItem("FlagChange");
		mntmFlagChange.addActionListener(new MenuActionListener());
		menuBar.add(mntmFlagChange);

		mntmInfoInsert = new JMenuItem("InfoInsert");
		mntmInfoInsert.addActionListener(new MenuActionListener());
		menuBar.add(mntmInfoInsert);

		mntmCheckBox = new JMenuItem("CheckBox");
		mntmCheckBox.addActionListener(new MenuActionListener());
		menuBar.add(mntmCheckBox);

		mntmReset = new JMenuItem("Reset");
		mntmReset.addActionListener(new MenuActionListener());
		menuBar.add(mntmReset);

		mntmExport = new JMenuItem("Export");
		mntmExport.addActionListener(new MenuActionListener());
		menuBar.add(mntmExport);

		mntmImport = new JMenuItem("Import");
		mntmImport.addActionListener(new MenuActionListener());
		menuBar.add(mntmImport);

	}

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mf.setVisible(true);
	}

	private class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == mntmWantall)  {
				changePanel("WantAll");
			}
			if (event.getSource() == mntmInfodelete)  {
				//System.out.println("InfoDelete");
				changePanel("InfoDelete");
			}
			if (event.getSource() == mntmFlagChange)  {
				//System.out.println("InfoDelete");
				changePanel("FlagChange");
			}
			if (event.getSource() == mntmInfoInsert) {
				//System.out.println("InfoDelete");
				changePanel("InfoInsert");
			}
			if (event.getSource() == mntmCheckBox) {
				tablePanel.setAllCheckBox();
			}
			if (event.getSource() == mntmReset) {
				tablePanel.resetTable();
			}
			if (event.getSource() == mntmExport) {
				sqliteExport.dialogExportFile();
			}
			if (event.getSource() == mntmImport) {
				sqliteImport.dialogImportFile();
			}
		}
	}

	public void changePanel(String panelName) {
		getContentPane().removeAll();
		setTitle(panelName);

		if(panelName == "InfoDelete") {
			tablePanel = infoDeletePanel;
			ctrlPanel = infoDeleteCtrl;
		}

		if (panelName == "FlagChange") {
			tablePanel = flagChangePanel;
			ctrlPanel = flagChangeCtrl;
		}

		if (panelName == "WantAll") {
			tablePanel = wantAllPanel;
			ctrlPanel = wantAllCtrl;
		}

		if (panelName == "InfoInsert") {
			tablePanel = infoInsertPanel;
			ctrlPanel = infoInsertCtrl;
		}
		setPanels();
	}

	private void setPanels() {
		getContentPane().add(tablePanel, BorderLayout.NORTH);
		tablePanel.setVisible(true);
		getContentPane().add(ctrlPanel, BorderLayout.CENTER);
		ctrlPanel.setLayout(null);

		setVisible(true);
		repaint();
		revalidate();
	}
}