package fr.tangv.mtnes.bus.ppu;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;

public class AddrBusData implements BusData<Byte> {

	private short addr;
	private boolean isHigh;

	public AddrBusData() {
		this.addr = 0;
		this.isHigh = true;
	}
	
	@Override
	public Byte getData() throws BusIOException {
		throw new BusIOException("Reading is disallow !");
	}
	
	@Override
	public void setData(Byte data) throws BusIOException {
		if (this.isHigh) {
			this.addr &= 0x0F;
			this.addr |= data << 8;
		} else {//isLow
			this.addr &= 0xF0;
			this.addr |= data;
		}
		//switch high to low, low to high
		this.isHigh = !this.isHigh;
	}
	
	public short getAddr() {
		return this.addr;
	}
	
	public void addAddr(short add) {
		this.addr += add;
	}
	
	@Override
	public String toString() {
		return Short.toString(this.addr);
	}
	
}
