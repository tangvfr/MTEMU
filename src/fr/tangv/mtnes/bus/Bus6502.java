package fr.tangv.mtnes.bus;

import fr.tangv.mtemu.bus.Bus16A8D;

public class Bus6502 extends Bus16A8D {

	//https://www.nesdev.com/NESDoc.pdf
	
	//RAM
	public static final short ZERO_PAGE = 0x0000;
	public static final short STACK = 0x0100;
	public static final short RAM = 0x0200;
	//MIRRORS
	public static final short MIRRORS_RAM = 0x0800;
	//I/O Register
	public static final short PPU = 0x2000;
	public static final short MIRRORS_PPU = 0x2008;
	public static final short APU = 0x4000;
	public static final short JOYPAD = 0x4016;
	public static final short JOYPAD1 = 0x4016;
	public static final short JOYPAD2 = 0x4017;
	public static final short U_JOYPAD3 = 0x4018;
	public static final short U_JOYPAD4 = 0x4019;
	//Optional
	public static final short EXPANSION_ROM = 0x4020;
	public static final short S_RAM = 0x6000;
	//PRG ROM
	public static final short PRG_ROM_LOW = (short) 0x8000;
	public static final short PRG_ROM_HIGH = (short) 0xC000;
	
	public Bus6502() {
		
	}
	
}
