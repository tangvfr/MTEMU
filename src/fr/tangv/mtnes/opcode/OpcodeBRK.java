package fr.tangv.mtnes.opcode;

import fr.tangv.mtnes.cpu.Cpu2A03;

public class OpcodeBRK extends ImpliedOpcode2A03 {

	public OpcodeBRK(Cpu2A03 cpu, Byte code, int cycle) {
		super(cpu, code, cycle);
	}

	@Override
	protected void run() {
		this.cpu.addPC((byte) 2);
		this.cpu.stackPush(this.cpu.getPCHigh());
		this.cpu.stackPush(this.cpu.getPCLow());
		this.cpu.stackPush((byte) (this.getCpu().getSR() | 0b0011_0000));
		this.cpu.setFlags(Cpu2A03.FLAG_I);
		this.cpu.addPC((byte) -1);//for next PC
	}

}
