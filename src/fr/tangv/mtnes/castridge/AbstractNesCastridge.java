package fr.tangv.mtnes.castridge;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.Nes;

public abstract class AbstractNesCastridge {

	private final Nes nes;
	
	public AbstractNesCastridge(Nes nes) {
		this.nes = nes;
	}
	
	public Nes getNes() {
		return this.nes;
	}

	public abstract BusData<Byte> getCellCpu(Short adr) throws BusIOException;
	public abstract BusData<Byte> getCellPpu(Short adr) throws BusIOException;
	
}
