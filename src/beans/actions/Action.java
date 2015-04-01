package beans.actions;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.tickets.Ticket;

public class Action implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idAction;
	private String actionName;
	private String annotation;
	private String imagePatch;
	private String address;
	private Date startDate;
	private int maxPosition;
	private int soldPosition;
	private int cost;
	private List<Ticket> tickets;

	public Action(long idAction, String actionName, String annotation,
			String imagePatch, String address, Date startDate, int maxPosition,
			int cost) {
		super();
		this.idAction = idAction;
		this.actionName = actionName;
		this.annotation = annotation;
		this.imagePatch = imagePatch;
		this.address = address;
		this.startDate = startDate;
		this.maxPosition = maxPosition;
		this.cost = cost;
		this.soldPosition = 0;
		this.tickets = new ArrayList<Ticket>();
	}

	public Action(long idAction, String actionName, String annotation,
			String address, Date startDate, int maxPosition,
			List<Ticket> tickets) {
		super();
		this.idAction = idAction;
		this.actionName = actionName;
		this.annotation = annotation;
		this.address = address;
		this.startDate = startDate;
		this.maxPosition = maxPosition;
		this.soldPosition = tickets.size();
		this.tickets = tickets;
	}

	public Action() {
		this.idAction = 0;
		this.actionName = "";
		this.annotation = "";
		this.address = "";
		this.startDate = new Date();
		this.maxPosition = 0;
		this.soldPosition = 0;
		this.tickets = new ArrayList<Ticket>();
	}

	public String getImagePatch() {
		return this.imagePatch;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setImagePatch(String imagePatch) {
		this.imagePatch = imagePatch;
	}

	public long getIdAction() {
		return this.idAction;
	}

	public String getActionName() {
		return this.actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getAnnotation() {
		return this.annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMaxPosition() {
		return this.maxPosition;
	}

	public void setMaxPosition(int maxPosition) {
		this.maxPosition = maxPosition;
	}

	public int getSoldPosition() {
		return this.soldPosition;
	}

	public void setSoldPosition(int soldPosition) {
		this.soldPosition = soldPosition;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getTicketPosition(long id) throws Exception {
		for (Ticket ticket : this.tickets) {
			if (ticket.getIdTicket() == id) {
				return ticket.getPosition();
			}
		}
		throw new Exception(); // TODO
	}

	public List<Ticket> getTickets() throws EOFException {
		return this.tickets;
	}

	public boolean addTickets(Ticket tickets) {
		for (Ticket arg : this.tickets) {
			if (arg.getPosition() == tickets.getPosition()) {
				return false;
			}
		}
		if (this.soldPosition == this.maxPosition) {
			return false;
		}
		this.soldPosition++;
		return this.tickets.add(tickets);
	}

	@Override
	public String toString() {
		String str;
		try {
			str = "Action [idAction = " + idAction + ", \nactionName = "
					+ actionName + ", \nannotation = " + annotation
					+ ", \naddress = " + address + ", \nmaxPosition = "
					+ maxPosition + ", \nsoldPosition = " + soldPosition
					+ ", \nstartDate = " + startDate + ", \ntickets =\n"
					+ getTickets() + "]\n";
		} catch (EOFException e) {
			e.printStackTrace();
			str = "Action [idAction = " + idAction + ", \nactionName = "
					+ actionName + ", \nannotation = " + annotation
					+ ", \naddress = " + address + ", \nmaxPosition = "
					+ maxPosition + ", \nsoldPosition = " + soldPosition
					+ ", \nstartDate = " + startDate + ", \ntickets = empty]\n";
		}
		return str;
	}

}
