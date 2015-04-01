package dao;

import java.util.ArrayList;
import java.util.List;

import beans.actions.Action;
import beans.actions.Concert;

public class ConcertDAOImpl implements ConcertDAO {

	@Override
	public List<Action> getConcert() {
		List<Action> actions = new ArrayList<Action>();
		actions.addAll(FileWork.readActions());
		List<Action> test = new ArrayList<Action>();
		for (Action arg : actions) {
			if (arg.getClass().equals(Concert.class)) {
				test.add(arg);
			}
		}
		return test;
	}

}
