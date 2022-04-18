package fr.tangv.mtcbs.castridge;

import fr.tangv.mtcbs.data.Rom;

public abstract class NESCartridge {

	public static final byte[] HEAD_FILE = {0x4E, 0x45, 0x53, 0x1A};
	public static final boolean HORIZONTAL_MIRRORING_ARRANGEMENT = false;
	public static final boolean VERTICAL_MIRRORING_ARRANGEMENT = true;
	
	public abstract Rom getPrgRom();
	public abstract Rom getChrRom();
	public abstract Rom getTrainerRom();
	
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
