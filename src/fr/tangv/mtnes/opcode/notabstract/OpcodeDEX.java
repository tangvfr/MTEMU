package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;

public class OpcodeDEX extends ImpliedOpcode2A03 {

	public OpcodeDEX(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() {
		byte x = this.cpu.getX();
		x--;
		this.cpu.setX(x);
		this.setNZFlag(x);
	}

}
