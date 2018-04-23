package Core;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Memory {

public JFrame frame;
	
	public Memory(int width, int height) {
		frame = new JFrame("FFUCUUCKCKCKCKCKKC");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		//Insert all shit here
		CreateTable();
		
		JTextField a = new JTextField();
		a.setEnabled(false);
		frame.add(a);
		
		frame.setVisible(true);
	}
	
	public void CreateTable() {
		CreateText(0, 0, 20, 20, true, "00");
		
		//Create Ram Array
	}
	
	public JTextField CreateText(int x, int y, int width, int height, boolean editable, String txt) {
		JTextField a = new JTextField();
		a.setBounds(x, y, width, height);
		a.setEditable(editable);
		a.setDocument(new JTextFieldLimit(txt.length()));
		a.setText(txt);
		
		frame.add(a);
		a.setVisible(true);
		
		return a;
	}
	
}
