package fr.tangv.mtemu.bus;

public interface Bus<A extends Number, D extends Number> {
		
	public D read(A adr) throws BusIOException;
	public void write(A adr, D data) throws BusIOException;
	public BusData<D> getCell(A adr) throws BusIOException;

}
