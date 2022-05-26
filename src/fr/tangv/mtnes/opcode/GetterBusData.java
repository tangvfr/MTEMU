package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.bus.NesBus;
import fr.tangv.mtnes.processor.NesCpu;

@FunctionalInterface
public interface GetterBusData {

	public BusData<Byte> getBusData(AbstractOpcode2A03NCC op, NesCpu cpu, NesBus bus) throws BusIOException;
	
}
