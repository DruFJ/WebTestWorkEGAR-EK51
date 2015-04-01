package dao;

import java.util.Date;

public class TicketInformation {
	private int position;
	private Date dateSold;

	public TicketInformation(int position, Date dateSold) {
		super();
		this.position = position;
		this.dateSold = dateSold;
	}

	public TicketInformation() {
		super();
		this.position = 0;
		this.dateSold = new Date();
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Date getDateSold() {
		return dateSold;
	}

	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}	
}
