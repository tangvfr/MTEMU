package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.opcode.GetterBusData;
import fr.tangv.mtnes.opcode.Opcode2A03NCC;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodeBIT extends Opcode2A03NCC {

	public static final byte FLAGS_NZV = (byte) (NesCpu.FLAG_N | NesCpu.FLAG_Z | NesCpu.FLAG_V);
	
	public OpcodeBIT(NesCpu cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) throws BusIOException {
		byte m = mem.getData();
		byte r = (byte) (this.cpu.getAC().getData() & m);
		byte sr = 0;
		
		if (r == 0)//FLag Z
			sr |= NesCpu.FLAG_Z;
		sr |= (m & 0b1100_0000);//Flag N & V
		
		this.cpu.setFlags(FLAGS_NZV, sr);
	}

}
