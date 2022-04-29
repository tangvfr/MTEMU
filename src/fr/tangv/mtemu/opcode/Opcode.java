package fr.tangv.mtemu.opcode;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtemu.cpu.Cpu;

public interface Opcode<T extends Cpu<?>, N extends Number> {
	
	public int execute() throws BusIOException;
	public T getCpu();
	public N getCode();
	
}
