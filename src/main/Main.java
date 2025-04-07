package main;

import java.text.ParseException;

import model.Task;

public class Main {
	public static void main(String[] args) {
		try {
			Task task = new Task("Estudos Java", "Estudos de java para ser um desenvolvedor java.");
			System.out.println(task);
			System.out.println("---------------------------------------------------------");
			task.statusChange();
			System.out.println(task);
			System.out.println("---------------------------------------------------------");
			task.statusChange();
			System.out.println(task);
		} catch(ParseException e) {
			System.err.println(e.getMessage());
		}
	}
}
