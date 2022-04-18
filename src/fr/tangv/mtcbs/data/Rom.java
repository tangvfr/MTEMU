package fr.tangv.mtcbs.data;

/**
 * Rom est t'une cellule de stockage pouvant étre que lue
 * @author tangv
 */
public class Rom extends DataCell {

	/**
	 * Crée une Rom avec un stockage déjà définie
	 * @param data donnée définie
	 */
	public Rom(byte[] data) {
		super(data);
	}
	
	@Override
	public String toString() {
		return "Rom [size=" + this.size() + "]";
	}
	
}
