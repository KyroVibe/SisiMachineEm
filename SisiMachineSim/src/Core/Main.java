package Core;

import Opcode.*;

public class Main {
	
	public static void main(String[] args) { new Main(); }
	
	// --- Variables ---
	
	public static Main inst;
	
	protected final boolean debug = false;
	
	public int pcX = 0, pcY = 0, stage = 0;
	
	public String ir, version = "1.0.3";
	
	public Window window;
	public Memory memory;
	public UpdateWindow win;
	
	public String[] hexChar = new String[] {
		"0",
		"1",
		"2",
		"3",
		"4",
		"5",
		"6",
		"7",
		"8",
		"9",
		"A",
		"B",
		"C",
		"D",
		"E",
		"F"
	};
	
	public String[] hexBits = new String[] {
		"0000",
		"0001",
		"0010",
		"0011",
		"0100",
		"0101",
		"0110",
		"0111",
		"1000",
		"1001",
		"1010",
		"1011",
		"1100",
		"1101",
		"1110",
		"1111"
	};
	
	public Opcode[] opcodes = new Opcode[] {
		new OpcodeError(),
		new Opcode1(),
		new Opcode2(),
		new Opcode3(),
		new Opcode4(),
		new Opcode5(),
		new Opcode6(),
		new Opcode7(),
		new Opcode8(),
		new Opcode9(),
		new OpcodeA(),
		new OpcodeB(),
		new OpcodeC()
	};
	
	// --- Functions ---
	
	public Main() {
		inst = this;
		
		win = new UpdateWindow();
		
		window = new Window(400, 600);
		memory = new Memory(345, 368); //Change those %%%%ing numbers
	}
	
	
	
	//Add Fetch, Decode, and Execute, along with HexToDec and DecToHex, The Hex characters array, Opcode arrays. Also, make opcodes
	
	public void Step() {
		if (stage == 0) {
			window.Stage.setText("Stage | Fetch");
			Fetch();
			stage++;
		} else if (stage == 1) {
			window.Stage.setText("Stage | Decode");
			Decode();
			stage++;
		} else if (stage == 2) {
			window.Stage.setText("Stage | Execute");
			Execute();
			stage = 0;
		} else {
			print("Very big problem");
		}
	}
	
	public void Fetch() {
		print("\n--- Fetch ---\n");
		
		ir = memory.RamArray.get(pcX).get(pcY).getText() + memory.RamArray.get(pcX + 1).get(pcY).getText();
		ir = ir.toUpperCase();
		window.IR.setText("IR | " + ir);
		print(ir);
		
		if (pcX > 14) {
			pcX = 0;
			if (pcY >= 16) {
				pcY = 0;
				//Stop Run
			} else {
				pcY++;
			}
		} else {
			pcX += 2;
		}
		
		window.PC.setText("PC | " + pcY + "" + pcX);
	}
	
	public void Decode() {
		print("\n--- Decode ---\n");
		
		String a = opcodes[HexToDec(String.valueOf(ir.charAt(0)))].Decode(ir);
		
		print("Decoded | " + a);
		
		window.Decoded.setText("Decoded | " + a);
	}
	
	public void Execute() {
		print("\n--- Execute ---\n");
		
		opcodes[Integer.parseInt("" + HexToDec(String.valueOf(ir.charAt(0))))].Execute(ir);
	}
	
	
	
	// Util Functions
	
	public String DecToHex(int i) {
		return hexChar[i];
	}
	
	public int HexToDec(String a) {
		System.out.println(a);
		
		for (int i = 0; i < hexChar.length; i++) {
			if (hexChar[i].equals(a)) {
				return i;
			}
		}
		
		return 99;
	}
	
	public void print(Object a) {
		if (debug)
			System.out.println(a.toString());
	}
	
	public Byte HexToByte(String h) {
		Byte byt;
		
		int a = HexToDec(String.valueOf(h.charAt(0)));
		int b = HexToDec(String.valueOf(h.charAt(1)));
		
		byt = new Byte(hexBits[a] + hexBits[b]);
		
		return byt;
	}
	
	public String ByteToHex(Byte b) {
		String partAbyt = b.toString().substring(0, 3);
		String partBbyt = b.toString().substring(4, 7);
		String partAhex = "0", partBhex = "0";
		for (int i = 0; i < hexBits.length; i++) {
			if (hexBits[i].equals(partAbyt)) {
				partAhex = DecToHex(i);
			}
			
			if (hexBits[i].equals(partBbyt)) {
				partBhex = DecToHex(i);
			}
		}
		
		return partAhex + partBhex;
	}
	
	public String addBytes(String byt1, String byt2) {
		int a = Integer.parseInt(byt1, 16);
		int b = Integer.parseInt(byt2, 16);
		String sum = Integer.toHexString(a + b);
		
		return sum;
	}
	
	public String addFloatingPoint(String byt1, String byt2) {
		int intBits = Integer.parseInt(byt1, 16);
		float a = Float.intBitsToFloat(intBits);
		intBits = Integer.parseInt(byt2, 16);
		float b = Float.intBitsToFloat(intBits);
		
		float sum = a + b;
		
		//intBits = Float.floatToIntBits(sum); 
		String hex = Float.toHexString(sum);
		return hex;
	}

}
