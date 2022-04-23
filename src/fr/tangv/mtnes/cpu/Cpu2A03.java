package fr.tangv.mtnes.cpu;

import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.cpu.Cpu;
import fr.tangv.mtnes.bus.Bus2A03;
import fr.tangv.mtnes.opcode.AbstarctOpcode2A03NCC;
import fr.tangv.mtnes.opcode.BranchOpcode2A03;
import fr.tangv.mtnes.opcode.BusDataProvider;
import fr.tangv.mtnes.opcode.OpcodeADC;
import fr.tangv.mtnes.opcode.OpcodeAND;
import fr.tangv.mtnes.opcode.OpcodeASL;
import fr.tangv.mtnes.opcode.OpcodeBIT;
import fr.tangv.mtnes.opcode.OpcodeBRK;
import fr.tangv.mtnes.opcode.OpcodeCMP;
import fr.tangv.mtnes.opcode.OpcodeCPX;
import fr.tangv.mtnes.opcode.OpcodeCPY;
import fr.tangv.mtnes.opcode.OpcodeDEC;
import fr.tangv.mtnes.opcode.OpcodeDEX;
import fr.tangv.mtnes.opcode.OpcodeDEY;
import fr.tangv.mtnes.opcode.SetFlagOpcode2A4;

public class Cpu2A03 extends Cpu<Bus2A03> {

	/*Flag Carry*/
	public static final byte FLAG_C = 0b0000_0001;
	/*Flag Zero*/
	public static final byte FLAG_Z = 0b0000_0010;
	/*Flag Interrupt (IRQ disable)*/
	public static final byte FLAG_I = 0b0000_0100;
	/*Flag Decimal mode, Dont work*/
	public static final byte FLAG_D = 0b0000_1000;
	/*Flag Break*/
	public static final byte FLAG_B = 0b0001_0000;
	/*Flag Overflow*/
	public static final byte FLAG_V = 0b0100_0000;
	/*Flag Negative*/
	public static final byte FLAG_N = (byte) 0b1000_0000;
	
	//interuption address
	public static final short NMI_ADR_LOW = (short) 0xFFFA;
	public static final short NMI_ADR_HIGH = (short) 0xFFFB;
	public static final short RES_ADR_LOW = (short) 0xFFFC;
	public static final short RES_ADR_HIGH = (short) 0xFFFD;
	public static final short IRQ_ADR_LOW = (short) 0xFFFE;
	public static final short IRQ_ADR_HIGH = (short) 0xFFFF;
	
	//registre
	private AbstarctOpcode2A03NCC[] opcodes;
	/*PC	program counter	(16 bit)*/
	private short pc;
	/*AC	accumulator	(8 bit)*/
	private BusData<Byte> ac;
	/*X	X register	(8 bit)*/
	private byte x;
	/*Y	Y register	(8 bit)*/
	private byte y;
	/*SP stack pointer	(8 bit)*/
	private byte sp;
	/*SR status register [NV-BDIZC]	(8 bit)  D doesn't work on 2A03*/
	private byte sr;
	
	
	public Cpu2A03(Bus2A03 bus) {
		super("Ricoh 2A03", bus);
		this.ac = new BusData<Byte>((byte) 0);
		reset();
		this.opcodes = new AbstarctOpcode2A03NCC[0xFF];
		//opcodes
		//ADC
		new OpcodeADC(this, BusDataProvider.IMMEDIATE, (byte) 0x69, 2);
		new OpcodeADC(this, BusDataProvider.ZEROPAGE, (byte) 0x65, 3);
		new OpcodeADC(this, BusDataProvider.ZEROPAGE_X, (byte) 0x75, 4);
		new OpcodeADC(this, BusDataProvider.ABSOLUTE, (byte) 0x6D, 4);
		new OpcodeADC(this, BusDataProvider.ABSOLUTE_X, (byte) 0x7D, 4);
		new OpcodeADC(this, BusDataProvider.ABSOLUTE_Y, (byte) 0x79, 4);
		new OpcodeADC(this, BusDataProvider.INDIRECT_X, (byte) 0x61, 6);
		new OpcodeADC(this, BusDataProvider.INDIRECT_Y, (byte) 0x71, 5);
		//AND
		new OpcodeAND(this, BusDataProvider.IMMEDIATE, (byte) 0x29, 2);
		new OpcodeAND(this, BusDataProvider.ZEROPAGE, (byte) 0x25, 3);
		new OpcodeAND(this, BusDataProvider.ZEROPAGE_X, (byte) 0x35, 4);
		new OpcodeAND(this, BusDataProvider.ABSOLUTE, (byte) 0x2D, 4);
		new OpcodeAND(this, BusDataProvider.ABSOLUTE_X, (byte) 0x3D, 4);
		new OpcodeAND(this, BusDataProvider.ABSOLUTE_Y, (byte) 0x39, 4);
		new OpcodeAND(this, BusDataProvider.INDIRECT_X, (byte) 0x21, 6);
		new OpcodeAND(this, BusDataProvider.INDIRECT_Y, (byte) 0x31, 5);
		//ASL
		new OpcodeASL(this, BusDataProvider.ACCUMULATOR, (byte) 0x0A, 2);
		new OpcodeASL(this, BusDataProvider.ZEROPAGE, (byte) 0x06, 5);
		new OpcodeASL(this, BusDataProvider.ZEROPAGE_X, (byte) 0x16, 6);
		new OpcodeASL(this, BusDataProvider.ABSOLUTE, (byte) 0x0E, 6);
		new OpcodeASL(this, BusDataProvider.ABSOLUTE_X, (byte) 0x1E, 7);
		//BCC
		new BranchOpcode2A03(this, Cpu2A03.FLAG_C, false, (byte) 0x90, 2);
		//BCS
		new BranchOpcode2A03(this, Cpu2A03.FLAG_C, true, (byte) 0xB0, 2);
		//BEQ
		new BranchOpcode2A03(this, Cpu2A03.FLAG_Z, true, (byte) 0xF0, 2);
		//BIT
		new OpcodeBIT(this, BusDataProvider.ZEROPAGE, (byte) 0x24, 3);
		new OpcodeBIT(this, BusDataProvider.ABSOLUTE, (byte) 0x2C, 4);
		//BMI
		new BranchOpcode2A03(this, Cpu2A03.FLAG_N, true, (byte) 0x30, 2);
		//BNE
		new BranchOpcode2A03(this, Cpu2A03.FLAG_Z, false, (byte) 0xD0, 2);
		//BPL
		new BranchOpcode2A03(this, Cpu2A03.FLAG_N, false, (byte) 0x10, 2);
		//BRK
		new OpcodeBRK(this, (byte) 0x00, 7);
		//BVC
		new BranchOpcode2A03(this, Cpu2A03.FLAG_V, false, (byte) 0x50, 2);
		//BVS
		new BranchOpcode2A03(this, Cpu2A03.FLAG_V, true, (byte) 0x70, 2);
		//CLC
		new SetFlagOpcode2A4(this, Cpu2A03.FLAG_C, false, (byte) 0x18, 2);
		//CLD
		new SetFlagOpcode2A4(this, Cpu2A03.FLAG_D, false, (byte) 0xD8, 2);
		//CLI
		new SetFlagOpcode2A4(this, Cpu2A03.FLAG_I, false, (byte) 0x58, 2);
		//CLV
		new SetFlagOpcode2A4(this, Cpu2A03.FLAG_V, false, (byte) 0xB8, 2);
		//CMP
		new OpcodeCMP(this, BusDataProvider.IMMEDIATE, (byte) 0xC9, 2);
		new OpcodeCMP(this, BusDataProvider.ZEROPAGE, (byte) 0xC5, 3);
		new OpcodeCMP(this, BusDataProvider.ZEROPAGE_X, (byte) 0xD5, 4);
		new OpcodeCMP(this, BusDataProvider.ABSOLUTE, (byte) 0xCD, 4);
		new OpcodeCMP(this, BusDataProvider.ABSOLUTE_X, (byte) 0xDD, 4);
		new OpcodeCMP(this, BusDataProvider.ABSOLUTE_Y, (byte) 0xD9, 4);
		new OpcodeCMP(this, BusDataProvider.INDIRECT_X, (byte) 0xC1, 6);
		new OpcodeCMP(this, BusDataProvider.INDIRECT_Y, (byte) 0xD1, 5);
		//CPX
		new OpcodeCPX(this, BusDataProvider.IMMEDIATE, (byte) 0xE0, 2);
		new OpcodeCPX(this, BusDataProvider.ZEROPAGE, (byte) 0xE4, 3);
		new OpcodeCPX(this, BusDataProvider.ABSOLUTE, (byte) 0xEC, 4);
		//CPY
		new OpcodeCPY(this, BusDataProvider.IMMEDIATE, (byte) 0xC0, 2);
		new OpcodeCPY(this, BusDataProvider.ZEROPAGE, (byte) 0xC4, 3);
		new OpcodeCPY(this, BusDataProvider.ABSOLUTE, (byte) 0xCC, 4);
		//DEC
		new OpcodeDEC(this, BusDataProvider.ZEROPAGE, (byte) 0xC6, 5);
		new OpcodeDEC(this, BusDataProvider.ZEROPAGE_X, (byte) 0xD6, 6);
		new OpcodeDEC(this, BusDataProvider.ABSOLUTE, (byte) 0xCE, 6);
		new OpcodeDEC(this, BusDataProvider.ABSOLUTE_X, (byte) 0xDE, 7);
		//DEX
		new OpcodeDEX(this, (byte) 0xCA, 2);
		//DEY
		new OpcodeDEY(this, (byte) 0x88, 2);
		//EOR
		
		
		//new Opcode(this, BusDataProvider., (byte) 0x, );
	}
	
	
	public void setOpcode(AbstarctOpcode2A03NCC opcode) {
		int adr = Byte.toUnsignedInt(opcode.getCode());
		if (this.opcodes[adr] != null)
			throw new IllegalArgumentException("Opcode with code " + Integer.toHexString(adr) + " is already set !");
		this.opcodes[adr] = opcode;
	}
	
	public void reset() {
		this.pc = Bus2A03.PRG_ROM_LOW;
		this.ac.setData((byte) 0);
		this.x = 0;
		this.y = 0;
		this.sp = (byte) 0xFF;
		this.sr = 0;
	}
	
	public Byte nextPC() {
		Byte data = this.getBus().read(pc);
		pc++;
		return data;
	}
	
	public BusData<Byte> nextCellPC() {
		BusData<Byte> data = this.getBus().getCell(pc);
		pc++;
		return data;
	}
	
	public void setPC(short pc) {
		this.pc = pc;
	}
	
	public void addPC(byte b) {//signed byte
		this.pc += b;
	}
	
	public short getPC() {
		return this.pc;
	}
	
	public void setPC(byte low, byte high) {
		this.pc = ((short) (low | (high << 8)));
	}
	
	public byte getPCLow() {
		return (byte) (this.pc & 0x00FF);
	}
	
	public byte getPCHigh() {
		return (byte) ((this.pc >>> 8) & 0x00FF);
	}
	
	public Byte stackPull() {
		sp++;
		return this.getBus().read((short) (Bus2A03.STACK | sp));
	}
	
	public void stackPush(Byte data) {
		this.getBus().write((short) (Bus2A03.STACK | sp), data);
		sp--;
	}
	
	public byte getSP() {
		return sp;
	}
	
	public BusData<Byte> getAC() {
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
	
	public byte getSR() {
		return this.sr;
	}
	
	public void setSR(byte sr) {
		this.sr = sr;
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
	public String toString() {
		return this.getName() + " [bus=" + this.getBus() + ", opcodes=" + this.opcodes.length + ", pc=" + this.pc + ", ac=" 
				+ this.ac + ", x=" + this.x + ", y=" + this.y + ", sp=" + this.sp + ", sr=" + this.sr + "]";
	}
	
}
