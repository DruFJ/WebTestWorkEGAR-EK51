package servlets.commands;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FactoryAction;
import dao.SendEmail;

public class ViewTicketCommand implements Command {
	private static String PARAMETER_LAST_NAME = "last_name";
	private static String PARAMETER_FIRST_NAME = "first_name";
	private static String PARAMETER_E_MAIL = "e_mail";
	private static String PARAMETER_PLACE = "place";
	private static String PARAMETER_IDACTION = "idAction";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {
		String lastName = request.getParameter(PARAMETER_LAST_NAME);
		String firstName = request.getParameter(PARAMETER_FIRST_NAME);
		String email = request.getParameter(PARAMETER_E_MAIL);
		int place = Integer.valueOf(request.getParameter(PARAMETER_PLACE));
		long idAction = Long.valueOf(request.getParameter(PARAMETER_IDACTION));

		Date dateSold = new Date();
		try {
			FactoryAction.createTicket(idAction, dateSold, place, 1000,
					firstName, lastName, email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("id", idAction);
		
		//Отправка письма на почту
		/*SendEmail mes = new SendEmail("sevgen87@gmail.com", "");
		
		mes.send("This is Subject", "SSL: This is text!", "sevgen87@gmail.com", "sel_evgen@mail.ru");*/
		
		return "/TheMain.jsp";
	}

}

