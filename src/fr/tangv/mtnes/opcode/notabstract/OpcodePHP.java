package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodePHP extends ImpliedOpcode2A03 {

	public OpcodePHP(NesCpu cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}
	
	@Override
	protected void run() throws BusIOException {
		this.cpu.stackPush((byte) (this.cpu.getSR() | 0b0011_0000));
	}

}
