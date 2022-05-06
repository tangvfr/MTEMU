package fr.tangv.mtemu.bus;

public abstract class AbstractBusDataW<T extends Number> extends AbstractBusData<T> {

	public AbstractBusDataW(T data) {
		super(data);
	}

	public T getData() throws BusIOException {
		throw new BusIOException("Reading is disallow !");
	}
	
	public abstract void setData(T data) throws BusIOException;
	
}
