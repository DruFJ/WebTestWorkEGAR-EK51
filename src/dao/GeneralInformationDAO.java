package dao;

import java.util.List;

public interface GeneralInformationDAO {
	public List<GeneralInformation> getInformation(ActionDAO.ActionType type);
}
