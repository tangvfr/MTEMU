package fr.tangv.mtnes.opcode;

import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeINX extends ImpliedOpcode2A03 {

	public OpcodeINX(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() {
		byte x = this.cpu.getX();
		x++;
		this.cpu.setX(x);
		this.setNZFlag(x);
	}

}
