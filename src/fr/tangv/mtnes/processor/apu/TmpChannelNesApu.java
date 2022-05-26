package fr.tangv.mtnes.processor.apu;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusDataRW;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.processor.NesApu;

public class TmpChannelNesApu extends ChannelNesApu {

	private final BusData<Byte> set1;
	private final BusData<Byte> set2;
	private final BusData<Byte> set3;
	private final BusData<Byte> set4;
	
	public TmpChannelNesApu(NesApu apu) {
		super(apu);
		this.set1 = new BusDataRW<Byte>((byte) 0);
		this.set2 = new BusDataRW<Byte>((byte) 0);
		this.set3 = new BusDataRW<Byte>((byte) 0);
		this.set4 = new BusDataRW<Byte>((byte) 0);
	}
	
	@Override
	public void runCycle() throws BusIOException {
		
	}

	@Override
	public BusData<Byte> getSettingq1() {
		return this.set1;
	}
	
	@Override
	public BusData<Byte> getSettingq2() {
		return this.set2;
	}
	
	@Override
	public BusData<Byte> getSettingq3() {
		return this.set3;
	}
	
	@Override
	public BusData<Byte> getSettingq4() {
		return this.set4;
	}

}