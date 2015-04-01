package servlets;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

import servlets.commands.Command;
import servlets.commands.CreateEvent;
import servlets.commands.ViewDateObjectCommand;
import servlets.commands.ViewFilmsCommand;
import servlets.commands.ViewObjectCommand;
import servlets.commands.ViewTicketCommand;

public class RequestHelper {
	private static RequestHelper instance = null;

	HashMap<String, Command> commands = new HashMap<String, Command>();

	private RequestHelper() {
		commands.put("viewFilms", new ViewFilmsCommand());
		commands.put("viewObject", new ViewObjectCommand());
		commands.put("viewDateObject", new ViewDateObjectCommand());
		commands.put("viewTicket", new ViewTicketCommand());
		commands.put("createEvent", new CreateEvent());
	}

	public Command getCommand(HttpServletRequest request) {
		String action = request.getParameter("command");
		Command command = commands.get(action);
		if (command == null) {
			System.out.println("this command not exists");
		}
		return command;
	}

	public static RequestHelper getInstance() {
		if (instance == null) {
			instance = new RequestHelper();
		}
		return instance;
	}

}
