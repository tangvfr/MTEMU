package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.GetterBusData;
import fr.tangv.mtnes.opcode.Opcode2A03NCC;

public class OpcodeROL extends Opcode2A03NCC {

	public OpcodeROL(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) {
		int r = mem.getData() << 1;
		if (this.cpu.isSetFlags(Cpu2A03.FLAG_C))
			r |= 0b0000_0001;
		byte out = (byte) r;
		mem.setData(out);
		this.setNZCFlag(out, (r & 0xFFFF_0000) != 0);
	}

}
