package fr.tangv.mtnes.bus.ppu;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;

public class DataBusData implements BusData<Byte> {

	private final PpuBus bus;
	private final AddrBusData addr;
	private final ControllerBusData controller;
	
	public DataBusData(PpuBus bus, AddrBusData addr, ControllerBusData controller) {
		this.bus = bus;
		this.addr = addr;
		this.controller = controller;
	}
	
	@Override
	public Byte getData() throws BusIOException {
		byte data = this.bus.read(this.addr.getAddr());
		this.addr.addAddr(this.controller.getIncrementPPUADR());
		return data;
	}

	@Override
	public void setData(Byte data) throws BusIOException {
		this.bus.write(this.addr.getAddr(), data);
		this.addr.addAddr(this.controller.getIncrementPPUADR());
	}

}
