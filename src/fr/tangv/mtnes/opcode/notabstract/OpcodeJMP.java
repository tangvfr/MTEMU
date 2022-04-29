package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;

public class OpcodeJMP extends ImpliedOpcode2A03 {
	
	public OpcodeJMP(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
		this.setChangePC();
	}

	@Override
	protected void run() throws BusIOException {
		byte pcl = this.cpu.addGetPC();
		byte pch = this.cpu.addGetPC();
		this.cpu.setPC(pcl, pch);
	}

}
