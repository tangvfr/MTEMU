package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.GetterBusData;
import fr.tangv.mtnes.opcode.Opcode2A03;
import fr.tangv.mtnes.opcode.Opcode2A03NCC;

public class OpcodeLSR extends Opcode2A03NCC {
	
	public OpcodeLSR(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) throws BusIOException {
		byte data = mem.getData();
		byte sr = 0;
		if ((data & 0b0000_0001) == 0b0000_0001)
			sr |= Cpu2A03.FLAG_C;
		data >>>= 1;
		if (data == 0)
			sr |= Cpu2A03.FLAG_Z;
		mem.setData(data);
		this.cpu.setFlags(Opcode2A03.FLAGS_ZNC, sr);
	}

}
