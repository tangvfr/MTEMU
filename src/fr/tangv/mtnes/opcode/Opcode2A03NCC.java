package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.processor.NesCpu;

public abstract class Opcode2A03NCC extends AbstractOpcode2A03NCC {
	
	private final GetterBusData getter;
	
	public Opcode2A03NCC(NesCpu cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, code, cycle);
		if (getter == null)
			throw new IllegalArgumentException("Getter is NULL !");
		
		this.getter = getter;
	}
	
	protected abstract void run(BusData<Byte> mem) throws BusIOException;
	
	@Override
	public int execute() throws BusIOException {
		this.run(getter.getBusData(this, this.cpu, this.cpu.getBus()));
		return this.getCycle();
	}
	
}