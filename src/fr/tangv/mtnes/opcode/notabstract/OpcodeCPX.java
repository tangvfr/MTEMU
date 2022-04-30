package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.opcode.GetterBusData;
import fr.tangv.mtnes.opcode.Opcode2A03;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodeCPX extends Opcode2A03 {

	public OpcodeCPX(NesCpu cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) throws BusIOException {
		int x = Byte.toUnsignedInt(this.cpu.getX());
		int m = Byte.toUnsignedInt(mem.getData());
		int r = x - m;
		this.setNZCFlag((byte) r, (r & 0xFFFF_0000) != 0);
	}

}
