package Core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.*;

public class Window {
	
	// --- Variables ---
	
	public JTextField IR, PC, Decoded;
	public JButton ClearRun, ClearCpu, Run, Step;
	
	public JFrame frame;
	
	public Window(int width, int height) {
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
		//CreateText(0, 0, 20, 20, true, "00");
		
		//Create Registers and Buttons and Counters Here
		CreateText(0, 0, 40, 20, false, "GPRs");
		
		for (int i = 0; i < 16; i++) {
			CreateText(0, 20 + i * 20, 20, 20, false, Main.inst.DecToHex(i));
			CreateText(20, 20 + i * 20, 20, 20, true, "00");
		}
		
		Step = CreateButton(60, 20, 160, 40, "Step");
		Step.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.inst.Step();
			}
			
		});
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
	
	public JButton CreateButton(int x, int y, int width, int height, String txt) {
		JButton button = new JButton(txt);
		button.setBounds(x, y, width, height);
		
		frame.add(button);
		button.setVisible(true);
		
		return button;
	}
	
	
	
}