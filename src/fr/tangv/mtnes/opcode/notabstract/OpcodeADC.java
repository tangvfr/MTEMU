package fr.tangv.mtnes.opcode.notabstract;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.opcode.GetterBusData;
import fr.tangv.mtnes.opcode.Opcode2A03;
import fr.tangv.mtnes.processor.NesCpu;

public class OpcodeADC extends Opcode2A03 {

	public OpcodeADC(NesCpu cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void run(BusData<Byte> mem) throws BusIOException {
		BusData<Byte> ac = this.cpu.getAC();
		int a = Byte.toUnsignedInt(ac.getData());
		int m = Byte.toUnsignedInt(mem.getData());
		int r = a + m + (this.cpu.isSetFlags(NesCpu.FLAG_C) ? 1 : 0);

		boolean c7 = (r & 0xFFFF_0000) != 0;
		final int MASK = 0x0000_8000;
		boolean a7 = (a & MASK) == MASK;
		boolean m7 = (m & MASK) == MASK;
		boolean r7 = (r & MASK) == MASK;
		
		boolean v = (!m7 && !a7 && r7) || (m7 && a7 && !r7);
		
		byte out = (byte) r;
		ac.setData(out);
		this.setNZCVFlag(out, c7, v);
	}

}
