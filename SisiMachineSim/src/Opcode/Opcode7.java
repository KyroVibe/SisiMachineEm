package Opcode;

import javax.swing.JTextField;

import Core.Main;

public class Opcode7 extends Opcode {

	@Override
	public String Decode(String ir) {
		String msg = "OR r" + ir.charAt(1) + " <- r" + ir.charAt(2) + " | r" + ir.charAt(3);
		return msg;
	}

	@Override
	public void Execute(String ir) {
		int rStored = Main.inst.HexToDec(String.valueOf(ir.charAt(1)));
		int one = Main.inst.HexToDec(String.valueOf(ir.charAt(2)));
		int two = Main.inst.HexToDec(String.valueOf(ir.charAt(3)));
		JTextField stored = Main.inst.window.regs.get(rStored);
		JTextField r1 = Main.inst.window.regs.get(one);
		JTextField r2 = Main.inst.window.regs.get(two);
		
		int a = Integer.parseInt(r1.getText(), 16);
		int b = Integer.parseInt(r2.getText(), 16);
		
		String sum = Integer.toHexString(a | b);
		
		if (sum.length() < 2) {
			sum = "0" + sum;
		}
		
		sum = sum.toUpperCase();
		
		Main.inst.print("'" + sum + "'");
		
		stored.setText(sum);
	}

}
