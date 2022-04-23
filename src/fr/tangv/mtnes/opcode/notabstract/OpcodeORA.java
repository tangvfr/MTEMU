package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.GetterBusData;
import fr.tangv.mtnes.opcode.Opcode2A03;

public class OpcodeORA extends Opcode2A03 {

	public OpcodeORA(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) {
		BusData<Byte> ac = this.cpu.getAC();
		Byte r = (byte) (ac.getData() | mem.getData());
		ac.setData(r);
		this.setNZFlag(r);
	}

}
