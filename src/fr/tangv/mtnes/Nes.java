package fr.tangv.mtnes;

import fr.tangv.mtnes.bus.NesBus;
import fr.tangv.mtnes.bus.PpuBus;
import fr.tangv.mtnes.processor.NesApu;
import fr.tangv.mtnes.processor.NesCpu;
import fr.tangv.mtnes.processor.NesPpu;

public class Nes {

	private final NesCpu cpu;
	private final NesApu apu;
	private final NesPpu ppu;

	public Nes() {
		this.ppu = new NesPpu(this, new PpuBus());
		this.apu = new NesApu();
		this.cpu = new NesCpu(new NesBus(this.ppu));
	}
	
	public NesCpu getCpu() {
		return this.cpu;
	}
	
	public NesApu getApu() {
		return this.apu;
	}

	public NesPpu getPpu() {
		return this.ppu;
	}
	
}
