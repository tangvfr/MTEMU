package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.GetterBusData;
import fr.tangv.mtnes.opcode.Opcode2A03NCC;

public class OpcodeBIT extends Opcode2A03NCC {

	public static final byte FLAGS_NZV = (byte) (Cpu2A03.FLAG_N | Cpu2A03.FLAG_Z | Cpu2A03.FLAG_V);
	
	public OpcodeBIT(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) {
		byte m = mem.getData();
		byte r = (byte) (this.cpu.getAC().getData() & m);
		byte sr = 0;
		
		if (r == 0)//FLag Z
			sr |= Cpu2A03.FLAG_Z;
		sr |= (m & 0b1100_0000);//Flag N & V
		
		this.cpu.setFlags(FLAGS_NZV, sr);
	}

}