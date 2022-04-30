package fr.tangv.mtemu.opcode;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtemu.processor.Processor;

public interface Opcode<T extends Processor<?>, N extends Number> {
	
	public int execute() throws BusIOException;
	public T getCpu();
	public N getCode();
	
}
