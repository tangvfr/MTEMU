package fr.tangv.mtcbs.data;

/**
 * Ram est t'une cellule de stockage pouvantétre lue et écrite
 * @author tangv
 */
public class Ram extends DataCell {

	/**
	 * Crée une Ram vierge
	 * @param size taille de la cellule
	 */
	public Ram(int size) {
		super(size);
	}
	
	/**
	 * Crée une Ram avec un stockage déja définie
	 * @param data donnée définie
	 */
	public Ram(byte[] data) {
		super(data);
	}
	
	/** 
	 * Méthode qui permet d'écrire à une adresse dans l'unité de stockage
	 * @param adr adresse où écrire
	 * @param data donnée à écrire
	 */
	public void write(int adr, byte data) {
		this.data[adr] = data;
	}

}
