package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.opcode.Opcode;
import fr.tangv.mtnes.cpu.Cpu6502;

public class Opcode6502BRK00 implements Opcode<Cpu6502> {

	@Override
	public void execute(Cpu6502 cpu) {
		
	}

	@Override
	public int numberCycle() {
		return 0;
	}

	
	
}
