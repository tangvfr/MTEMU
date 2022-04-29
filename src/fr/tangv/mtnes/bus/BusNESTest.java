package fr.tangv.mtnes.bus;

import fr.tangv.mtemu.bus.BusDataRW;

public class BusNESTest extends Bus2A03 {

	public BusNESTest() {
		for (short i = 0; i < Bus2A03.MAX; i++) {
			this.setCell(i, new BusDataRW<Byte>((byte) 0x00));
		}
	}
	
}
