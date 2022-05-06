package fr.tangv.mtemu.bus;

public class InternBusDataW<T extends Number> extends AbstractBusDataW<T> {

	public InternBusDataW(T data) {
		super(data);
	}
	
	@Override
	public void setData(T data) throws BusIOException {
		this.data = data;
	}
	
	public T getDataIntern() {
		return this.data;
	}
	
}
