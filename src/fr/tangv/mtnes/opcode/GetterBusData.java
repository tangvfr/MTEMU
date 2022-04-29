package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.bus.Bus2A03;
import fr.tangv.mtnes.cpu.Cpu2A03;

@FunctionalInterface
public interface GetterBusData {

	public BusData<Byte> getBusData(AbstractOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) throws BusIOException;
	
}
