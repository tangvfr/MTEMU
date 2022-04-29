package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.cpu.Cpu2A03;

public class SetFlagOpcode2A4 extends ImpliedOpcode2A03 {

	private byte flag;
	private byte value;
	
	public SetFlagOpcode2A4(Cpu2A03 cpu, byte flag, boolean value, Byte code, int cycle) {
		super(cpu, code, cycle);
		this.flag = flag;
		if (!value) {
			this.value = 0;
		} else {
			this.value = flag;
		}
	}
	
	@Override
	protected void run() throws BusIOException {
		this.cpu.setFlags(flag, value);
	}

}
