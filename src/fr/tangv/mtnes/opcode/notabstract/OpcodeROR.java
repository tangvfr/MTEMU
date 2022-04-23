package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;
import fr.tangv.mtnes.opcode.GetterBusData;
import fr.tangv.mtnes.opcode.Opcode2A03;
import fr.tangv.mtnes.opcode.Opcode2A03NCC;

public class OpcodeROR extends Opcode2A03NCC {
	
	public OpcodeROR(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) {
		byte data = mem.getData();
		byte sr = 0;
		if ((data & 0b0000_0001) == 0b0000_0001)
			sr |= Cpu2A03.FLAG_C;
		data >>>= 1;
		
		if (this.cpu.isSetFlags(Cpu2A03.FLAG_C)) {
			data |= 0b1000_0000;
			sr |= 0b1000_0000;//set N
		}
		
		if (data == 0)
			sr |= Cpu2A03.FLAG_Z;
		
		mem.setData(data);
		this.cpu.setFlags(Opcode2A03.FLAGS_ZNC, sr);
	}

}
