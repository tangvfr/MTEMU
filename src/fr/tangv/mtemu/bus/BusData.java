package fr.tangv.mtemu.bus;

public class BusData<T extends Number> {

	private T data;
	
	public BusData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
}
