package fr.tangv.mtnes.bus.ppu;

import fr.tangv.mtnes.bus.AbstractReadBusData;

public class StatusBusData extends AbstractReadBusData {

	private final static int O = 0b0010_0000;
	private final static int S = 0b0100_0000;
	private final static int V = 0b1000_0000;
	
	public StatusBusData() {
		super((byte) 0);
	}
	
	public void setOverflowSprite(boolean overflow) {
		super.setBit(overflow, O);
	}
	
	public void setSprite0Hit(boolean sprite0Hit) {
		super.setBit(sprite0Hit, S);
	}
	
	public void setVBlank(boolean vBlank) {
		super.setBit(vBlank, V);
	}
	
}
