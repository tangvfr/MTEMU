package fr.tangv.mtnes.bus.ppu;

import fr.tangv.mtemu.bus.AbstractBusDataW;
import fr.tangv.mtemu.bus.BusIOException;

public class MaskBusData extends AbstractBusDataW<Byte> {

	private boolean greyscale;
	private boolean showBackgroundLeftmost;
	private boolean showSpritesLeftmost;
	private boolean showBackground;
	private boolean showSprites;
	private boolean emphasizeRed;
	private boolean emphasizeGreen;
	private boolean emphasizeBlue;
	
	public MaskBusData() {
		super((byte) 0);
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
		return greyscale;
	}

	public boolean isShowBackgroundLeftmost() {
		return showBackgroundLeftmost;
	}

	public boolean isShowSpritesLeftmost() {
		return showSpritesLeftmost;
	}

	public boolean isShowBackground() {
		return showBackground;
	}

	public boolean isShowSprites() {
		return showSprites;
	}

	public boolean isEmphasizeRedNTSC() {
		return emphasizeRed;
	}

	public boolean isEmphasizeGreenNTSC() {
		return emphasizeGreen;
	}

	public boolean isEmphasizeBlueNTSC() {
		return emphasizeBlue;
	}
	
	public boolean isEmphasizeRedPAL() {
		return emphasizeGreen;
	}

	public boolean isEmphasizeGreenPAL() {
		return emphasizeRed;
	}

	public boolean isEmphasizeBluePAL() {
		return emphasizeBlue;
	}

}
