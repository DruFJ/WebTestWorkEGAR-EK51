package beans.actions;

import java.util.Date;

public class Film extends Theater {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum TypeFilm {
		D2, D3
	}

	private TypeFilm typeFilm;

	public Film(long idAction, String nameAction, String annotation1,
			String imagePatch, String addressAction, Date dateStart,
			int positions, int cost, int[] rowsCapasityQuantity,
			TypeFilm typeFilm) {
		super(idAction, nameAction, annotation1, imagePatch, addressAction,
				dateStart, positions, cost, rowsCapasityQuantity);
		this.typeFilm = typeFilm;
	}

	public TypeFilm getTypeFilm() {
		return this.typeFilm;
	}

	public void setTypeFilm(TypeFilm typeFilm) {
		this.typeFilm = typeFilm;
	}

}
