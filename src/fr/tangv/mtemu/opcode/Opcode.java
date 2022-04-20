package fr.tangv.mtemu.opcode;

import fr.tangv.mtemu.cpu.Cpu;

public interface Opcode<T extends Cpu> {
	
	public void execute(T cpu);
	public int numberCycle();
	
}
