package fr.tangv.mtemu.bus;

public class BusDataD<T extends Number> implements BusData<T> {

	public T getData() throws BusIOException {
		throw new BusIOException("IO is disable !");
	}
	
	public void setData(T data) throws BusIOException {
		throw new BusIOException("IO is disable !");
	}
	
	@Override
	public String toString() {
		return "none";
	}
	
}
