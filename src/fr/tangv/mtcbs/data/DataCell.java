package fr.tangv.mtcbs.data;

/**
 * Data est t'une cellule de stockage (stocké en RAM)
 * @author tangv
 */
public abstract class DataCell {
	
	/*donnée sauvegardé*/
	protected byte[] data;	
	
	/**
	 * Crée une cellule de sauvegarde vierge
	 * @param size taille de la cellule
	 */
	public DataCell(int size) {
		this.data = new byte[size];
	}
	
	/**
	 * Crée une cellule de sauvegarde avec un stockage déjà définie
	 * @param data donnée définie
	 */
	public DataCell(byte[] data) {
		this.data = data;
	}
	
	/** 
	 * Méthode qui permet de lire é une adresse dans l'unité de stockage
	 * @param adr adresse où élire
	 * @return donnée lue
	 */
	public byte read(int adr) {
		return this.data[adr];
	}
	
	/**
	 * Méthode qui permet de savoir la taille de la cellule
	 * @return taille de la cellule
	 */
	public int size() {
		return data.length;
	}

	@Override
	public String toString() {
		return "DataCell [size=" + this.size() + "]";
	}
	
}
