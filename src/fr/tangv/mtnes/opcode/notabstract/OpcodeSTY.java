package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.GetterBusData;
import fr.tangv.mtnes.opcode.Opcode2A03NCC;

public class OpcodeSTY extends Opcode2A03NCC {

	public OpcodeSTY(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) throws BusIOException {
		mem.setData(this.cpu.getY());
	}
	
}
