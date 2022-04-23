package fr.tangv.mtnes.opcode;

import fr.tangv.mtnes.cpu.Cpu2A03;

public class BranchOpcode2A03 extends AbstractOpcode2A03 {

	private byte flag;
	private boolean value;
	
	public BranchOpcode2A03(Cpu2A03 cpu, byte flag, boolean value, Byte code, int cycle) {
		super(cpu, code, cycle);
		this.flag = flag;
		this.value = value;
	}
	
	@Override
	public int execute() {
		this.resetCalcCycle();
		
		if (this.cpu.isSetFlags(flag) == value) {
			//calc relative
			short pc = (short) (0x00FF & cpu.getPC());
			short adr = (short) (pc + cpu.nextPC());//sign use
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
