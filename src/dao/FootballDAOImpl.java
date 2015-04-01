package dao;

import java.util.ArrayList;
import java.util.List;

import beans.actions.Action;
import beans.actions.Football;

public class FootballDAOImpl implements FootballDAO {

	@Override
	public List<Action> getFootball() {
		List<Action> actions = new ArrayList<Action>();
		actions.addAll(FileWork.readActions());
		List<Action> test = new ArrayList<Action>();
		for (Action arg : actions) {
			if (arg.getClass().equals(Football.class)) {
				test.add(arg);
			}
		}
		return test;
	}

}
