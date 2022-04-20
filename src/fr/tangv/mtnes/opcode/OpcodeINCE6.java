package fr.tangv.mtnes.opcode;

import fr.tangv.mtnes.bus.Bus2A03;
import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeINCE6 extends Opcode2A03 {

	public OpcodeINCE6(Cpu2A03 cpu) {
		super(cpu, (byte) 0xE6, 5);
	}

	@Override
	public void execute() {
		Bus2A03 bus = cpu.getBus();
		short adr = (short) (Bus2A03.ZERO_PAGE | cpu.nextPC());
		byte data = (byte) (bus.read(adr) + 0x1);
		bus.write(adr, data);
		byte sr = 0;
		if (data == 0)
			sr |= Cpu2A03.FLAG_Z;
		sr |= (data & 0b1000_0000);
		cpu.setFlags((byte) (Cpu2A03.FLAG_Z | Cpu2A03.FLAG_N), sr);
	}

}
