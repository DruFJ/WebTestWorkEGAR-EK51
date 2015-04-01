package dao;

import java.util.ArrayList;
import java.util.List;

import beans.actions.Action;
import beans.actions.Theater;

public class TheaterDAOImpl implements TheaterDAO {

	@Override
	public List<Action> getTheater() {
		List<Action> actions = new ArrayList<Action>();
		actions.addAll(FileWork.readActions());
		List<Action> test = new ArrayList<Action>();
		for (Action arg : actions) {
			if (arg.getClass().equals(Theater.class)) {
				test.add(arg);
			}
		}
		return test;
	}
}
