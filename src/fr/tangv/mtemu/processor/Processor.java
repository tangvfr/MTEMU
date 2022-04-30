package fr.tangv.mtemu.processor;

import fr.tangv.mtemu.bus.Bus;
import fr.tangv.mtemu.bus.BusIOException;

public abstract class Processor<T extends Bus<?, ?>> {

	private String name;
	private T bus;
	
	
	public Processor(String name, T bus) {
		this.name = name;
		this.bus = bus;
	}
	
	
	public abstract int runCycle() throws BusIOException;
	
	public T getBus() {
		return bus;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.getName() + " [bus=" + this.getBus() + "]";
	}
	
}
