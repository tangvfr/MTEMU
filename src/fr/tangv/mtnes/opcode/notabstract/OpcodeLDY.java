package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.opcode.GetterBusData;
import fr.tangv.mtnes.opcode.Opcode2A03;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodeLDY extends Opcode2A03 {

	public OpcodeLDY(NesCpu cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) throws BusIOException {
		byte b = mem.getData();
		this.cpu.setY(b);
		this.setNZFlag(b);
	}
	
}
