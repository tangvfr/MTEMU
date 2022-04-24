package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;

public class OpcodeTSX extends ImpliedOpcode2A03 {

	public OpcodeTSX(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() {
		byte data = this.cpu.getSP();
		this.cpu.setX(data);
		this.setNZFlag(data);
	}

}
