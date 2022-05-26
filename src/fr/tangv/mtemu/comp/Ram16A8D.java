package fr.tangv.mtemu.comp;

import java.io.IOException;
import java.io.InputStream;

import fr.tangv.mtemu.bus.BusDataRW;
import fr.tangv.mtemu.bus.BusIOException;

public class Ram16A8D extends Memory16A8D<BusDataRW<Byte>> {

	public Ram16A8D(int size) {
		super(size);
		
		for (int i = 0; i < size; i++)
			this.memory[i] = new BusDataRW<Byte>((byte) 0);
	}
	
	public Ram16A8D(byte[] data) {
		super(data.length);
		int size = data.length;
		
		
		for (int i = 0; i < size; i++)
			this.memory[i] = new BusDataRW<Byte>(data[i]);
	}
	
	public Ram16A8D(int size, InputStream in) throws BusIOException {
		super(size);
		try {
			for (int i = 0; i < size; i++) {
				int r = in.read();
				if (r == -1)
					throw new BusIOException("Length of InputStream is too small !");
				
				this.memory[i] = new BusDataRW<Byte>((byte) r);
			}
		} catch (IOException e) {
			throw new BusIOException(e);
		}
	}
	
}
