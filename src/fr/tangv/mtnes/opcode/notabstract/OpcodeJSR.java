package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeJSR extends OpcodeJMP {

	public OpcodeJSR(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() {
		super.run();
		this.cpu.stackPush(this.cpu.getPCHigh());
		this.cpu.stackPush(this.cpu.getPCLow());
	}
	
}
