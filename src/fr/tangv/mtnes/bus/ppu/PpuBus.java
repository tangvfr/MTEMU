package fr.tangv.mtnes.bus.ppu;

import fr.tangv.mtemu.bus.AbstractBus;
import fr.tangv.mtemu.bus.AbstractBusData;
import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtemu.comp.Ram16A8D;
import fr.tangv.mtnes.Nes;
import fr.tangv.mtnes.castridge.AbstractNesCastridge;

public class PpuBus extends AbstractBus<Short, Byte> {

	private static final int SCREENS = 4;
	public static final int NAMETABLE_A = 0;
	public static final int NAMETABLE_B = 1;
	public static final int NAMETABLE_C = 2;
	public static final int NAMETABLE_D = 3;
	
	private final Nes nes;
	private final Ram16A8D[] nametableRams;
	private final Ram16A8D[] nametables;
	private final Ram16A8D palette;
	
	public PpuBus(Nes nes) {
		this.nes = nes;
		this.nametableRams = new Ram16A8D[PpuBus.SCREENS];
		for (int i = 0; i < PpuBus.SCREENS; i++) {
			this.nametableRams[i] = new Ram16A8D(0x400);
		}
		this.nametables = new Ram16A8D[PpuBus.SCREENS];
		this.palette = new Ram16A8D(0x20);
	}

	@Override
	public BusData<Byte> getCell(Short adr) throws BusIOException {
		AbstractBusData<Byte> cell = null;
		int address = Short.toUnsignedInt(adr);
		
		if (address < 0x2000) {//paterntable
			System.out.println("PPU CASTRIDGE");
			AbstractNesCastridge castridge = this.nes.getCastridge();
			if (castridge == null)
				throw new BusIOException("NES haven't castridge !");
			castridge.getCellPpu(adr);
		} else if (address < 0x3F00) {//nametable
			System.out.println("PPU NAMETABLE");
			cell = nametables[(address >>> 10) & 0x3]
					.getCell((short) (address & 0x3FF));
		} else {//palette
			System.out.println("PPU PALETTE");
			cell = palette.getCell((short) (address & 0x1F));
		}
		
		return cell;
	}
	
	public void setScreen(int[] screens) {
		if (screens.length != PpuBus.SCREENS)
			throw new IllegalArgumentException("4 screen must defined !");
		
		for (int i = 0; i < PpuBus.SCREENS; i++) {
			this.nametables[i] = this.nametableRams[screens[i]];
		}
	}
	
}
