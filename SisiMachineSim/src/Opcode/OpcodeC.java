package Opcode;

import Core.Main;

public class OpcodeC extends Opcode {

	@Override
	public String Decode(String ir) {
		
		return "HALT";
	}

	@Override
	public void Execute(String ir) {
		Main.inst.window.Clear();
	}

}
