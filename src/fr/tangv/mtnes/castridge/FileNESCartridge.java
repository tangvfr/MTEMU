package fr.tangv.mtnes.castridge;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import fr.tangv.mtemu.bus.Bus16A8D;

public class FileNESCartridge extends NESCartridge {

	private Bus16A8D trainerRom;
	private Bus16A8D prgRom;
	private Bus16A8D chrRom;
	
	private int prgRomSize;
	private int chrRomSize;
	private boolean mirroringArrangement;
	private boolean persistentMemory;
	private boolean trainer;
	private boolean ignoreMirroringControl;
	private byte mapperNumber;
	
	
	public FileNESCartridge(String file) throws IOException {
		this(new FileInputStream(file));
	}
	
	public FileNESCartridge(File file) throws IOException {
		this(new FileInputStream(file));
	}
	
	public FileNESCartridge(InputStream in) throws IOException {
		byte[] head = new byte[4];
		readBytes(in, head);
		if (head[0] == NESCartridge.HEAD_FILE[0]
			&& head[1] == NESCartridge.HEAD_FILE[1]
			&& head[2] == NESCartridge.HEAD_FILE[2]
			&& head[3] == NESCartridge.HEAD_FILE[3]
			) {
			this.prgRomSize = nextByte(in) * 16_384;
			this.chrRomSize = nextByte(in) * 8_192;
			byte flag6 = nextByte(in);
			//flag6
			this.mirroringArrangement = (flag6 & 0b0001) == 0b0001;
			this.persistentMemory = (flag6 & 0b0010) == 0b0010;
			this.trainer = (flag6 & 0b0100) == 0b0010;
			this.ignoreMirroringControl = (flag6 & 0b1000) == 0b1000;
			this.mapperNumber = (byte) (flag6 >>> 4);
			
			//to jump to 0x16
			readBytes(in, new byte[10]);
			/*
			//Creation des ROM
			//trainer
			if (this.hasTrainer()) {
				byte[] trainerBuf = new byte[512];
				readBytes(in, trainerBuf);
				this.trainerRom = new Memory(trainerBuf);
			} else {
				this.trainerRom = null;
			}
			
			//prgRom
			byte[] prgBuf = new byte[this.prgRomSize];
			readBytes(in, prgBuf);
			this.prgRom = new Memory(prgBuf);
			
			//chrRom
			if (!this.isUseChrRam()) {
				byte[] chrRomBuf = new byte[this.chrRomSize];
				readBytes(in, chrRomBuf);
				this.chrRom= new Memory(chrRomBuf);
			} else {
				this.chrRom = null;
			}
			*/
			//close stream
			in.close();
		} else {
			in.close();
			throw new IOException("Input is not NESCartridge ! (Header is wrong)");
		}
	}
	
	private byte nextByte(InputStream in) throws IOException {
		int r = in.read();
		if (r == -1) {
			in.close();
			throw new IOException("Error to read input !");
		}
		return (byte) r;
	}
	
	private void readBytes(InputStream in, byte[] buf) throws IOException {
		if (in.read(buf) == -1) {
			in.close();
			throw new IOException("Error to read input !");
		}
	}
	
	@Override
	public Bus16A8D getPrgRom() {
		return this.prgRom;
	}

	@Override
	public Bus16A8D getChrRom() {
		return this.chrRom;
	}

	@Override
	public Bus16A8D getTrainerRom() {
		return this.trainerRom;
	}

	@Override
	public int getPrgRomSize() {
		return this.prgRomSize;
	}

	@Override
	public int getChrRomSize() {
		return this.chrRomSize;
	}

	@Override
	public boolean getMirroringArrangement() {
		return this.mirroringArrangement;
	}

	@Override
	public boolean hasPersistentMemory() {
		return this.persistentMemory;
	}

	@Override
	public boolean hasTrainer() {
		return this.trainer;
	}

	@Override
	public boolean isIgnoreMirroringControl() {
		return this.ignoreMirroringControl;
	}

	@Override
	public byte getMapperNumber() {
		return this.mapperNumber;
	}

	@Override
	public String toString() {
		return "FileNESCartridge [trainerRom=" + trainerRom + ", prgRom=" + prgRom + ", chrRom=" + chrRom
				+ ", prgRomSize=" + prgRomSize + ", chrRomSize=" + chrRomSize + ", mirroringArrangement="
				+ mirroringArrangement + ", persistentMemory=" + persistentMemory + ", trainer=" + trainer
				+ ", ignoreMirroringControl=" + ignoreMirroringControl + ", mapperNumber=" + mapperNumber + "]";
	}
	
}
