package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodeDEY extends ImpliedOpcode2A03 {

	public OpcodeDEY(NesCpu cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() throws BusIOException {
		byte y = this.cpu.getY();
		y--;
		this.cpu.setX(y);
		this.setNZFlag(y);
	}

}
