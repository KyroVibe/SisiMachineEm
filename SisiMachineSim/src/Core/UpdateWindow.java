package Core;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class UpdateWindow {
	
	public JFrame frame;
	
	public JButton update, close;

	public UpdateWindow() {
		InitWindow();
	}
	
	public void InitWindow() {
		frame = new JFrame("Update");
		frame.setSize(500, 100);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		//Insert all %%%% here
		Create();
		
		JTextField a = new JTextField();
		a.setEnabled(false);
		frame.add(a);
		
		frame.setVisible(true);
	}
	
	public void Create() {
		CreateText(10, 10, 180, 20, false, "Update Available");
		
		/*update = CreateButton(200, 10, 100, 30, "Update");
		close = CreateButton(310, 10, 100, 30, "Later");
		
		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.inst.updater.UpdateApplication();
			}
		});
		
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});*/
	}
	
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
