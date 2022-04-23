package fr.tangv.mtnes.opcode;

import fr.tangv.mtnes.cpu.Cpu2A03;

public abstract class AbstractOpcode2A03 extends AbstractOpcode2A03NCC {

	private int calcCycle;

	public AbstractOpcode2A03(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	protected void resetCalcCycle() {
		this.calcCycle = this.getCycle();
	}
	
	protected void add1CalcCycle() {
		this.calcCycle++;
	}
	
	protected void add2CalcCycle() {
		this.calcCycle += 2;
	}
	
	protected int getCalcCycle() {
		return this.calcCycle;
	}
	
}
