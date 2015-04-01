package dao;

import java.util.List;

public interface TicketInformationDAO {
	public List<TicketInformation> getInformation(long idAction);
}
