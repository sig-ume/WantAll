/**
 *
 */
package jp.sigre.WantAll.gui;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
		//getContentPane().add(infoDeletePanel, BorderLayout.NORTH);
		//infoDeletePanel.setVisible(false);
	}
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mf.setVisible(true);
	}
	public void PanelChange(JPanel jp, String str){
		String name = jp.getName();
		if(name==PanelNames[0]) {
			wantAllPanel = (WantAllListPanel)jp; wantAllPanel.setVisible(false);
		}
		if(name==PanelNames[1]) {
			flagChangePanel = (FlagChangeListPanel)jp; flagChangePanel.setVisible(false);
		}
		if(name==PanelNames[2]) {
			infoDeletePanel = (InfoDeleteListPanel)jp; infoDeletePanel.setVisible(false);
		}
		if(str==PanelNames[0])
			wantAllPanel.setVisible(true);
		if(str==PanelNames[1])
			flagChangePanel.setVisible(true);
		if(str==PanelNames[2])
			infoDeletePanel.setVisible(true);

	}
}