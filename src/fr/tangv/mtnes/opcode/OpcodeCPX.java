package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeCPX extends Opcode2A03 {

	public OpcodeCPX(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) {
		int x = Byte.toUnsignedInt(this.cpu.getX());
		int m = Byte.toUnsignedInt(mem.getData());
		int r = x - m;
		this.setNZCFlag((byte) r, (r & 0xFFFF_0000) != 0);
	}

}
