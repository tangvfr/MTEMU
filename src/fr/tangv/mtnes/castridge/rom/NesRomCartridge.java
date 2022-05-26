package fr.tangv.mtnes.castridge.rom;

import fr.tangv.mtemu.comp.Rom16A8D;

public abstract class NesRomCartridge {

	public static final byte[] HEAD_FILE = {0x4E, 0x45, 0x53, 0x1A};
	public static final boolean HORIZONTAL_MIRRORING_ARRANGEMENT = false;
	public static final boolean VERTICAL_MIRRORING_ARRANGEMENT = true;
	
	public abstract Rom16A8D getPrgRom();
	public abstract Rom16A8D getChrRom();
	public abstract Rom16A8D getTrainerRom();
	
	public abstract int getPrgRomSize();
	public abstract int getChrRomSize();
	public abstract boolean getMirroringArrangement();
	public abstract boolean hasPersistentMemory();
	public abstract boolean hasTrainer();
	public abstract boolean isIgnoreMirroringControl();
	public abstract byte getMapperNumber();
	
	public boolean isUseChrRam() {
		return this.getChrRomSize() == 0;
	}
	
	@Override
	public String toString() {
		return "NESCartridge [getPrgRom()=" + getPrgRom() + ", getChrRom()=" + getChrRom() + ", getTrainerRom()="
				+ getTrainerRom() + ", getPrgRomSize()=" + getPrgRomSize() + ", getChrRomSize()=" + getChrRomSize()
				+ ", getMirroringArrangement()=" + getMirroringArrangement() + ", hasPersistentMemory()="
				+ hasPersistentMemory() + ", hasTrainer()=" + hasTrainer() + ", isIgnoreMirroringControl()="
				+ isIgnoreMirroringControl() + ", getMapperNumber()=" + getMapperNumber() + ", isUseChrRam()="
				+ isUseChrRam() + "]";
	}
	
}
