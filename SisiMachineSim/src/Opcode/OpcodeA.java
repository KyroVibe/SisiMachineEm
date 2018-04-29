package Opcode;

import javax.swing.JTextField;

import Core.Main;

public class OpcodeA extends Opcode {

	@Override
	public String Decode(String ir) {
		String msg = "ROTATE-RIGHT r" + ir.charAt(1) + " <- r" + ir.charAt(2) + " [ror] r" + ir.charAt(3);
		return msg;
	}

	@Override
	public void Execute(String ir) {
		int rStored = Main.inst.HexToDec(String.valueOf(ir.charAt(1)));
		byte two = (byte)Main.inst.HexToDec(String.valueOf(ir.charAt(3)));
		JTextField r1 = Main.inst.window.regs.get(rStored);
		
		byte a = (byte)Integer.parseInt(r1.getText(), 16);
		
		String sum = Integer.toHexString(a >> two);
		
		if (sum.length() < 2) {
			sum = "0" + sum;
		}
		
		sum = sum.toUpperCase();
		
		Main.inst.print("'" + sum + "'");
		
		r1.setText(sum);
	}

}
