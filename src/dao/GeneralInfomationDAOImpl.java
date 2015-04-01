package dao;

import java.util.ArrayList;
import java.util.List;

import beans.actions.Action;

public class GeneralInfomationDAOImpl implements GeneralInformationDAO {
	List<GeneralInformation> information;

	public GeneralInfomationDAOImpl() {
		super();
		information = new ArrayList<GeneralInformation>();
	}

	@Override
	public List<GeneralInformation> getInformation(ActionDAO.ActionType type) {
		List<Action> list = new ArrayList<Action>();
		ActionDAO action = new ActionDAOImpl();
		list.addAll(action.getTypeAction(type));
		for (int i = 0; i < list.size(); i++) {
			GeneralInformation tmp = new GeneralInformation(list.get(i)
					.getActionName(), list.get(i).getImagePatch(), list.get(i)
					.getIdAction());
			information.add(tmp);
		}
		return information;
	}

	public List<GeneralInformation> getInformation() {
		return information;
	}

	public void setInformation(List<GeneralInformation> information) {
		this.information = information;
	}

}
