package fr.tangv.mtemu.comp;

import fr.tangv.mtemu.bus.BusIOException;

public abstract class Processor {

	private String name;
	
	public Processor(String name) {
		this.name = name;
	}
	
	public abstract int runCycle() throws BusIOException;
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
}
