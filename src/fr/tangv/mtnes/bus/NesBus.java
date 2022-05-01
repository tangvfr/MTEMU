package fr.tangv.mtnes.bus;

import fr.tangv.mtemu.bus.AbstractBus;
import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtemu.comp.Ram16A8D;
import fr.tangv.mtemu.comp.Registers16AD8;
import fr.tangv.mtnes.Nes;
import fr.tangv.mtnes.castridge.AbstractNesCastridge;
import fr.tangv.mtnes.processor.NesPpu;

public class NesBus extends AbstractBus<Short, Byte> {
	
	private final Nes nes;
	private final Ram16A8D ram;
	private final Registers16AD8 ppuR;
	private final Registers16AD8 apuR;
	
	public NesBus(Nes nes) {
		this.nes = nes;
		//RAM
		this.ram = new Ram16A8D(0x0800);
		//PPU
		NesPpu ppu = nes.getPpu();
		this.ppuR = ppu.createRegisters();
		//APU
		this.apuR = nes.getApu().createRegisters(ppu);
	}

	@Override
	public BusData<Byte> getCell(Short adr) throws BusIOException {
		BusData<Byte> cell = null;
		int address = Short.toUnsignedInt(adr);
		
		if (address < 0x2000) {//RAM
			System.out.println("RAM");
			cell = this.ram.getCell((short) (adr & 0x07FF));
		} else {
			if (address < 0x4000) {//PPU
				System.out.println("PPU");
				cell = this.ppuR.getCell((short) (adr & 0x0007));
			} else {
				if (address < 0x4020) {//APU
					System.out.println("APU");
					cell = this.apuR.getCell((short) (adr & 0x001F));
				} else {//CASTRIDGE
					System.out.println("CASTRIDGE");
					AbstractNesCastridge castridge = this.nes.getCastridge();
					if (castridge == null)
						throw new BusIOException("NES haven't castridge !");
					castridge.getCell(adr);
				}
			}
		}
		
		//test cell define
		if (cell == null)
			throw new BusIOException("Cell isn't defined at 0x" + Integer.toHexString(address) + " !");
		
		return cell;
	}
	
}
