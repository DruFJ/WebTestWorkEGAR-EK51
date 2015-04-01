package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.actions.Action;

public class FileWork {
	private static File actions;
	private static File lastId;

	public static long readLastIdAction() {
		lastId = new File("lastId.txt");
		long idAction = 0;
		long idTicket = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(lastId));
			idAction = Long.valueOf(br.readLine());
			idTicket = Long.valueOf(br.readLine());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writeLastId(idAction + 1, idTicket);
		return idAction;
	}

	public static long readLastIdTicket() {
		lastId = new File("lastId.txt");
		long idAction = 0;
		long idTicket = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(lastId));
			idAction = Long.valueOf(br.readLine());
			idTicket = Long.valueOf(br.readLine());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writeLastId(idAction, idTicket + 1);
		return idTicket;
	}

	private static void writeLastId(long idAction, long idTicket) {
		lastId = new File("lastId.txt");
		lastId.delete();
		FileWriter fw = null;
		try {
			fw = new FileWriter(lastId, true);
		} catch (IOException e) {
			System.err.println("ошибка открытия потока " + e);
			System.exit(1);
		}
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		pw.println(idAction);
		pw.println(idTicket);
		pw.close();
	}

	private static void reWriteLastId() {
		lastId = new File("lastId.txt");
		lastId.delete();
		FileWriter fw = null;
		try {
			fw = new FileWriter(lastId, true);
		} catch (IOException e) {
			System.err.println("ошибка открытия потока " + e);
			System.exit(1);
		}
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);

		pw.println(1);
		pw.println(1);
		pw.close();
	}

	public static void RemoveActions() {
		actions = new File("actions.dat");
		List<Action> collection = new ArrayList<Action>();
		actions.delete();
		reWriteLastId();
		try {
			ObjectOutputStream ostream = new ObjectOutputStream(
					new FileOutputStream(actions));
			ostream.writeObject(collection);
			ostream.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public static List<Action> removeOldAction(List<Action> actions) {
		Date date = new Date();
		for (int i = 0; i < actions.size(); i++) {
			if (actions.get(i).getStartDate().getTime() < date.getTime()) {
				actions.remove(i);
			}
		}
		return actions;
	}

	public static void writeAction(Action action) {
		actions = new File("actions.dat");
		List<Action> collection = new ArrayList<Action>();
		collection.addAll(readActions());
		for (int i = 0; i < collection.size(); i++) {
			if (action.getIdAction() == collection.get(i).getIdAction()) {
				collection.remove(i);
			}
		}
		collection.add(action);
		actions.delete();
		try {
			ObjectOutputStream ostream = new ObjectOutputStream(
					new FileOutputStream(actions));
			ostream.writeObject(collection);
			ostream.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public static void writeActions(List<Action> action) {
		actions = new File("actions.dat");
		List<Action> collection = new ArrayList<Action>();
		collection.addAll(readActions());
		collection.addAll(action);

		actions.delete();
		try {
			ObjectOutputStream ostream = new ObjectOutputStream(
					new FileOutputStream(actions));
			ostream.writeObject(collection);
			ostream.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public static List<Action> readActions() {
		actions = new File("D:\\WorkSpaceEclipse2\\WorkSpaceEclipse\\Test_Work\\" + "actions.dat");
		List<Action> unknown = new ArrayList<Action>();
		try {
			ObjectInputStream istream = new ObjectInputStream(
					new FileInputStream(actions));
			unknown = (ArrayList<Action>) istream.readObject();
			istream.close();
		} catch (ClassNotFoundException ce) {
			System.err.println(ce);
			System.err.println("Класс не существует");
		} catch (FileNotFoundException fe) {
			System.err.println(fe);
			System.err.println("Файл не найден");
		} catch (IOException ioe) {
			System.err.println(ioe);
			System.err.println("Ошибка доступа");
		}
		unknown = removeOldAction(unknown);
		return unknown;
	}
}
