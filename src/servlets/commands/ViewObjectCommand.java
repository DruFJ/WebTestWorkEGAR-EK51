package servlets.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GeneralInformationDAOImplObject;

public class ViewObjectCommand implements Command {
	private static String PARAMETER_ID = "id";
	private static String PARAMETER_TYPE = "type";

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) {

		GeneralInformationDAOImplObject inf = new GeneralInformationDAOImplObject();
		long id = Long.valueOf(request.getParameter(PARAMETER_ID));
		String type = request.getParameter(PARAMETER_TYPE);
		request.setAttribute("type",type);
		
		try {
			request.setAttribute("action", inf.getInformation(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/DateAndTime.jsp";
	}

}
