package servlets.commands;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ActionDAOImpl;
import dao.FactoryAction;
import dao.ActionDAO;

import beans.actions.Action;
import beans.actions.Film;

public class CreateEvent implements Command {
	private static String PARAMETER_NAME = "name";
	private static String PARAMETER_ANOTATION = "annotation";
	private static String PARAMETER_ADRESS = "adress";
	private static String PARAMETER_IMAGE = "image";
	private static String PARAMETER_NUMBER = "number";
	private static String PARAMETER_MOUNTH = "mounth";
	private static String PARAMETER_YEAR = "year";
	private static String PARAMETER_HOUR = "hour";
	private static String PARAMETER_MINUTE = "minute";
	private static String PARAMETER_PLACES = "places";
	private static String PARAMETER_COST = "cost";

	@SuppressWarnings("deprecation")
	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String name = request.getParameter(PARAMETER_NAME);
		String annotation = request.getParameter(PARAMETER_ANOTATION);
		String adress = request.getParameter(PARAMETER_ADRESS);
		String image = request.getParameter(PARAMETER_IMAGE);
		int number = Integer.valueOf(request.getParameter(PARAMETER_NUMBER));
		int mounth = Integer.valueOf(request.getParameter(PARAMETER_MOUNTH));
		int year = Integer.valueOf(request.getParameter(PARAMETER_YEAR));
		int hour = Integer.valueOf(request.getParameter(PARAMETER_HOUR));
		int minute = Integer.valueOf(request.getParameter(PARAMETER_MINUTE));
		int places = Integer.valueOf(request.getParameter(PARAMETER_PLACES));
		int cost = Integer.valueOf(request.getParameter(PARAMETER_COST));
		String type = request.getParameter("type");

		Date date = new Date();
		date.setDate(number);
		date.setMonth(mounth);
		date.setYear(year - 1900);
		date.setHours(hour);
		date.setMinutes(minute);
		date.setSeconds(0);

		Action action;
		switch (request.getParameter("answer")) {
		case "film": {
			int rows = (int) Math.sqrt(places);
			int[] rowsCapasityQuantity = new int[rows];
			for (int i = 0; i < rows; ++i) {
				rowsCapasityQuantity[i] = (int) (places / rows);
			}
			Film.TypeFilm typeb = Film.TypeFilm.valueOf(type);
			action = FactoryAction.createFilm(name, annotation, image, adress,
					date, places, cost, rowsCapasityQuantity, typeb);
			break;
		}
		case "theater": {
			int rows = (int) Math.sqrt(places);
			int[] rowsCapasityQuantity = new int[rows];
			for (int i = 0; i < rows; ++i) {
				rowsCapasityQuantity[i] = (int) (places / rows);
			}
			action = FactoryAction.createTheater(name, annotation, image,
					adress, date, places, cost, rowsCapasityQuantity);
			break;
		}
		case "conzert": {
			action = FactoryAction.createConcert(name, annotation, image,
					adress, date, places, cost);
			break;
		}
		case "football": {
			int rows = (int) (Math.sqrt(places) / 2);
			int[][] sectorQuantity = new int[2][rows];
			for (int i = 0; i < 2; ++i) {
				for (int j = 0; j < rows; ++j) {
					sectorQuantity[i][j] = (int) (places / (rows * 2));
				}
			}
			action = FactoryAction.createFootball(name, annotation, image,
					adress, date, places, cost, sectorQuantity);
			break;
		}
		default: {
			action = FactoryAction.createAction(name, annotation, image,
					adress, date, places, cost);
			break;
		}
		}
		ActionDAO act = new ActionDAOImpl();
		act.addAction(action);

		return "/TheMain.jsp";
	}

}
