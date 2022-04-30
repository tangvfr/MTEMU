package fr.tangv.mtnes;

import java.io.IOException;

import fr.tangv.mtnes.castridge.FileNesCartridge;
import fr.tangv.mtnes.castridge.NesCartridge;

public class Main {

	public static void main(String[] args) {
		System.out.println("Test 1");
		try {
			NesCartridge nesc = new FileNesCartridge(args[0]);
			System.out.println("PrgRomSize: " + nesc.getPrgRomSize());
			System.out.println("Mapper: " + nesc.getMapperNumber());
			System.out.println(nesc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
