package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.processor.NesCpu;

public abstract class ImpliedOpcode2A03 extends AbstractOpcode2A03NCC {
	
	public ImpliedOpcode2A03(NesCpu cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}
	
	protected abstract void run() throws BusIOException;
	
	@Override
	public int execute() throws BusIOException {
		this.run();
		return this.getCycle();
	}

}
