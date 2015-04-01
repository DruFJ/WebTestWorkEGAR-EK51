package dao;

import java.util.ArrayList;
import java.util.List;

import beans.actions.Action;

public class ActionDAOImpl implements ActionDAO {

	@Override
	public void addActions(ArrayList<Action> actions) {
		FileWork.writeActions(actions);
	}

	@Override
	public void addAction(Action action) {
		List<Action> actions1 = new ArrayList<Action>();
		actions1.add(action);
		FileWork.writeActions(actions1);

	}

	@Override
	public List<Action> getActions() {
		List<Action> actions = new ArrayList<Action>();
		actions.addAll(FileWork.readActions());
		return actions;
	}

	@Override
	public List<Action> getTypeAction(ActionType type) {
		List<Action> actions = new ArrayList<Action>();
		switch (type) {
		case FILM: {
			FilmDAO film = new FilmDAOImpl();
			actions.addAll(film.getFilms());
			break;
		}
		case CONCET: {
			ConcertDAO concert = new ConcertDAOImpl();
			actions.addAll(concert.getConcert());
			break;
		}
		case THEATER: {
			TheaterDAO theater = new TheaterDAOImpl();
			actions.addAll(theater.getTheater());
			break;
		}
		case FOOTBALL: {
			FootballDAO football = new FootballDAOImpl();
			actions.addAll(football.getFootball());
			break;
		}
		default: {
			ActionDAO action = new ActionDAOImpl();
			actions.addAll(action.getActions());
			break;
		}
		}
		return actions;
	}

	@Override
	public Action getAction(long id) {
		List<Action> actions = new ArrayList<Action>();
		actions.addAll(FileWork.readActions());
		Action action = new Action();
		for (Action arg : actions) {
			if (arg.getIdAction() == id) {
				action = arg;
			}
		}
		return action;
	}
}
