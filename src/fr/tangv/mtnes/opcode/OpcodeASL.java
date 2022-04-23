package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeASL extends Opcode2A03NCC {

	public OpcodeASL(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) {
		int r = mem.getData() << 1;
		byte out = (byte) r;
		mem.setData(out);
		this.setNZCFlag(out, (r & 0xFFFF_0000) != 0);
	}

}
