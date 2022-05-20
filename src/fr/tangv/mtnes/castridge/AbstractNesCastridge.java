package fr.tangv.mtnes.castridge;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.Nes;
import fr.tangv.mtnes.bus.ppu.PpuType;

public abstract class AbstractNesCastridge {

	private final Nes nes;
	private final PpuType type;
	
	public AbstractNesCastridge(Nes nes, PpuType type) {
		this.nes = nes;
		this.type = type;
	}
	
	public Nes getNes() {
		return this.nes;
	}
	
	public PpuType getPpuType() {
		return this.type;
	}
	
	public abstract BusData<Byte> getCellCpu(Short adr) throws BusIOException;
	public abstract BusData<Byte> getCellPpu(Short adr) throws BusIOException;
	
}
