package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.GetterBusData;
import fr.tangv.mtnes.opcode.Opcode2A03;

public class OpcodeCMP extends Opcode2A03 {

	public OpcodeCMP(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) throws BusIOException {
		BusData<Byte> ac = this.cpu.getAC();
		int a = Byte.toUnsignedInt(ac.getData());
		int m = Byte.toUnsignedInt(mem.getData());
		int r = a - m;
		this.setNZCFlag((byte) r, (r & 0xFFFF_0000) != 0);
	}

}
