package fr.tangv.mtemu.bus;

public class BusDataR<T extends Number> extends AbstractBusData<T> {

	public BusDataR(T data) {
		super(data);
	}

	public T getData() throws BusIOException {
		return this.data;
	}
	
	public void setData(T data) throws BusIOException {
		throw new BusIOException("Writing is disallow !");
	}
	
}
