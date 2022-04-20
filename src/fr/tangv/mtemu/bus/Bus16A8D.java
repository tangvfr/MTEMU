package fr.tangv.mtemu.bus;

public class Bus16A8D implements Bus<Short, Byte> {

	private final static int ADR_SIZE = 16;
	private final static int DATA_NUMBER = 65_536;//2^16
	private BusData<Byte>[] data;
	
	@SuppressWarnings("unchecked")
	public Bus16A8D() {
		this.data = new BusData[Bus16A8D.DATA_NUMBER];
	}
	
	@Override
	public Byte read(Short adr) {
		return this.data[Short.toUnsignedInt(adr)].getData();
	}
	
	@Override
	public void write(Short adr, Byte data) {
		this.data[Short.toUnsignedInt(adr)].setData(data);
	}
	
	@Override
	public BusData<Byte> getCell(Short adr) {
		return this.data[Short.toUnsignedInt(adr)];
	}
	
	@Override
	public void setCell(Short adr, BusData<Byte> cell) {
		this.data[Short.toUnsignedInt(adr)] = cell;
	}
	
	@Override
	public int adrSize() {
		return Bus16A8D.ADR_SIZE;
	}
	
	public int dataNumber() {
		return Bus16A8D.DATA_NUMBER;
	}

	@Override
	public String toString() {
		int udef = 0;
		for (BusData<Byte> data : this.data) {
			if (data == null)
				udef++;
		}
		return "Bus16A8D ["+udef+" BusData is not define]";
	}
	
}
