package fr.tangv.mtnes.bus.ppu;

import fr.tangv.mtemu.bus.AbstractBusDataW;
import fr.tangv.mtemu.bus.BusIOException;

public class ScrollBusData extends AbstractBusDataW<Byte> {

	private boolean isScrollX;
	private byte scrollY;

	public ScrollBusData() {
		super((byte) 0);
		this.scrollY = 0;
		this.isScrollX = true;
	}
	
	@Override
	public void setData(Byte data) throws BusIOException {
		if (this.isScrollX)
			this.data = data;
		else//!this.isScrollX
			this.scrollY = data;
		
		//switch scroll
		this.isScrollX = !this.isScrollX;
	}

	public byte getScrollX() {
		return this.data;
	}
	
	public byte getScrollY() {
		return this.scrollY;
	}
	
}
