package fr.tangv.mtemu.comp;

import fr.tangv.mtemu.bus.Bus;

public abstract class BusProcessor<T extends Bus<?, ?>> extends Processor {

	private T bus;
	
	public BusProcessor(String name, T bus) {
		super(name);
		this.bus = bus;
	}

	public T getBus() {
		return this.bus;
	}
	
	@Override
	public String toString() {
		return this.getName() + " [bus=" + this.getBus() + "]";
	}
	
}
