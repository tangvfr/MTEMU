package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;

public class OpcodeINY extends ImpliedOpcode2A03 {

	public OpcodeINY(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() throws BusIOException {
		byte y = this.cpu.getY();
		y++;
		this.cpu.setX(y);
		this.setNZFlag(y);
	}

}
