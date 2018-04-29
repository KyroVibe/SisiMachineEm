package Opcode;

import javax.swing.JTextField;

import Core.Main;

public class OpcodeB extends Opcode {

	@Override
	public String Decode(String ir) {
		String msg = "JUMP " + ir.charAt(2) + ir.charAt(3) + " IF (r0 == r" + ir.charAt(1);
		return msg;
	}

	@Override
	public void Execute(String ir) {
		int one = Main.inst.HexToDec(String.valueOf(ir.charAt(1)));
		JTextField r1 = Main.inst.window.regs.get(one);
		JTextField r2 = Main.inst.window.regs.get(0);
		if (r2.getText().equals(r1.getText())) {
			Main.inst.pcX = Main.inst.HexToDec(String.valueOf(ir.charAt(3)));
			Main.inst.pcY = Main.inst.HexToDec(String.valueOf(ir.charAt(2)));
		}
	}

}
