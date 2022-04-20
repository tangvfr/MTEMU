package fr.tangv.mtemu.cpu;

import fr.tangv.mtemu.bus.Bus;

public abstract class Cpu<T extends Bus<?, ?>> {

	private String name;
	private T bus;
	
	
	public Cpu(String name, T bus) {
		this.name = name;
		this.bus = bus;
	}
	
	
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
