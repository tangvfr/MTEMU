package fr.tangv.mtnes.opcode;

import fr.tangv.mtnes.bus.Bus2A03;
import fr.tangv.mtnes.cpu.Cpu2A03;

public abstract class BusDataProvider {
	
	public static final GetterBusData ACCUMULATOR = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		return cpu.getAC();
	};
	
	public static final GetterBusData ABSOLUTE = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		return bus.getCell((short) (cpu.nextPC() | (cpu.nextPC() << 8)));
	};
	
	public static final GetterBusData ABSOLUTE_X = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		int adr = (cpu.nextPC() | (cpu.nextPC() << 8)) + Byte.toUnsignedInt(cpu.getX());
		if (adr > 0x0000_FFFF)
			op.add1CalcCycle();
		return bus.getCell((short) adr);
	};
	
	public static final GetterBusData ABSOLUTE_Y = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		int adr = (cpu.nextPC() | (cpu.nextPC() << 8)) + Byte.toUnsignedInt(cpu.getY());
		if (adr > 0x0000_FFFF)
			op.add1CalcCycle();
		return bus.getCell((short) adr);
	};
	
	public static final GetterBusData IMMEDIATE = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		return cpu.nextCellPC();
	};
	
	/*
	public static final GetterBusData IMPLIED = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		return null;
	};
	*/
	
	public static final GetterBusData INDIRECT	 = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		short adr = (short) (cpu.nextPC() | (cpu.nextPC() << 8));
		return bus.getCell((short) (bus.read(adr) | (bus.read((short) (adr + 1)) << 8)));
	};
	
	public static final GetterBusData INDIRECT_X = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		short adr = (byte) (cpu.nextPC() + cpu.getX());
		return bus.getCell((short) (bus.read(adr) | (bus.read((short) (adr + 1)) << 8)));
	};	
	
	public static final GetterBusData INDIRECT_Y = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		short adrT = (byte) cpu.nextPC();
		int adr = (bus.read(adrT) | (bus.read((short) (adrT + 1)) << 8)) + Byte.toUnsignedInt(cpu.getY());
		if (adr > 0x0000_FFFF)
			op.add1CalcCycle();
		return bus.getCell((short) adr);
	};
	
	/*
	public static final GetterBusData RELATIVE = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		short pc = (short) (0x00FF & cpu.getPC());
		short adr = (short) (pc + cpu.nextPC());//sign use
		if ((pc & 0xFF00) == (adr & 0xFF00))//same page
			op.add1CalcCycle();
		else
			op.add2CalcCycle();
		return bus.getCell((short) adr);// /!\ a tester
	};
	*/
	
	public static final GetterBusData ZEROPAGE = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		return bus.getCell((short) (0x00FF & cpu.nextPC()));
	};
	
	public static final GetterBusData ZEROPAGE_X = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		return bus.getCell((short) (Byte.toUnsignedInt(cpu.nextPC()) + Byte.toUnsignedInt(cpu.getX())));
	};
	
	public static final GetterBusData ZEROPAGE_Y = (AbstarctOpcode2A03NCC op, Cpu2A03 cpu, Bus2A03 bus) -> {
		return bus.getCell((short) (Byte.toUnsignedInt(cpu.nextPC()) + Byte.toUnsignedInt(cpu.getY())));
	};

	/*public short adrAbsolute() {
		return (short) (this.cpu.nextPC() | (this.cpu.nextPC() << 8));
	}
	
	public short adrAbsoluteX() {
		int adr = (this.cpu.nextPC() | (this.cpu.nextPC() << 8)) + Byte.toUnsignedInt(this.cpu.getX());
		if (adr > 0xFFFF)
			this.cycleCalc++;
		return (short) adr;
		//unsigned calc with carry
	}
	
	public short adrAbsoluteY() {
		int adr = (this.cpu.nextPC() | (this.cpu.nextPC() << 8)) + Byte.toUnsignedInt(this.cpu.getY());
		if (adr > 0xFFFF)
			this.cycleCalc++;
		return (short) adr;
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
		short adrT = (byte) this.cpu.nextPC();
		int adr = (this.bus.read(adrT) | (this.bus.read((short) (adrT + 1)) << 8)) + Byte.toUnsignedInt(this.cpu.getY());
		if (adr > 0xFFFF)
			this.cycleCalc++;
		return (short) adr;
		//unsigned with carry
	}
	
	public short adrRelative() {// /!\ a tester
		short pc = this.cpu.getPC();
		short adr = (short) (pc + this.cpu.nextPC());
		if ((pc & 0xFF00) == (adr & 0xFF00))//same page
			this.cycleCalc++;
		else
			this.cycleCalc += 2;
		return adr;
		//signed calc
	}
	
	public short adrZeroPage() {
		return (byte) this.cpu.nextPC();
		//return (short) (/*Bus2A03.ZERO_PAGE | *///this.cpu.nextPC());
	/*}
	
	public short adrZeroPageX() {
		return (byte) (this.cpu.nextPC() + Byte.toUnsignedInt(this.cpu.getX()));
		//return (short) (/*Bus2A03.ZERO_PAGE | (byte) *///(this.cpu.nextPC() + Byte.toUnsignedInt(this.cpu.getX())));
		//unsigned calc without carry
	/*}
	
	public short adrZeroPageY() {
		return (byte) (this.cpu.nextPC() + Byte.toUnsignedInt(this.cpu.getY()));
		//return (short) (/*Bus2A03.ZERO_PAGE | (byte) *///(this.cpu.nextPC() + Byte.toUnsignedInt(this.cpu.getY())));
		//unsigned calc without carry
	//}
	
}
