package fr.tangv.mtnes.bus;

import fr.tangv.mtemu.bus.Bus;
import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtemu.comp.Ram16A8D;
import fr.tangv.mtemu.comp.Registers16AD8;
import fr.tangv.mtnes.processor.NesPpu;

public class NesBus implements Bus<Short, Byte> {

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
	
	//classe BUS2A03
	
	private Ram16A8D ram;
	private Registers16AD8 ppuR;
	
	public NesBus(NesPpu ppu) {
		this.ram = new Ram16A8D(0x0800);
		
	}

	@Override
	public Byte read(Short adr) throws BusIOException {
		return this.getCell(adr).getData();
	}

	@Override
	public void write(Short adr, Byte data) throws BusIOException {
		this.getCell(adr).setData(data);
	}

	@Override
	public BusData<Byte> getCell(Short adr) throws BusIOException {
		BusData<Byte> cell = null;
		
		if ((adr & 0xE000) == 0) {//RAM
			System.out.println("RAM");
			cell = this.ram.getCell((short) (adr & 0x07FF));
		} else {
			if ((adr & 0xC000) == 0) {//PPU
				System.out.println("PPU");
				cell = this.ppuR.getCell((short) (adr & 0x0007));
			} else {
				
			}
		}
		
		return cell;
	}
	
}
