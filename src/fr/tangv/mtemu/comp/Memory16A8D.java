package fr.tangv.mtemu.comp;

import fr.tangv.mtemu.bus.Bus;
import fr.tangv.mtemu.bus.BusData;
import fr.tangv.mtemu.bus.BusIOException;

public abstract class Memory16A8D<T extends BusData<Byte>> implements Bus<Short, Byte> {

	protected BusData<Byte>[] memory;
	
	public Memory16A8D(BusData<Byte>[] memory) {
		if (memory.length > Short.toUnsignedInt(Short.MIN_VALUE))
			throw new IllegalArgumentException("Size is too length !");
		
		this.memory = memory;
	}
	
	@SuppressWarnings("unchecked")
	public Memory16A8D(int size) {
		if (size > Short.toUnsignedInt(Short.MIN_VALUE))
			throw new IllegalArgumentException("Size is too length !");
	
		this.memory = new BusData[size];
	}
	
	@Override
	public Byte read(Short adr) throws BusIOException {
		return this.getCell(adr).getData();
	}

	@Override
	public void write(Short adr, Byte data) throws BusIOException {
		this.getCell(adr).setData(data);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T getCell(Short adr) throws BusIOException {
		int address = Short.toUnsignedInt(adr);
		if (address > this.memory.length)
			throw new BusIOException("0x" + Integer.toHexString(adr) + " address is too high for this " 
					+ this.getClass().getSimpleName() + " with " + Integer.toHexString(this.memory.length) + " !");
		return (T) this.memory[address];
	}
	
	public short size() {
		return (short) this.memory.length;
	}
	
}
