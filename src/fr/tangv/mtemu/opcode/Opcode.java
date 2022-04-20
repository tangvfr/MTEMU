package fr.tangv.mtemu.opcode;

import fr.tangv.mtemu.cpu.Cpu;

public interface Opcode<T extends Cpu, N extends Number> {
	
	public void execute(T cpu);
	public N getCode();
	public int numberCycle();
	
}
