package es.ulpgc.dis.control.commands;

import es.ulpgc.dis.control.Command;
import es.ulpgc.dis.model.Calendar;

import java.time.LocalDate;
import java.util.Iterator;

public class WorkingDateCommand implements Command {
	private final Input input;
	private final Output output;

	public WorkingDateCommand(Input input, Output output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public void execute() {
		output.result(nextWorkingDate());
	}

	private LocalDate nextWorkingDate() {
		Iterator<LocalDate> iterator = new Calendar().iteratorFrom(input.start());
		LocalDate result = null;
		for (int i = 0; i < input.workingDays(); i++) result = iterator.next();
		return result;
	}

	public interface Input {
		LocalDate start();

		int workingDays();
	}

	public interface Output {
		void result(LocalDate result);
	}
}
