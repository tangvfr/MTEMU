package fr.tangv.mtnes.bus.ppu;

import fr.tangv.mtemu.bus.AbstractBusDataW;
import fr.tangv.mtemu.bus.BusIOException;

public class ControllerBusData extends AbstractBusDataW<Byte> {

	private boolean generateNMI;
	private boolean master;
	private boolean spriteSize8x16;
	private short patternBackground;
	private short patternSprite;
	private short incrementPPUADR;
	private short baseNametable;
	
	public ControllerBusData() {
		super((byte) 0);
	}

	@Override
	public void setData(Byte data) throws BusIOException {
		this.data = data;
		//NN
		this.baseNametable = (short) ((data & 0b0000_0011) << 10);
		//I
		if ((data & 0b0000_0100) == 0)
			this.incrementPPUADR = 1;
		else
			this.incrementPPUADR = 32;
		//S
		if ((data & 0b0000_1000) == 0)
			this.patternSprite = 0x0000;
		else
			this.patternSprite = 0x1000;
		//B
		if ((data & 0b0001_0000) == 0)
			this.patternBackground = 0x0000;
		else
			this.patternBackground = 0x1000;
		//H
		this.spriteSize8x16 = (data & 0b0010_0000) != 0;
		//M
		this.master = (data & 0b0100_0000) == 0;
		//V
		this.generateNMI = (data & 0b1000_0000) != 0;
	}

	public boolean isGenerateNMI() {
		return generateNMI;
	}

	public boolean isMaster() {
		return master;
	}

	public boolean isSpriteSize8x16() {
		return spriteSize8x16;
	}

	public short getPatternBackground() {
		return patternBackground;
	}

	public short getPatternSprite() {
		return patternSprite;
	}

	public short getIncrementPPUADR() {
		return incrementPPUADR;
	}

	public short getBaseNametable() {
		return baseNametable;
	}
	
}
