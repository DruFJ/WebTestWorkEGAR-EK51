package beans.actions;

import java.util.Date;

public class Concert extends Action {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Concert(long idAction, String actionName, String annotation,
			String imagePatch, String address, Date startDate, int maxPosition,
			int cost) {
		super(idAction, actionName, annotation, imagePatch, address, startDate,
				maxPosition, cost);
	}

	public boolean setPosition(int position) {
		if (this.getMaxPosition() > position) {
			return true;
		}
		return false;
	}
}
