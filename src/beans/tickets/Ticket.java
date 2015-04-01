package beans.tickets;

import java.util.Date;

public class Ticket implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idTicket;
	private long idAction;
	private Date dateSold;
	private int position;
	private int costTicket;
	private User user;

	private class User implements java.io.Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String firstName;
		private String lastName;
		private String email;

		public User(String firstName, String lastName, String email) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "User \n[firstName = " + firstName + ", \nlastName = "
					+ lastName + ", \nemail = " + email + "]\n";
		}
	}

	public Ticket(long idTicket, long idAction, Date dateSold, int position,
			int costTicket, String firstName, String lastName, String email) {
		super();
		this.idTicket = idTicket;
		this.idAction = idAction;
		this.dateSold = dateSold;
		this.position = position;
		this.costTicket = costTicket;
		this.user = new User(firstName, lastName, email);
	}

	public long getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(long idTicket) {
		this.idTicket = idTicket;
	}

	public long getIdAction() {
		return this.idAction;
	}

	public void setIdAction(long idAction) {
		this.idAction = idAction;
	}

	public Date getDateSold() {
		return this.dateSold;
	}

	public void setDateSold(Date dateSold) {
		this.dateSold = dateSold;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getCostTicket() {
		return this.costTicket;
	}

	public void setCostTicket(int costTicket) {
		this.costTicket = costTicket;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket = " + idTicket + ", \nidAction = " + idAction
				+ ", \ndateSold = " + dateSold + ", \nposition = " + position
				+ ", \ncostTicket = " + costTicket + ", \nuser = " + user
				+ "]\n";
	}

}
