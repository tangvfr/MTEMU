package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeCMP extends Opcode2A03 {

	public OpcodeCMP(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) {
		BusData<Byte> ac = this.cpu.getAC();
		int a = Byte.toUnsignedInt(ac.getData());
		int m = Byte.toUnsignedInt(mem.getData());
		int r = a - m;
		this.setNZCFlag((byte) r, (r & 0xFFFF_0000) != 0);
	}

}
