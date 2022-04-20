package fr.tangv.mtnes;

import java.io.IOException;

import fr.tangv.mtnes.castridge.FileNESCartridge;
import fr.tangv.mtnes.castridge.NESCartridge;

public class Main {

	public static void main(String[] args) {
		System.out.println("Test 1");
		try {
			NESCartridge nesc = new FileNESCartridge(args[0]);
			System.out.println("PrgRomSize: " + nesc.getPrgRomSize());
			System.out.println("Mapper: " + nesc.getMapperNumber());
			System.out.println(nesc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
