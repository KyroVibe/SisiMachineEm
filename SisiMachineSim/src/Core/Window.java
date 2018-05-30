package Core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Window {
	
	// --- Variables ---
	
	public JTextField IR, PC, Decoded, Stage;
	public JButton ClearRam, ClearCpu, Run, Step;
	
	public List<JTextField> regs = new ArrayList<JTextField>();
	public List<JTextField> up = new ArrayList<JTextField>();
	
	public JFrame frame;
	
	public Window(int width, int height) {
		frame = new JFrame("Cpu");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		//Insert all %%%% here
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
			up.add(CreateText(0, 20 + i * 20, 20, 20, false, Main.inst.DecToHex(i)));
			regs.add(CreateText(20, 20 + i * 20, 20, 20, false, "00"));
		}
		
		//TextFields
		PC = CreateText(60, 20, 160, 30, false, "PC | ");
		IR = CreateText(60, 60, 160, 30, false, "IR | ");
		Decoded = CreateText(60, 100, 240, 30, false, "Decoded | ");
		Stage = CreateText(60, 140, 240, 30, false, "Stage | ");
		
		//Buttons
		Step = CreateButton(60, 180, 160, 30, "Step");
		Step.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.inst.Step();
			}
		});
		ClearCpu = CreateButton(60, 220, 160, 30, "ClearCpu");
		ClearCpu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < regs.size(); i++) {
					regs.get(i).setText("00");
				}
				
				Clear();
				
				Main.inst.JankSolution();
			}
		});
		ClearRam = CreateButton(60, 260, 160, 30, "Clear Ram");
		ClearRam.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int x = 0; x < Main.inst.memory.RamArray.size(); x++) {
					for (int y = 0; y < Main.inst.memory.RamArray.get(0).size(); y++) {
						Main.inst.memory.RamArray.get(x).get(y).setText("00");
					}
				}
			}
		});
	}
	
	
	
	//Util Functions
	
	public JTextField CreateText(int x, int y, int width, int height, boolean editable, String txt) {
		JTextField a = new JTextField();
		a.setBounds(x, y, width, height);
		a.setEditable(editable);
		if (editable) {
			a.setDocument(new JTextFieldLimit(txt.length()));
		} else {
			a.setDocument(new JTextFieldLimit(40));
		}
		a.setText(txt);
		
		frame.add(a);
		//a.setVisible(true);
		
		return a;
	}
	
	public JButton CreateButton(int x, int y, int width, int height, String txt) {
		JButton button = new JButton(txt);
		button.setBounds(x, y, width, height);
		
		frame.add(button);
		//button.setVisible(true);
		
		return button;
	}
	
	public void Clear() {
		Main.inst.pcX = 0;
		Main.inst.pcY = 0;
		Main.inst.stage = 0;
		PC.setText("PC | 00");
		IR.setText("IR | ");
		Decoded.setText("Decoded | ");
		Stage.setText("Stage | ");
	}
	
}
