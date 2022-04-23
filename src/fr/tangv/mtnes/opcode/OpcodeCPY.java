package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeCPY extends Opcode2A03 {

	public OpcodeCPY(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) {
		int y = Byte.toUnsignedInt(this.cpu.getY());
		int m = Byte.toUnsignedInt(mem.getData());
		int r = y - m;
		this.setNZCFlag((byte) r, (r & 0xFFFF_0000) != 0);
	}

}
