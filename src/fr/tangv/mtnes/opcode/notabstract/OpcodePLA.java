package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodePLA extends ImpliedOpcode2A03 {

	public OpcodePLA(NesCpu cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}
	
	@Override
	protected void run() throws BusIOException {
		byte data = this.cpu.stackPull();
		this.cpu.getAC().setData(data);
		this.setNZFlag(data);
	}

}
