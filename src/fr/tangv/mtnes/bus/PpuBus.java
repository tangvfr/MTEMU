package fr.tangv.mtnes.bus;

import fr.tangv.mtemu.bus.AbstractBus;
import fr.tangv.mtemu.bus.AbstractBusData;
import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;

public class PpuBus extends AbstractBus<Short, Byte> {
	
	AbstractBusData<Byte>
	
	public PpuBus() {
		
	}

	@Override
	public BusData<Byte> getCell(Short adr) throws BusIOException {
		AbstractBusData<Byte> cell = null;
		int address = Short.toUnsignedInt(adr);
		
		
		
		
		return cell;
	}
	
}
