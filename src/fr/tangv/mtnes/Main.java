package fr.tangv.mtnes;

import java.io.File;
import java.io.IOException;

import fr.tangv.mtemu.bus.BusIOException;
import fr.tangv.mtnes.castridge.rom.NesRomCartridge;
import fr.tangv.mtnes.castridge.rom.NesRomCartridgeFile;

public class Main {

	public static void main(String[] args) {
		System.out.println("Test 1");
		try {
			File[] files = new File(args[0]).listFiles();
			for (File file : files) {
				System.out.println("Game: " + file.getName());
				NesRomCartridge nesc = new NesRomCartridgeFile(file);
				System.out.println("PrgRomSize: " + nesc.getPrgRomSize());
				System.out.println("ChrRomSize: " + nesc.getChrRomSize());
				System.out.println("Mapper: " + nesc.getMapperNumber());
				System.out.println(nesc);
				System.out.println("----------------------------------");
			}
			
			Nes nes = new Nes();
			nes.getCpu().powerUp();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BusIOException e) {
			e.printStackTrace();
		}
	}
	
}
