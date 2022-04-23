package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.opcode.Opcode;
import fr.tangv.mtnes.cpu.Cpu2A03;

public abstract class AbstarctOpcode2A03 implements Opcode<Cpu2A03, Byte> {

	public static final byte FLAGS_ZN = (byte) (Cpu2A03.FLAG_Z | Cpu2A03.FLAG_N);
	public static final byte FLAGS_ZNC = (byte) (Cpu2A03.FLAG_Z | Cpu2A03.FLAG_N | Cpu2A03.FLAG_C);
	public static final byte FLAGS_ZC = (byte) (Cpu2A03.FLAG_Z | Cpu2A03.FLAG_C);
	public static final byte FLAGS_ZNCV = (byte) (Cpu2A03.FLAG_Z | Cpu2A03.FLAG_N | Cpu2A03.FLAG_C | Cpu2A03.FLAG_V);
	
	protected final Cpu2A03 cpu;
	private final Byte code;
	private final int cycle;
	private int cycleCalc;
	
	public AbstarctOpcode2A03(Cpu2A03 cpu, Byte code, int cycle) {
		if (cpu == null)
			throw new IllegalArgumentException("Cpu is NULL !");
		if (code == null)
			throw new IllegalArgumentException("Code is NULL !");
		
		this.cpu = cpu;
		this.code = code;
		this.cycle = cycle;
		this.cpu.setOpcode(this);
	}
	
	protected void resetCalcCycle() {
		this.cycleCalc = cycle;
	}
	
	protected void add1CalcCycle() {
		this.cycleCalc++;
	}
	
	protected void add2CalcCycle() {
		this.cycleCalc += 2;
	}
	
	protected int getCalcCycle() {
		return this.cycleCalc;
	}
	
	public void setNZFlag(Byte data) {
		byte sr = 0;
		if (data == 0)
			sr |= Cpu2A03.FLAG_Z;
		sr |= (data & 0b1000_0000);
		this.cpu.setFlags(AbstarctOpcode2A03.FLAGS_ZN, sr);
	}
	
	public void setNZCFlag(Byte data, boolean c) {
		byte sr = 0;
		if (data == 0)
			sr |= Cpu2A03.FLAG_Z;
		sr |= (data & 0b1000_0000);
		if (c)
			sr |= Cpu2A03.FLAG_C;
		this.cpu.setFlags(AbstarctOpcode2A03.FLAGS_ZNC, sr);
	}
	
	public void setNZCVFlag(Byte data, boolean c, boolean v) {
		byte sr = 0;
		if (data == 0)
			sr |= Cpu2A03.FLAG_Z;
		sr |= (data & 0b1000_0000);
		if (c)
			sr |= Cpu2A03.FLAG_C;
		if (v)
			sr |= Cpu2A03.FLAG_V;
		this.cpu.setFlags(AbstarctOpcode2A03.FLAGS_ZNCV, sr);
	}
	
	@Override
	public Cpu2A03 getCpu() {
		return this.cpu;
	}
	
	@Override
	public Byte getCode() {
		return code;
	}

}
