package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodeINX extends ImpliedOpcode2A03 {

	public OpcodeINX(NesCpu cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() throws BusIOException {
		byte x = this.cpu.getX();
		x++;
		this.cpu.setX(x);
		this.setNZFlag(x);
	}

}
