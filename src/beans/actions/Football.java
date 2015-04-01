package beans.actions;

import java.util.Date;

public class Football extends Action {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int[][] sectorQuantity;

	public Football(long idAction, String actionName, String annotation,
			String imagePatch, String address, Date startDate, int maxPosition,
			int cost, int[][] sectorQuantity) {
		super(idAction, actionName, annotation, imagePatch, address, startDate,
				maxPosition, cost);
		this.sectorQuantity = sectorQuantity;
	}

	public int[][] getSectorQuantity() {
		return sectorQuantity;
	}

	public int getSector(int position) {
		int sum = 0;
		int result = 0;
		for (int sector = 0; sector < sectorQuantity.length; sector++) {
			if (position >= sum) {
				result = sector;
			}
			for (int row = 0; row < sectorQuantity[sector].length; row++) {
				sum += sectorQuantity[sector][row];
			}
		}
		return result;
	}

	public int getRow(int position) {
		int sum = 0;
		int result = 0;
		for (int sector = 0; sector < sectorQuantity.length; sector++) {
			for (int row = 0; row < sectorQuantity[sector].length; row++) {
				if (position >= sum) {
					result = row;
				}
				sum += sectorQuantity[sector][row];
			}
		}
		return result;
	}

	public int getPlace(int position) {
		int sum = 0;
		int result = 0;
		for (int sector = 0; sector < sectorQuantity.length; sector++) {
			for (int row = 0; row < sectorQuantity[sector].length; row++) {
				if (position >= sum + sectorQuantity[sector][row]) {
					result = position - sum;
				}
				sum += sectorQuantity[sector][row];
			}
		}
		return result;
	}

	public int getPosition(int sector, int row, int place) {
		int position = 0;
		for (int i = 0; i < sector; i++) {
			for (int j = 0; j < row; j++) {
				position += sectorQuantity[i][j];
			}
		}
		position += place;
		return position;
	}
}
