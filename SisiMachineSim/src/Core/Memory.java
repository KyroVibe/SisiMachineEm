package Core;

import javax.swing.*;
import java.util.*;

public class Memory {
	
	// --- Variables ---
	
	public List<List<JTextField>> RamArray = new ArrayList<List<JTextField>>();

	public JFrame frame;
	
	public Memory(int width, int height) {
		frame = new JFrame("Memory");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		//Insert all shit here
		for (int x = 0; x < 16; x++) {
			CreateText(20 + x * 20, 0, 20, 20, false, Main.inst.hexChar[x]);
		}
		for (int y = 0; y < 16; y++) {
			CreateText(0, 20 + y * 20, 20, 20, false, Main.inst.hexChar[y]);
		}
		
		CreateTable(16, 16);
		
		JTextField a = new JTextField();
		a.setEnabled(false);
		frame.add(a);
		
		frame.setVisible(true);
	}
	
	public void CreateTable(int sizeX, int sizeY) {
		//CreateText(0, 0, 20, 20, true, "00");
		
		//Create Ram Array
		for (int x = 0; x < sizeY; x++) {
			List<JTextField> temps = new ArrayList<JTextField>();
			
			for (int y = 0; y < sizeX; y++) {
				temps.add(CreateText(20 + x * 20, 20 + y * 20, 20, 20, true, "00"));
			}
			
			RamArray.add(temps);
		}
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
