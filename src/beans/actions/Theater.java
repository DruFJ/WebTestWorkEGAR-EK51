package beans.actions;

import java.util.Date;

public class Theater extends Action {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int[] rowsCapasityQuantity;

	public Theater(long idAction, String nameAction, String annotation1,
			String imagePatch, String addressAction, Date dateStart,
			int positions, int cost, int[] rowsCapasityQuantity) {
		super(idAction, nameAction, annotation1, imagePatch, addressAction,
				dateStart, positions, cost);
		this.rowsCapasityQuantity = rowsCapasityQuantity;
	}

	/* аналогично замечанию в Football.java */
	public int getRow(int position) {
		int sum = 0;
		int result = 0;
		for (int row = 0; row < rowsCapasityQuantity.length; row++) {
			if (position <= sum) {
				result = row;
			}
			sum += rowsCapasityQuantity[row];
		}
		return result;
	}

	public int getPlace(int position) {
		int sum = 0;
		int result = 0;
		for (int row = 0; row < rowsCapasityQuantity.length; row++) {
			sum += rowsCapasityQuantity[row];
			if (position >= sum) {
				result = position - (sum - rowsCapasityQuantity[row]);
			}
		}
		return result;
	}

	public int[] getRowsCapasityQuantity() {
		return rowsCapasityQuantity;
	}

	public int setPosition(int row, int place) {
		int position = 0;
		for (int i = 0; i < row; i++) {
			position += rowsCapasityQuantity[i];
		}
		position += place;
		return position;
	}
}
