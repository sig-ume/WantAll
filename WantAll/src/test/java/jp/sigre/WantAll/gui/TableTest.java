package jp.sigre.WantAll.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TableTest extends JFrame {

	private JPanel contentPane;
	private JTable table;
//	private String[][] tabledata = {
//			{"日本", "3勝", "0敗", "1分"},
//			{"クロアチア", "3勝", "1敗", "0分"},
//			{"ブラジル", "1勝", "2敗", "1分"},
//			{"オーストラリア", "2勝", "2敗", "0分"}};
	private JButton button;
	private JButton button_1;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableTest frame = new TableTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TableTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		model = new DefaultTableModel(2,2);
		table = new JTable(model);
		model.setValueAt("test", 0, 0);
		panel.add(table);

		button_1 = new JButton("New button");
		panel.add(button_1);

		button = new JButton("New button");
		button.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		model.setValueAt("after", 0, 0);
	    	}
	    });
		contentPane.add(button, BorderLayout.CENTER);
	}

}
