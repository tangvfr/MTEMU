package fr.tangv.mtnes.cpu;

import fr.tangv.mtemu.cpu.Cpu;
import fr.tangv.mtnes.bus.Bus2A03;
import fr.tangv.mtnes.opcode.Opcode2A03;

public class Cpu2A03 implements Cpu<Bus2A03> {

	public static final byte FLAG_C = 0b0000_0001;//Carry
	public static final byte FLAG_Z = 0b0000_0010;//Zero
	public static final byte FLAG_I = 0b0000_0100;//Interrupt (IRQ disable)
	public static final byte FLAG_B = 0b0001_0000;//Break
	public static final byte FLAG_V = 0b0100_0000;//Overflow
	public static final byte FLAG_N = (byte) 0b1000_0000;//Negative
	
	public static final short NMI = (short) 0xFFFA;
	public static final short RESET = (short) 0xFFFC;
	public static final short IRQ = (short) 0xFFFE;
	
	//registre
	private static final String name = "Ricoh 2A03";
	private Bus2A03 bus;
	private Opcode2A03[] opcodes;
	private short pc;//PC	program counter	(16 bit)
	private byte ac;//AC	accumulator	(8 bit)
	private byte x;//X	X register	(8 bit)
	private byte y;//Y	Y register	(8 bit)
	private byte sp;//SP	stack pointer	(8 bit)
	private byte sr;//SR	status register [NV-BDIZC]	(8 bit)  D doesn't work on 2A03
	
	public Cpu2A03(Bus2A03 bus) {
		this.pc = 0;
		this.ac = 0;
		this.x = 0;
		this.y = 0;
		this.sp = (byte) 0xFF;
		this.sr = 0;
		this.bus = bus;
		this.opcodes = new Opcode2A03[0xFF];
		
	}
	
	public Byte stackPull() {
		sp++;
		return bus.read((short) (Bus2A03.STACK | sp));
	}
	
	public void stackPush(Byte data) {
		bus.write((short) (Bus2A03.STACK | sp), data);
		sp--;
	}

	public void setAC(Byte ac) {
		this.ac = ac;
	}
	
	public Byte getAC() {
		return this.ac;
	}
	
	public void setX(Byte x) {
		this.x = x;
	}
	
	public Byte getX() {
		return this.x;
	}
	
	public void setY(Byte y) {
		this.y = y;
	}
	
	public Byte getY() {
		return this.y;
	}
	
	public boolean isSetFlags(byte flags) {
		return (this.sr & flags) == flags;
	}
	
	public boolean isSetFlags(byte flags, byte result) {
		return (this.sr & flags) == result;
	}
	
	public void setFlags(byte flags, byte set) {
		this.sr = (byte) ((this.sr & ~flags) | set);
	}
	
	public void setFlags(byte flags) {
		this.sr |= flags;
	}
	
	public void clearFlags(byte flags) {
		this.sr &= ~flags;
	}
	
	@Override
	public Bus2A03 getBus() {
		return null;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return Cpu2A03.name + " [bus=" + this.bus + ", opcodes=" + this.opcodes.length + ", pc=" + this.pc + ", ac=" 
				+ this.ac + ", x=" + this.x + ", y=" + this.y + ", sp=" + this.sp + ", sr=" + this.sr + "]";
	}
	
}
