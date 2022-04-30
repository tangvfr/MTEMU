package fr.tangv.mtnes.processor;

import fr.tangv.mtemu.bus.AbstractBusData;
import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusDataRW;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtemu.bus.InternBusDataR;
import fr.tangv.mtemu.bus.InternBusDataW;
import fr.tangv.mtemu.comp.BusProcessor;
import fr.tangv.mtemu.comp.Registers16AD8;
import fr.tangv.mtnes.Nes;
import fr.tangv.mtnes.bus.PpuBus;

public class NesPpu extends BusProcessor<PpuBus> {

	private Nes nes;
	private InternBusDataW<Byte> ppuCtrl;
	private InternBusDataW<Byte> ppuMask;
	private InternBusDataR<Byte> ppuStatus;
	private InternBusDataW<Byte> oamAddr;
	private InternBusDataW<Byte> oamData;
	private InternBusDataW<Byte> ppuScroll;
	private InternBusDataW<Byte> ppuAddr;
	private BusDataRW<Byte> ppuData;
	private InternBusDataW<Byte> oamDma;
	
	public NesPpu(Nes nes, PpuBus bus) {
		super("NES PPU", bus);
		this.nes = nes;
		this.ppuCtrl = new InternBusDataW<Byte>((byte) 0);
		this.ppuMask = new InternBusDataW<Byte>((byte) 0);
		this.ppuStatus = new InternBusDataR<Byte>((byte) 0);
		this.oamAddr = new InternBusDataW<Byte>((byte) 0);
		this.oamData = new InternBusDataW<Byte>((byte) 0);
		this.ppuScroll = new InternBusDataW<Byte>((byte) 0);
		this.ppuAddr = new InternBusDataW<Byte>((byte) 0);
		this.ppuData = new BusDataRW<Byte>((byte) 0);
		this.oamDma = new InternBusDataW<Byte>((byte) 0);
	}

	@Override
	public int runCycle() throws BusIOException {
		int cycles = 0;
		
		
		
		return cycles;
	}
	
	@SuppressWarnings("unchecked")
	public Registers16AD8 createRegisters() {
		return new Registers16AD8(new BusData[] {
				this.ppuCtrl,
				this.ppuMask,
				this.ppuStatus,
				this.oamAddr,
				this.oamData,
				this.ppuScroll,
				this.ppuAddr,
				this.ppuData
			});
	}
	
	public AbstractBusData<Byte> getOamDma() {
		return this.oamDma;
	}

}
