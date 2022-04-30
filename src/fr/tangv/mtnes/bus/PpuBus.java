package fr.tangv.mtnes.bus;

import fr.tangv.mtemu.bus.AbstractBus;
import fr.tangv.mtemu.bus.AbstractBusData;
import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;

public class PpuBus extends AbstractBus<Short, Byte> {

	//MAX
	public static final short MAX = (short) 0xFFFF;
	

	
	public PpuBus() {
		
	}

	@Override
	public BusData<Byte> getCell(Short adr) throws BusIOException {
		AbstractBusData<Byte> cell = null;
		
		
		
		return cell;
	}
	
}
