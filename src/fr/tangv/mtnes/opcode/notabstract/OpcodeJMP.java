package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;

public class OpcodeJMP extends ImpliedOpcode2A03 {
	
	public OpcodeJMP(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
		this.setChangePC();
	}

	@Override
	protected void run() {
		byte pcl = this.cpu.nextPC();
		byte pch = this.cpu.nextPC();
		this.cpu.setPC(pcl, pch);
	}

}
