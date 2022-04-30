package fr.tangv.mtemu.bus;

public class InternBusDataW<T extends Number> extends AbstractBusData<T> {

	public InternBusDataW(T data) {
		super(data);
	}

	public T getData() throws BusIOException {
		throw new BusIOException("Reading is disallow !");
	}
	
	public void setData(T data) throws BusIOException {
		this.data = data;
	}
	
	public T getDataIntern() {
		return this.data;
	}
	
}
