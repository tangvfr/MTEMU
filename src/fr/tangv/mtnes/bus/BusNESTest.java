package fr.tangv.mtnes.bus;

import fr.tangv.mtemu.bus.BusData;

public class BusNESTest extends Bus2A03 {

	public BusNESTest() {
		for (short i = 0; i < Bus2A03.MAX; i++) {
			this.setCell(i, new BusData<Byte>((byte) 0x00));
		}
	}
	
}
