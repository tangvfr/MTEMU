package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodeTAX extends ImpliedOpcode2A03 {

	public OpcodeTAX(NesCpu cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() throws BusIOException {
		byte data = this.cpu.getAC().getData();
		this.cpu.setX(data);
		this.setNZFlag(data);
	}

}
