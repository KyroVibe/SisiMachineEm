package Opcode;

import javax.swing.JTextField;

import Core.Main;

public class Opcode1 extends Opcode {

	@Override
	public String Decode(String ir) {
		String msg = "LOAD r" + ir.charAt(1) + " <- *(0x" + ir.charAt(2) + "" + ir.charAt(3) + ")";
		return msg;
	}

	@Override
	public void Execute(String ir) {
		System.out.println("All good");
		
		int x = Main.inst.HexToDec(String.valueOf(ir.charAt(2)));
		int y = Main.inst.HexToDec(String.valueOf(ir.charAt(3)));
		JTextField m = Main.inst.memory.RamArray.get(x).get(y);
		JTextField r = Main.inst.window.regs.get(Main.inst.HexToDec(String.valueOf(ir.charAt(1))));
		r.setText(m.getText());
	}

}
