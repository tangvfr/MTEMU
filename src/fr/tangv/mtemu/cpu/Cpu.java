package fr.tangv.mtemu.cpu;

import fr.tangv.mtemu.bus.Bus;

public interface Cpu<T extends Bus<?, ?>> {

	public T getBus();
	public String getName();
	
}
