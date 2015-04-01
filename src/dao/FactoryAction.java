package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.actions.Action;
import beans.actions.Concert;
import beans.actions.Film;
import beans.actions.Football;
import beans.actions.Theater;
import beans.tickets.Ticket;

public class FactoryAction {
	public static void createTicket(long idAction, Date dateSold, int position,
			int costTicket, String firstName, String lastName, String email)
			throws Exception {
		Ticket ticket = new Ticket(FileWork.readLastIdTicket(), idAction,
				dateSold, position, costTicket, firstName, lastName, email);
		ActionDAO act = new ActionDAOImpl();
		Action action = act.getAction(idAction);
		action.addTickets(ticket);
		FileWork.writeAction(action);
	}

	public static Action createAction(String actionName, String annotation,
			String imagePatch, String address, Date startDate, int maxPosition,
			int cost) {
		Action action = new Action(FileWork.readLastIdAction(), actionName,
				annotation, imagePatch, address, startDate, maxPosition, cost);
		return action;
	}

	public static Action createFilm(String actionName, String annotation,
			String imagePatch, String address, Date startDate, int maxPosition,
			int cost, int[] rowsCapasityQuantity, Film.TypeFilm typeFilm) {
		Film action = new Film(FileWork.readLastIdAction(), actionName,
				annotation, "films/" + imagePatch, address, startDate,
				maxPosition, cost, rowsCapasityQuantity, typeFilm);
		return action;
	}

	public static Action createConcert(String actionName, String annotation,
			String imagePatch, String address, Date startDate, int maxPosition,
			int cost) {
		Concert action = new Concert(FileWork.readLastIdAction(), actionName,
				annotation, "concert/" + imagePatch, address, startDate,
				maxPosition, cost);
		return action;
	}

	public static Action createFootball(String actionName, String annotation,
			String imagePatch, String address, Date startDate, int maxPosition,
			int cost, int[][] sectorQuantity) {
		Football action = new Football(FileWork.readLastIdAction(), actionName,
				annotation, "football/" + imagePatch, address, startDate,
				maxPosition, cost, sectorQuantity);
		return action;
	}

	public static Action createTheater(String actionName, String annotation,
			String imagePatch, String address, Date startDate, int maxPosition,
			int cost, int[] rowsCapasityQuantity) {
		Theater action = new Theater(FileWork.readLastIdAction(), actionName,
				annotation, "theater/" + imagePatch, address, startDate,
				maxPosition, cost, rowsCapasityQuantity);
		return action;
	}

	@SuppressWarnings("deprecation")
	public List<Action> createSeance(Action action, int[] Hours) {
		List<Action> actions = new ArrayList<Action>();
		Date date = new Date();
		date = action.getStartDate();
		for (int tmp : Hours) {
			date.setHours(tmp);
			action.setStartDate(date);
		}
		return actions;
	}
}
