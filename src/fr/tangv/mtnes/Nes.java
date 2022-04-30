package fr.tangv.mtnes;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.bus.NesBus;
import fr.tangv.mtnes.bus.PpuBus;
import fr.tangv.mtnes.castridge.NesCastridge;
import fr.tangv.mtnes.processor.NesApu;
import fr.tangv.mtnes.processor.NesCpu;
import fr.tangv.mtnes.processor.NesPpu;

public class Nes {

	private final NesCpu cpu;
	private final NesApu apu;
	private final NesPpu ppu;
	private NesCastridge castridge;

	public Nes() {
		this.ppu = new NesPpu(this, new PpuBus());
		this.apu = new NesApu();
		this.cpu = new NesCpu(new NesBus(this));
	}
	
	public void powerUp() throws BusIOException {
		this.cpu.powerUp();
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
	
	public NesCastridge getCastridge() {
		return this.castridge;
	}
	
	public void setCastridge(NesCastridge castridge) {
		this.castridge = castridge;
	}
	
}
