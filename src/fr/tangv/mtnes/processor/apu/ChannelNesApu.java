package fr.tangv.mtnes.processor.apu;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.processor.NesApu;

public abstract class ChannelNesApu {

	private final NesApu apu;
	
	public ChannelNesApu(NesApu apu) {
		this.apu = apu;
	}
	
	public abstract void runCycle() throws BusIOException;
	public abstract BusData<Byte> getSettingq1();
	public abstract BusData<Byte> getSettingq2();
	public abstract BusData<Byte> getSettingq3();
	public abstract BusData<Byte> getSettingq4();
	
	public NesApu getApu() {
		return this.apu;
	}
	
}
