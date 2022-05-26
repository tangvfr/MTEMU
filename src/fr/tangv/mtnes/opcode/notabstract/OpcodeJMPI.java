package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.bus.NesBus;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodeJMPI extends ImpliedOpcode2A03 {
	
	public OpcodeJMPI(NesCpu cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
		this.setChangePC();
	}

	@Override
	protected void run() throws BusIOException {
		NesBus bus = this.cpu.getBus();
		short adr = (short) (cpu.addGetPC() | (cpu.addGetPC() << 8));
		byte pcl = bus.getCell(adr).getData();
		adr++;
		byte pch = bus.getCell(adr).getData();
		this.cpu.setPC(pcl, pch);
	}

}
