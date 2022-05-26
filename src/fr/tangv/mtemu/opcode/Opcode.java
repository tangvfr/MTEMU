package fr.tangv.mtemu.opcode;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtemu.comp.BusProcessor;

public interface Opcode<T extends BusProcessor<?>, N extends Number> {
	
	public int execute() throws BusIOException;
	public T getCpu();
	public N getCode();
	
}
