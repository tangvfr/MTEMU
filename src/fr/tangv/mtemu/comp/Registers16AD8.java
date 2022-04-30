package fr.tangv.mtemu.comp;

import fr.tangv.mtemu.bus.BusData;

public class Registers16AD8 extends Memory16A8D<BusData<Byte>> {

	public Registers16AD8(BusData<Byte>[] memory) {
		super(memory);
	}
	
}
