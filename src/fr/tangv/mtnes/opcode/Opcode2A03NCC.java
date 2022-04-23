package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.cpu.Cpu2A03;

public abstract class Opcode2A03NCC extends AbstarctOpcode2A03NCC {
	
	private final GetterBusData getter;
	
	public Opcode2A03NCC(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, code, cycle);
		if (getter == null)
			throw new IllegalArgumentException("Getter is NULL !");
		
		this.getter = getter;
	}
	
	protected abstract void run(BusData<Byte> mem);
	
	@Override
	public int execute() {
		this.run(getter.getBusData(this, this.cpu, this.cpu.getBus()));
		return this.getCycle();
	}
	
}