package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;

public class OpcodeTXS extends ImpliedOpcode2A03 {

	public OpcodeTXS(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() {
		byte data = this.cpu.getX();
		this.cpu.setSP(data);
		this.setNZFlag(data);
	}

}
