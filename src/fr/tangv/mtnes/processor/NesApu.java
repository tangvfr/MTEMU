package fr.tangv.mtnes.processor;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtemu.comp.Processor;
import fr.tangv.mtemu.comp.Registers16AD8;

public class NesApu extends Processor {
	
	//private 
	
	public NesApu() {
		super("NesApu");
	}

	@Override
	public int runCycle() throws BusIOException {
		int cycles = 0;
		
		
		return cycles;
	}

	@SuppressWarnings("unchecked")
	public Registers16AD8 createRegisters(NesPpu ppu) {
		return new Registers16AD8(new BusData[] {
				
			});
	}
	
}
