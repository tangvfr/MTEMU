package fr.tangv.mtnes;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.bus.NesBus;
import fr.tangv.mtnes.bus.ppu.PpuBus;
import fr.tangv.mtnes.castridge.AbstractNesCastridge;
import fr.tangv.mtnes.processor.NesApu;
import fr.tangv.mtnes.processor.NesCpu;
import fr.tangv.mtnes.processor.NesPpu;

public class Nes {

	private final NesCpu cpu;
	private final NesApu apu;
	private final NesPpu ppu;
	private AbstractNesCastridge castridge;

	public Nes() {
		this.ppu = new NesPpu(this, new PpuBus(this));
		this.apu = new NesApu();
		this.cpu = new NesCpu(new NesBus(this));
	}
	
	public void powerUp() throws BusIOException {
		this.cpu.powerUp();
		//start loop
	}
	
	public void powerDown() throws BusIOException {
		//blakc screen, stop sound, and stop loop cycles
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
	
	public AbstractNesCastridge getCastridge() {
		return this.castridge;
	}
	
	public void setCastridge(AbstractNesCastridge castridge) {
		this.castridge = castridge;
	}
	
}
