package fr.tangv.mtnes.opcode;

import fr.tangv.mtnes.cpu.Cpu2A03;

public abstract class Opcode2A03NCC extends Opcode2A03 {

	public Opcode2A03NCC(Cpu2A03 cpu, GetterBusData getter, Byte code, int cycle) {
		super(cpu, getter, code, cycle);
	}

	@Override
	protected void add1CalcCycle() {}

	@Override
	protected void add2CalcCycle() {}

}
