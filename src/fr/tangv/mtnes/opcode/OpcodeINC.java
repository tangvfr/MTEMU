package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeINC extends Opcode2A03NCC {

	public OpcodeINC(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) {
		byte m = mem.getData();
		m++;
		mem.setData(m);
		this.setNZFlag(m);
	}

}
