package fr.tangv.mtnes.processor;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtemu.processor.Processor;
import fr.tangv.mtnes.Nes;
import fr.tangv.mtnes.bus.PpuBus;

public class NesPpu extends Processor<PpuBus> {

	private Nes nes;
	
	public NesPpu(Nes nes, PpuBus bus) {
		super("NES PPU", bus);
		this.nes = nes;
	}

	@Override
	public int runCycle() throws BusIOException {
		int cycles = 0;
		
		
		
		return cycles;
	}
	

}
