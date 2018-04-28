package Core;

import Opcode.*;

public class Main {
	
	public static void main(String[] args) { new Main(); }
	
	// --- Variables ---
	
	public static Main inst;
	
	public int pcX = 0, pcY = 0, stage = 0;
	
	public Window window;
	public Memory memory;
	
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
	
	public Opcode[] opcodes = new Opcode[] {
		null,
		new Opcode1()/*,
		new Opcode2()*/
	};
	
	// --- Functions ---
	
	public Main() {
		inst = this;
		
		window = new Window(800, 600);
		memory = new Memory(345, 348); //Change those fucking numbers
	}
	
	//Add Fetch, Decode, and Execute, along with HexToDec and DecToHex, The Hex characters array, Opcode arrays. Also, make opcodes
	
	public void Step() {
		if (stage == 0) {
			Fetch();
			stage++;
		} else if (stage == 1) {
			Decode();
			stage++;
		} else if (stage == 2) {
			Execute();
			stage = 0;
		} else {
			System.out.println("Very big problem");
		}
	}
	
	public void Fetch() {
		window.IR.setText(memory.RamArray.get(pcX).get(pcY).getText() + memory.RamArray.get(pcX + 1).get(pcY).getText());
		
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
		
		window.PC.setText(pcX + "" + pcY);
	}
	
	public void  Decode() {
		String a = opcodes[Integer.parseInt("" + HexToDec("" + window.IR.getText().charAt(0)))].Decode();
		
		window.Decoded.setText("Decoded | " + a);
	}
	
	public void Execute() {
		opcodes[Integer.parseInt("" + HexToDec("" + window.IR.getText().charAt(0)))].Execute();
	}
	
	
	
	public String DecToHex(int i) {
		return hexChar[i];
	}
	
	public int HexToDec(String a) {
		for (int i = 0; i < hexChar.length; i++) {
			if (hexChar[i].equals(a)) {
				return i;
			}
		}
		
		return 99;
	}

}
