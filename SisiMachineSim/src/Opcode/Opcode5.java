package Opcode;

import javax.swing.JTextField;

import Core.Main;

public class Opcode5 extends Opcode {

	@Override
	public String Decode(String ir) {
		String msg = "ADD r" + ir.charAt(1) + " <- r" + ir.charAt(2) + " + r" + ir.charAt(3);
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
		
		//Byte bOne = Main.inst.HexToByte(r1.getText());
		//Byte bTwo = Main.inst.HexToByte(r2.getText());
		String sum = Main.inst.addBytes(r1.getText(), r2.getText());
		
		if (sum.length() < 2) {
			sum = "0" + sum;
		}
		
		sum = sum.toUpperCase();
		
		Main.inst.print("'" + sum.hashCode() + "'");
		
		stored.setText(sum);
	}

}
