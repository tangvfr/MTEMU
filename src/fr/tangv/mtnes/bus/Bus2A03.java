package fr.tangv.mtnes.bus;

import fr.tangv.mtemu.bus.Bus16A8D;

public class Bus2A03 extends Bus16A8D {

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
	public static final short JOYPAD1 = 0x4016;
	public static final short JOYPAD2 = 0x4017;
	//Castridge
	public static final short CASTRIDGE = 0x4018;//none without mapper
	public static final short PRG_ROM_LOW = (short) 0x8000;
	public static final short PRG_ROM_HIGH = (short) 0xC000;
	//MAX
	public static final short MAX = (short) 0xFFFF;
	
}
