package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.opcode.Opcode;
import fr.tangv.mtnes.cpu.Cpu2A03;

public abstract class Opcode2A03 implements Opcode<Cpu2A03, Byte> {

	private Byte code;
	private int cycle;
	
	public Opcode2A03(Byte code, int cycle) {
		this.code = code;
		this.cycle = cycle;
	}
	
	@Override
	public Byte getCode() {
		return code;
	}
	
	@Override
	public int numberCycle() {
		return cycle;
	}

}
