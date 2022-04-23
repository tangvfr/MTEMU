package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeEOR extends Opcode2A03 {

	public OpcodeEOR(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) {
		BusData<Byte> ac = this.cpu.getAC();
		Byte r = (byte) (ac.getData() ^ mem.getData());
		ac.setData(r);
		this.setNZFlag(r);
	}

}
