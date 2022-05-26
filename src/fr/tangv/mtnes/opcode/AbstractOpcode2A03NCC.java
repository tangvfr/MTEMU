package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.opcode.Opcode;
import fr.tangv.mtnes.processor.NesCpu;

public abstract class AbstractOpcode2A03NCC implements Opcode<NesCpu, Byte> {

	public static final byte FLAGS_ZN = (byte) (NesCpu.FLAG_Z | NesCpu.FLAG_N);
	public static final byte FLAGS_ZNC = (byte) (NesCpu.FLAG_Z | NesCpu.FLAG_N | NesCpu.FLAG_C);
	public static final byte FLAGS_ZNCV = (byte) (NesCpu.FLAG_Z | NesCpu.FLAG_N | NesCpu.FLAG_C | NesCpu.FLAG_V);
	
	protected final NesCpu cpu;
	private final Byte code;
	private final int cycle;
	private boolean chPC = false;
	
	public AbstractOpcode2A03NCC(NesCpu cpu, Byte code, int cycle) {
		if (cpu == null)
			throw new IllegalArgumentException("Cpu is NULL !");
		if (code == null)
			throw new IllegalArgumentException("Code is NULL !");
		
		this.cpu = cpu;
		this.code = code;
		this.cycle = cycle;
		this.cpu.setOpcode(this);
	}
	
	protected void add1CalcCycle() {}
	
	protected void add2CalcCycle() {}
	
	protected int getCycle() {
		return this.cycle;
	}
	
	public void setChangePC() {
		this.chPC = true;
	}
	
	public boolean isChangePC() {
		return this.chPC;
	}
	
	public void setNZFlag(Byte data) {
		byte sr = 0;
		if (data == 0)
			sr |= NesCpu.FLAG_Z;
		sr |= (data & 0b1000_0000);
		this.cpu.setFlags(AbstractOpcode2A03NCC.FLAGS_ZN, sr);
	}
	
	public void setNZCFlag(Byte data, boolean c) {
		byte sr = 0;
		if (data == 0)
			sr |= NesCpu.FLAG_Z;
		sr |= (data & 0b1000_0000);
		if (c)
			sr |= NesCpu.FLAG_C;
		this.cpu.setFlags(AbstractOpcode2A03NCC.FLAGS_ZNC, sr);
	}
	
	public void setNZCVFlag(Byte data, boolean c, boolean v) {
		byte sr = 0;
		if (data == 0)
			sr |= NesCpu.FLAG_Z;
		sr |= (data & 0b1000_0000);
		if (c)
			sr |= NesCpu.FLAG_C;
		if (v)
			sr |= NesCpu.FLAG_V;
		this.cpu.setFlags(AbstractOpcode2A03NCC.FLAGS_ZNCV, sr);
	}
	
	@Override
	public NesCpu getCpu() {
		return this.cpu;
	}
	
	@Override
	public Byte getCode() {
		return code;
	}
	
}
