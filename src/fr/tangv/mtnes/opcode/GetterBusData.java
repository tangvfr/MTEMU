package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtnes.bus.Bus2A03;
import fr.tangv.mtnes.cpu.Cpu2A03;

@FunctionalInterface
public interface GetterBusData {

	public BusData<Byte> getBusData(Opcode2A03 op, Cpu2A03 cpu, Bus2A03 bus);
	
}
