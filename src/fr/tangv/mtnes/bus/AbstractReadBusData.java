package fr.tangv.mtnes.bus;

import fr.tangv.mtemu.bus.BusDataR;

public abstract class AbstractReadBusData extends BusDataR<Byte> {

	public AbstractReadBusData(Byte data) {
		super(data);
	}

	protected void setBit(boolean v, int flag) {
		int d = data & (~flag);
		if (v)
			d |= flag;
		this.data = (byte) d;
	}
	
}
