package fr.tangv.mtemu.opcode;

import fr.tangv.mtemu.cpu.Cpu;

public interface Opcode<T extends Cpu<?>, N extends Number> {
	
	public void execute();
	public T getCpu();
	public N getCode();
	public int numberCycle();
	
}
