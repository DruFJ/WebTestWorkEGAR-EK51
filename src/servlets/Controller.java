package servlets;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;

import servlets.commands.Command;

@MultipartConfig
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RequestHelper requestHelper = RequestHelper.getInstance();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String page = null;
			Command command = requestHelper.getCommand(request);
			page = command.execute(request, response);
			if (page == null) {
			} else {
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(page);
				dispatcher.forward(request, response);
			}
		} catch (ServletException e) {
		} catch (IOException e) {
		}

	}
}
