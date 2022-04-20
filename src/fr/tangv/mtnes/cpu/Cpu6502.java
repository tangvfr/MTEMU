package fr.tangv.mtnes.cpu;

import java.nio.ByteBuffer;

import fr.tangv.mtemu.cpu.Cpu;
import fr.tangv.mtemu.opcode.Opcode;
import fr.tangv.mtnes.bus.Bus6502;

public class Cpu6502 extends Cpu {

	//registre
	
	private Bus6502 bus;
	private Opcode<Cpu6502>[] opcodes;
	private short pc;//PC	program counter	(16 bit)
	private byte ac;//AC	accumulator	(8 bit)
	private byte x;//X	X register	(8 bit)
	private byte y;//Y	Y register	(8 bit)
	private byte sp;//SP	stack pointer	(8 bit)
	private byte sr;//SR	status register [NV-BDIZC]	(8 bit)
	/*
	N	Negative
	V	Overflow
	-	ignored
	B	Break
	D	Decimal (use BCD for arithmetics)
	I	Interrupt (IRQ disable)
	Z	Zero
	C	Carry
	*/
	
	@SuppressWarnings("unchecked")
	public Cpu6502(Bus6502 bus) {
		this.pc = 0;
		this.ac = 0;
		this.x = 0;
		this.y = 0;
		this.sp = (byte) 0xFF;
		this.sr = 0;
		this.bus = bus;
		this.opcodes = new Opcode[0xFF];
		
	}
	
	public Byte stackPull() {
		sp--;
		return bus.read((short) (Bus6502.STACK | sp));
	}
	
	public void stackPush(Byte data) {
		bus.write((short) (Bus6502.STACK | sp), data);
		sp++;
	}
	
}
