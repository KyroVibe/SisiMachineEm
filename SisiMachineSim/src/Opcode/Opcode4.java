package Opcode;

import javax.swing.JTextField;

import Core.Main;

public class Opcode4 extends Opcode {

	@Override
	public String Decode(String ir) {
		String msg = "MOVE r" + ir.charAt(2) + " -> r" + ir.charAt(3);
		return msg;
	}

	@Override
	public void Execute(String ir) {
		int one = Integer.parseInt(String.valueOf(ir.charAt(2)));
		int two = Integer.parseInt(String.valueOf(ir.charAt(3)));
		JTextField r1 = Main.inst.window.regs.get(one);
		JTextField r2 = Main.inst.window.regs.get(two);
		r2.setText(r1.getText());
	}

}
