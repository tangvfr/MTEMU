package fr.tangv.mtemu.bus;

public class InternBusDataR<T extends Number> extends BusDataR<T> {

	public InternBusDataR(T data) {
		super(data);
	}
	
	public void setDataIntern(T data) {
		this.data = data;
	}
	
}