package fr.tangv.mtnes.bus.ppu;

import fr.tangv.mtemu.bus.AbstractBusDataW;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.Nes;

public class MaskBusData extends AbstractBusDataW<Byte> {

	private final Nes nes;
	private boolean greyscale;
	private boolean showBackgroundLeftmost;
	private boolean showSpritesLeftmost;
	private boolean showBackground;
	private boolean showSprites;
	private boolean emphasizeRed;
	private boolean emphasizeGreen;
	private boolean emphasizeBlue;
	
	public MaskBusData(Nes nes) {
		super((byte) 0);
		this.nes = nes;
	}

	@Override
	public void setData(Byte data) throws BusIOException {
		this.data = data;
		//G
		this.greyscale = (data & 0b0000_0001) != 0;
		//m
		this.showBackgroundLeftmost = (data & 0b0000_0010) != 0;
		//M
		this.showSpritesLeftmost = (data & 0b0000_0100) != 0;
		//B
		this.showBackground = (data & 0b0000_1000) != 0;
		//s
		this.showSprites = (data & 0b0001_0000) != 0;
		//R
		this.emphasizeRed = (data & 0b0010_0000) != 0;
		//G
		this.emphasizeGreen = (data & 0b0100_0000) != 0;
		//B
		this.emphasizeBlue = (data & 0b1000_0000) != 0;
	}

	public boolean isGreyscale() {
		return this.greyscale;
	}

	public boolean isShowBackgroundLeftmost() {
		return this.showBackgroundLeftmost;
	}

	public boolean isShowSpritesLeftmost() {
		return this.showSpritesLeftmost;
	}

	public boolean isShowBackground() {
		return this.showBackground;
	}

	public boolean isShowSprites() {
		return this.showSprites;
	}
	
	public boolean isEmphasizeRed() {
		boolean val;
		if (this.nes.getType() == PpuType.PAL)
			val = this.emphasizeGreen;
		else
			val = this.emphasizeRed;
		return val;
	}

	public boolean isEmphasizeGreen() {
		boolean val;
		if (this.nes.getType() == PpuType.PAL)
			val = this.emphasizeRed;
		else
			val = this.emphasizeGreen;
		return val;
	}

	public boolean isEmphasizeBlue() {
		return this.emphasizeBlue;
	}

}
