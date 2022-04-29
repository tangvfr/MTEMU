package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.cpu.Cpu2A03;

public abstract class Opcode2A03 extends AbstractOpcode2A03 {
	
	private final GetterBusData getter;
	
	public Opcode2A03(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, code, cycle);
		if (getter == null)
			throw new IllegalArgumentException("Getter is NULL !");
		
		this.getter = getter;
	}
	
	protected abstract void run(BusData<Byte> mem) throws BusIOException;
	
	@Override
	public int execute() throws BusIOException {
		this.resetCalcCycle();
		this.run(getter.getBusData(this, this.cpu, this.cpu.getBus()));
		return this.getCalcCycle();
	}
	
}