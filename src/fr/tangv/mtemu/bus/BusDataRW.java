package fr.tangv.mtemu.bus;

public class BusDataRW<T extends Number> extends BusData<T> {

	public BusDataRW(T data) {
		super(data);
	}

	public T getData() throws BusIOException {
		return this.data;
	}
	
	public void setData(T data) throws BusIOException {
		this.data = data;
	}
	
}
