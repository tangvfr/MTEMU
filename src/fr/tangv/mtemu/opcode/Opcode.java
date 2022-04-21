package fr.tangv.mtemu.opcode;

import fr.tangv.mtemu.cpu.Cpu;

public interface Opcode<T extends Cpu<?>, N extends Number> {
	
	public int execute();
	public T getCpu();
	public N getCode();
	
}
