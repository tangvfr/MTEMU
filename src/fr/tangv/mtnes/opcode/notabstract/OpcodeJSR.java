package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;

public class OpcodeJSR extends ImpliedOpcode2A03 {

	public OpcodeJSR(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
		this.setChangePC();
	}

	@Override
	protected void run() {
		byte pcl = this.cpu.addGetPC();
		byte pch = this.cpu.addGetPC();
		this.cpu.stackPush(this.cpu.getPCLow());
		this.cpu.stackPush(this.cpu.getPCHigh());
		this.cpu.setPC(pcl, pch);
	}
	
}
