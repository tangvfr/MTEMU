package fr.tangv.mtnes.processor;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusDataD;
import fr.tangv.mtemu.bus.BusDataRW;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtemu.comp.Processor;
import fr.tangv.mtemu.comp.Registers16AD8;
import fr.tangv.mtnes.bus.NesJoyPad;
import fr.tangv.mtnes.processor.apu.TmpChannelNesApu;

public class NesApu extends Processor {
	
	private final BusDataD<Byte> disableBD;
	private final TmpChannelNesApu pulse1;
	private final TmpChannelNesApu pulse2;
	private final TmpChannelNesApu triangle;
	private final TmpChannelNesApu noise;
	private final TmpChannelNesApu dmc;
	private final BusDataRW<Byte> status;
	private final NesJoyPad joypad1;
	private final NesJoyPad joypad2;
	
	public NesApu() {
		super("NesApu");
		this.disableBD = new BusDataD<Byte>();
		//channel audio
		this.pulse1 = new TmpChannelNesApu(this);
		this.pulse2 = new TmpChannelNesApu(this);
		this.triangle = new TmpChannelNesApu(this);
		this.noise = new TmpChannelNesApu(this);
		this.dmc = new TmpChannelNesApu(this);
		//status
		this.status = new BusDataRW<Byte>((byte) 0);
		//joypad
		this.joypad1 = new NesJoyPad();
		this.joypad2 = new NesJoyPad();
	}

	@Override
	public int runCycle() throws BusIOException {
		int cycles = 0;
		
		
		
		return cycles;
	}

	@SuppressWarnings("unchecked")
	public Registers16AD8 createRegisters(NesPpu ppu) {
		return new Registers16AD8(new BusData[] {
				//pulse1
				this.pulse1.getSettingq1(),
				this.pulse1.getSettingq2(),
				this.pulse1.getSettingq3(),
				this.pulse1.getSettingq4(),
				//pulse2
				this.pulse2.getSettingq1(),
				this.pulse2.getSettingq2(),
				this.pulse2.getSettingq3(),
				this.pulse2.getSettingq4(),
				//triangle
				this.triangle.getSettingq1(),
				this.triangle.getSettingq2(),
				this.triangle.getSettingq3(),
				this.triangle.getSettingq4(),
				//noise
				this.noise.getSettingq1(),
				this.noise.getSettingq2(),
				this.noise.getSettingq3(),
				this.noise.getSettingq4(),
				//dmc
				this.dmc.getSettingq1(),
				this.dmc.getSettingq2(),
				this.dmc.getSettingq3(),
				this.dmc.getSettingq4(),
				//oam dma
				ppu.getOamDma(),
				//status
				this.status,
				//joypad1
				this.joypad1,
				//joypad2 & framecounter
				this.joypad2,
				//disable test
				this.disableBD,
				this.disableBD,
				this.disableBD,
				this.disableBD,
				this.disableBD,
				this.disableBD,
				this.disableBD,
				this.disableBD,
			});
	}
	
}
