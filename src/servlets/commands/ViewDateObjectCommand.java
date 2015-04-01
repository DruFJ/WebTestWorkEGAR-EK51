package servlets.commands;

import java.io.EOFException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.actions.Action;

import dao.GeneralInformationDAOImplObject;

import dao.ActionDAO;
import dao.ActionDAOImpl;
import dao.TicketInformationDAO;
import dao.TicketInformationDAOImpl;

public class ViewDateObjectCommand implements Command{
	private static String PARAMETER_ID = "id";
	private static String PARAMETER_TYPE = "type";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		GeneralInformationDAOImplObject inf = new GeneralInformationDAOImplObject();
		TicketInformationDAO infTicket = new TicketInformationDAOImpl();
		long id = Long.valueOf(request.getParameter(PARAMETER_ID));
		String type = request.getParameter(PARAMETER_TYPE);
		String url = " ";
		int number = 0;
		
		ActionDAO action = new ActionDAOImpl();
		Action list = action.getAction(id);
		try {
			number = list.getMaxPosition() - list.getTickets().size();
		} catch (EOFException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setAttribute("type",type);
		request.setAttribute("number",number);
		
		try {
			request.setAttribute("action", inf.getInformation(id));
			request.setAttribute("ticket", infTicket.getInformation(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		switch (type) {
		case "FILM": {
			url = "/BuyTicketsFilm.jsp";
			break;
		}
		case "CONCET": {
			url = "/BuyTicketConcert.jsp";
			break;
		}
		case "THEATER": {
			url = "/BuyTicketsFilm.jsp";
			break;
		}
		case "FOOTBALL": {
			url = "/BuyTicketsFilm.jsp";
			break;
		}
		default: {
			url = "/TheMain.jsp";
			break;
		}
	}
		
		return url;
	}

}
