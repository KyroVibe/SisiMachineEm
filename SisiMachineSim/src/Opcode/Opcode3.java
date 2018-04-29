package Opcode;

import javax.swing.JTextField;

import Core.Main;

public class Opcode3 extends Opcode {

	@Override
	public String Decode(String ir) {
		String msg = "STORE r" + ir.charAt(1) + " -> *(0x" + ir.charAt(2) + ir.charAt(3) + ")";
		return msg;
	}

	@Override
	public void Execute(String ir) {
		int x = Main.inst.HexToDec(String.valueOf(ir.charAt(2)));
		int y = Main.inst.HexToDec(String.valueOf(ir.charAt(3)));
		JTextField r = Main.inst.window.regs.get(Main.inst.HexToDec(String.valueOf(ir.charAt(1))));
		JTextField m = Main.inst.memory.RamArray.get(x).get(y);
		m.setText(r.getText());
	}

}
