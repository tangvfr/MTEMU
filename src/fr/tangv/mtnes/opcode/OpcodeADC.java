package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeADC extends Opcode2A03 {

	public OpcodeADC(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) {
		BusData<Byte> ac = this.cpu.getAC();
		int a = Byte.toUnsignedInt(ac.getData());
		int m = Byte.toUnsignedInt(mem.getData());
		int r = a + m + (this.cpu.isSetFlags(Cpu2A03.FLAG_C) ? 1 : 0);
		
		int a7 = a & 0x0000_8000;
		int m7 = m & 0x0000_8000;
		int r6 = r & 0x0000_4000;
		r6 = ~(a7 ^ m7) & (m7 ^ r6);
		
		byte out = (byte) r;
		ac.setData(out);
		this.setNZCVFlag(out, r > 0x0000_FFFF, r6 > 0);
	}

}
