package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.ImpliedOpcode2A03;

public class OpcodePHA extends ImpliedOpcode2A03 {

	public OpcodePHA(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() throws BusIOException {
		this.cpu.stackPush(this.cpu.getAC().getData());
	}

}
