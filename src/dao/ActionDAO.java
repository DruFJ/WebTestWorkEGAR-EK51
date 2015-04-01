package dao;

import java.util.ArrayList;
import java.util.List;

import beans.actions.Action;

public interface ActionDAO {
	public enum ActionType {
		FILM, CONCET, THEATER, FOOTBALL, ACTIONS
	}

	public void addActions(ArrayList<Action> actions);

	public void addAction(Action action);

	public List<Action> getActions();

	public List<Action> getTypeAction(ActionType type);

	public Action getAction(long id);
}
