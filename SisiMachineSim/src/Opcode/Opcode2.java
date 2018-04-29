package Opcode;

import javax.swing.JTextField;

import Core.Main;

public class Opcode2 extends Opcode {

	@Override
	public String Decode(String ir) {
		String msg = "LOADI r" + ir.charAt(1) + " <- 0x" + ir.charAt(2) + ir.charAt(3);
		return msg;
	}

	@Override
	public void Execute(String ir) {
		String b = ir.charAt(2) + "" + ir.charAt(3);
		JTextField r = Main.inst.window.regs.get(Main.inst.HexToDec(String.valueOf(ir.charAt(1))));
		r.setText(b);
	}

}
