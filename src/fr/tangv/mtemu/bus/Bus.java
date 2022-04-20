package fr.tangv.mtemu.bus;

public interface Bus<A extends Number, D extends Number> {
		
	public D read(A adr);
	public void write(A adr, D data);
	public BusData<D> getCell(A adr);
	public void setCell(A adr, BusData<D> cell);
	public int adrSize();

}
