package fr.tangv.mtemu.bus;

public interface BusData<T extends Number> {
	
	public abstract T getData() throws BusIOException;
	public abstract void setData(T data) throws BusIOException;
	
}
