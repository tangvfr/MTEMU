package fr.tangv.mtemu.bus;

public abstract class AbstractBus<A extends Number, D extends Number> implements Bus<A, D> {

	@Override
	public D read(A adr) throws BusIOException {
		return this.getCell(adr).getData();
	}

	@Override
	public void write(A adr, D data) throws BusIOException {
		this.getCell(adr).setData(data);
	}
	
}
