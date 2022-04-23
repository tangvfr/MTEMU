package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;

public class OpcodePLA extends ImpliedOpcode2A03 {

	public OpcodePLA(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}
	
	@Override
	protected void run() {
		byte data = this.cpu.stackPull();
		this.cpu.getAC().setData(data);
		this.setNZFlag(data);
	}

}
