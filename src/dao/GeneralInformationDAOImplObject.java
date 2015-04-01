package dao;

import beans.actions.Action;

public class GeneralInformationDAOImplObject {
	GeneralInformation information;

	public GeneralInformationDAOImplObject() {
		super();
		information = new GeneralInformation();
	}

	public GeneralInformation getInformation(long idAction) throws Exception {
		ActionDAO action = new ActionDAOImpl();
		Action list = action.getAction(idAction);
		information = new GeneralInformation(list.getActionName(),
				list.getImagePatch(), list.getIdAction(), list.getAnnotation(),
				list.getStartDate(), list.getAddress(), list.getCost());
		return information;
	}

	public GeneralInformation getInformation() {
		return information;
	}

	public void setInformation(GeneralInformation information) {
		this.information = information;
	}

}
