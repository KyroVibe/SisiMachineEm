package Opcode;

public abstract class Opcode {
	
	public abstract String Decode(String ir);

	public abstract void Execute(String ir);
	
}
