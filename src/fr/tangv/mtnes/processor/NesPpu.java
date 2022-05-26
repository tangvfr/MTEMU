package fr.tangv.mtnes.processor;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusDataRW;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtemu.bus.InternBusDataW;
import fr.tangv.mtemu.comp.BusProcessor;
import fr.tangv.mtemu.comp.Registers16AD8;
import fr.tangv.mtnes.Nes;
import fr.tangv.mtnes.bus.ppu.AddrBusData;
import fr.tangv.mtnes.bus.ppu.ControllerBusData;
import fr.tangv.mtnes.bus.ppu.DataBusData;
import fr.tangv.mtnes.bus.ppu.MaskBusData;
import fr.tangv.mtnes.bus.ppu.PpuBus;
import fr.tangv.mtnes.bus.ppu.ScrollBusData;
import fr.tangv.mtnes.bus.ppu.StatusBusData;

public class NesPpu extends BusProcessor<PpuBus> {

	private final Nes nes;
	private final ControllerBusData ppuCtrl;
	private final MaskBusData ppuMask;
	private final StatusBusData ppuStatus;
	private final InternBusDataW<Byte> oamAddr;
	private final BusDataRW<Byte> oamData;
	private final ScrollBusData ppuScroll;
	private final AddrBusData ppuAddr;
	private final DataBusData ppuData;
	//data render
	
	
	
	public NesPpu(Nes nes, PpuBus bus) {
		super("NES PPU", bus);
		this.nes = nes;
		this.ppuCtrl = new ControllerBusData();
		this.ppuMask = new MaskBusData(nes);
		this.ppuStatus = new StatusBusData();
		this.oamAddr = new InternBusDataW<Byte>((byte) 0);
		this.oamData = new BusDataRW<Byte>((byte) 0);
		this.ppuScroll = new ScrollBusData();
		this.ppuAddr = new AddrBusData();
		this.ppuData = new DataBusData(bus, ppuAddr, ppuCtrl);
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

}
