package Opcode;

import Core.Main;

public class OpcodeError extends Opcode {

	@Override
	public String Decode(String ir) {
		return "Illegal Instruction";
	}

	@Override
	public void Execute(String ir) {
		//Stop Run/Reset
		
		Main.inst.window.Clear();
	}

}
