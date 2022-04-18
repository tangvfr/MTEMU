package fr.tangv.mtcbs;

import java.io.IOException;

import fr.tangv.mtcbs.castridge.FileNESCartridge;
import fr.tangv.mtcbs.castridge.NESCartridge;

public class Main {

	public static void main(String[] args) {
		System.out.println("Test 1");
		try {
			NESCartridge nesc = new FileNESCartridge(args[0]);
			System.out.println("PrgRomSize: " + nesc.getPrgRomSize());
			System.out.println("Mapper: " + nesc.getMapperNumber());
			System.out.println(nesc.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
