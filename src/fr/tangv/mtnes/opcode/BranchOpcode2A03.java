package fr.tangv.mtnes.opcode;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.processor.NesCpu;

public class BranchOpcode2A03 extends AbstractOpcode2A03 {

	private byte flag;
	private boolean value;
	
	public BranchOpcode2A03(NesCpu cpu, byte flag, boolean value, Byte code, int cycle) {
		super(cpu, code, cycle);
		this.flag = flag;
		this.value = value;
	}
	
	@Override
	public int execute() throws BusIOException {
		this.resetCalcCycle();
		
		if (this.cpu.isSetFlags(flag) == value) {
			//calc relative
			short pc = (short) (0x00FF & cpu.getPC());
			short adr = (short) (pc + cpu.addGetPC());//sign use
			if ((pc & 0xFF00) == (adr & 0xFF00))//same page
				this.add1CalcCycle();
			else
				this.add2CalcCycle();
			
			//jump
			this.cpu.setPC(adr);
		}
		
		return this.getCalcCycle();
	}

}
