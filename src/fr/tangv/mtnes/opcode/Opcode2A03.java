package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.opcode.Opcode;
import fr.tangv.mtnes.bus.Bus2A03;
import fr.tangv.mtnes.cpu.Cpu2A03;

public abstract class Opcode2A03 implements Opcode<Cpu2A03, Byte> {

	protected Cpu2A03 cpu;
	protected Bus2A03 bus;
	private Byte code;
	private int cycle;
	
	public Opcode2A03(Cpu2A03 cpu, Byte code, int cycle) {
		this.cpu = cpu;
		this.bus = this.cpu.getBus();
		this.code = code;
		this.cycle = cycle;
		this.cpu.setOpcode(this);
	}
	
	public short adrAbsolute() {
		return (short) (this.cpu.nextPC() | (this.cpu.nextPC() << 8));
	}
	
	public short adrAbsoluteX() {
		return (short) ((this.cpu.nextPC() | (this.cpu.nextPC() << 8)) + Byte.toUnsignedInt(this.cpu.getX()));
		//unsigned calc with carry
	}
	
	public short adrAbsoluteY() {
		return (short) ((this.cpu.nextPC() | (this.cpu.nextPC() << 8)) + Byte.toUnsignedInt(this.cpu.getY()));
		//unsigned calc with carry
	}
	
	public short adrIndirect() {
		short adr = (short) (this.cpu.nextPC() | (this.cpu.nextPC() << 8));
		return (short) (this.bus.read(adr) | (this.bus.read((short) (adr + 1)) << 8));
	}
	
	public short adrXIndirect() {
		short adr = (byte) (this.cpu.nextPC() + this.cpu.getX());
		return (short) (this.bus.read(adr) | (this.bus.read((short) (adr + 1)) << 8));
		//unsigned without carry
	}
	
	public short adrIndirectY() {
		short adr = (byte) this.cpu.nextPC();
		return (short) ((this.bus.read(adr) | (this.bus.read((short) (adr + 1)) << 8)) + Byte.toUnsignedInt(this.cpu.getY()));
		//unsigned with carry
	}
	
	public short adrRelative() {
		return (short) (this.cpu.getPC() + this.cpu.nextPC());
		//signed calc
	}
	
	public short adrZeroPage() {
		return (byte) this.cpu.nextPC();
		//return (short) (/*Bus2A03.ZERO_PAGE | */this.cpu.nextPC());
	}
	
	public short adrZeroPageX() {
		return (byte) (this.cpu.nextPC() + Byte.toUnsignedInt(this.cpu.getX()));
		//return (short) (/*Bus2A03.ZERO_PAGE | (byte) */(this.cpu.nextPC() + Byte.toUnsignedInt(this.cpu.getX())));
		//unsigned calc without carry
	}
	
	public short adrZeroPageY() {
		return (byte) (this.cpu.nextPC() + Byte.toUnsignedInt(this.cpu.getY()));
		//return (short) (/*Bus2A03.ZERO_PAGE | (byte) */(this.cpu.nextPC() + Byte.toUnsignedInt(this.cpu.getY())));
		//unsigned calc without carry
	}
	
	public void setNZFlag(Byte data) {
		byte sr = 0;
		if (data == 0)
			sr |= Cpu2A03.FLAG_Z;
		sr |= (data & 0b1000_0000);
		this.cpu.setFlags((byte) (Cpu2A03.FLAG_Z | Cpu2A03.FLAG_N), sr);
	}
	
	public void setNZCFlag(Byte data, boolean c) {
		byte sr = 0;
		if (data == 0)
			sr |= Cpu2A03.FLAG_Z;
		sr |= (data & 0b1000_0000);
		if (c)
			sr |= Cpu2A03.FLAG_C;
		this.cpu.setFlags((byte) (Cpu2A03.FLAG_Z | Cpu2A03.FLAG_N | Cpu2A03.FLAG_C), sr);
	}
	
	@Override
	public Cpu2A03 getCpu() {
		return this.cpu;
	}
	
	@Override
	public Byte getCode() {
		return code;
	}
	
	@Override
	public int numberCycle() {
		return cycle;
	}

}
