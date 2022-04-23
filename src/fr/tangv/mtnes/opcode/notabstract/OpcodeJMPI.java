package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtnes.bus.Bus2A03;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;

public class OpcodeJMPI extends ImpliedOpcode2A03 {
	
	public OpcodeJMPI(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
		this.setChangePC();
	}

	@Override
	protected void run() {
		Bus2A03 bus = this.cpu.getBus();
		short adr = (short) (cpu.nextPC() | (cpu.nextPC() << 8));
		byte pcl = bus.getCell(adr).getData();
		adr++;
		byte pch = bus.getCell(adr).getData();
		this.cpu.setPC(pcl, pch);
	}

}
