package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.bus.NesBus;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodeRTI extends ImpliedOpcode2A03 {

	public OpcodeRTI(NesCpu cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
		super.setChangePC();
	}
	
	@Override
	protected void run() throws BusIOException {
		NesBus bus = this.cpu.getBus();
		byte data = this.cpu.stackPull();
		byte pc = this.cpu.getSR();
		this.cpu.setSR((byte) ((data & 0b1100_1111) | (pc & 0b0011_0000)));
	
		short adr = (short) (this.cpu.stackPull() | (this.cpu.stackPull() << 8));
		byte pcl = bus.getCell(adr).getData();
		adr++;
		byte pch = bus.getCell(adr).getData();
		this.cpu.setPC(pcl, pch);
	}

}