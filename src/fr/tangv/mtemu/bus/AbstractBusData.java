package fr.tangv.mtemu.bus;

public abstract class AbstractBusData<T extends Number> implements BusData<T> {

	protected T data;
	
	public AbstractBusData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
}
