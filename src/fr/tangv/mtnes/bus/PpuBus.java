package fr.tangv.mtnes.bus;

import fr.tangv.mtemu.bus.Bus;
import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;

public class PpuBus implements Bus<Short, Byte> {

	//MAX
	public static final short MAX = (short) 0xFFFF;
	

	
	public PpuBus() {
		
	}

	@Override
	public Byte read(Short adr) throws BusIOException {
		return this.getCell(adr).getData();
	}

	@Override
	public void write(Short adr, Byte data) throws BusIOException {
		this.getCell(adr).setData(data);
	}

	@Override
	public BusData<Byte> getCell(Short adr) throws BusIOException {
		BusData<Byte> cell = null;
		
		
		
		return cell;
	}
	
}
