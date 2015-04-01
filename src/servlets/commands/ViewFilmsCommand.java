package servlets.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GeneralInfomationDAOImpl;
import dao.GeneralInformationDAO;
import dao.ActionDAO;

public class ViewFilmsCommand implements Command {
	private static String PARAMETER_TYPE = "type";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		GeneralInformationDAO inf = new GeneralInfomationDAOImpl();
		String type = request.getParameter(PARAMETER_TYPE);
		request.setAttribute("type",type);
		request.setAttribute("films",
				inf.getInformation(ActionDAO.ActionType.valueOf(type)));

		return "/Action.jsp";
	}

}
