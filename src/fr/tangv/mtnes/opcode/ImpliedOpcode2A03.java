package fr.tangv.mtnes.opcode;

import fr.tangv.mtnes.cpu.Cpu2A03;

public abstract class ImpliedOpcode2A03 extends AbstractOpcode2A03NCC {
	
	public ImpliedOpcode2A03(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}
	
	protected abstract void run();
	
	@Override
	public int execute() {
		this.run();
		return this.getCycle();
	}

}
