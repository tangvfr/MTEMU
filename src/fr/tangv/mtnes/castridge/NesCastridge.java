package fr.tangv.mtnes.castridge;

import fr.tangv.mtemu.bus.AbstractBus;
import fr.tangv.mtnes.Nes;

public abstract class NesCastridge extends AbstractBus<Short, Byte> {

	private final Nes nes;
	
	public NesCastridge(Nes nes) {
		this.nes = nes;
	}
	
	public Nes getNes() {
		return this.nes;
	}
	
}
