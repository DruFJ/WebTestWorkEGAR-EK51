package dao;

import java.util.ArrayList;
import java.util.List;

import beans.actions.Action;
import beans.actions.Film;

public class FilmDAOImpl implements FilmDAO {
	public List<Action> getFilms() {
		List<Action> actions = new ArrayList<Action>();
		actions.addAll(FileWork.readActions());
		List<Action> test = new ArrayList<Action>();
		for (Action arg : actions) {
			if (arg.getClass().equals(Film.class)) {
				test.add(arg);
			}
		}
		return test;
	}
}
