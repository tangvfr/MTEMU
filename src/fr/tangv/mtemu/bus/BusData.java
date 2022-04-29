package fr.tangv.mtemu.bus;

public abstract class BusData<T extends Number> {

	protected T data;
	
	public BusData(T data) {
		this.data = data;
	}
	
	public abstract T getData() throws BusIOException;
	
	public abstract void setData(T data) throws BusIOException;

	@Override
	public String toString() {
		return data.toString();
	}
	
}
