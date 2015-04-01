package dao;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

import beans.actions.Action;

public class TicketInformationDAOImpl implements TicketInformationDAO {
	private List<TicketInformation> information;

	public TicketInformationDAOImpl() {
		super();
		this.information = new ArrayList<TicketInformation>();
	}

	@Override
	public List<TicketInformation> getInformation(long idAction) {
		ActionDAO action = new ActionDAOImpl();
		Action list = action.getAction(idAction);
		try {
			for (int i = 0; i < list.getTickets().size(); i++) {
				TicketInformation tmp = new TicketInformation(list.getTickets()
						.get(i).getPosition(), list.getTickets().get(i)
						.getDateSold());
				information.add(tmp);
			}
		} catch (EOFException e) {
			e.printStackTrace();
		}
		return information;
	}

}
