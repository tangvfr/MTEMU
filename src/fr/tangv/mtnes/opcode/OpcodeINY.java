package fr.tangv.mtnes.opcode;

import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeINY extends ImpliedOpcode2A03 {

	public OpcodeINY(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() {
		byte y = this.cpu.getY();
		y++;
		this.cpu.setX(y);
		this.setNZFlag(y);
	}

}
