package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodeBRK extends ImpliedOpcode2A03 {

	public OpcodeBRK(NesCpu cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
		this.setChangePC();
	}

	@Override
	protected void run() throws BusIOException {
		this.cpu.addPC((byte) 2);
		this.cpu.interuptIRQ();
	}

}
