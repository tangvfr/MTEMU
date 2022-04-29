package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;

public class OpcodePLP extends ImpliedOpcode2A03 {

	public OpcodePLP(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}
	
	@Override
	protected void run() throws BusIOException {
		byte data = this.cpu.stackPull();
		byte pc = this.cpu.getSR();
		this.cpu.setSR((byte) ((data & 0b1100_1111) | (pc & 0b0011_0000)));
	}

}
