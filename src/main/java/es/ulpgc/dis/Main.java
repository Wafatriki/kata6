package es.ulpgc.dis;

import es.ulpgc.dis.control.CommandFactory;
import es.ulpgc.dis.control.commands.WorkingDateCommand;
import es.ulpgc.dis.control.commands.WorkingDaysCommand;
import io.javalin.Javalin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import es.ulpgc.dis.view.adapters.WorkingDateRequestAdapter;
import es.ulpgc.dis.view.adapters.WorkingDaysRequestAdapter;

public class Main {

	public static void main(String[] args) {
		CommandFactory factory = new CommandFactory();
		factory.register("working-days", workingDaysBuilder());
		factory.register("working-date", workingDateBuilder());

		Javalin app = Javalin.create().start(7070);
		app.get("/", ctx -> ctx.result("Welcome to the Working Days Service!"));
		app.get("/working-days", ctx -> execute("working-days", ctx.req(), ctx.res()));
		app.get("/working-date", ctx -> execute("working-date", ctx.req(), ctx.res()));
	}

	private static CommandFactory.Builder workingDateBuilder() {
		return (req, res) -> {
			WorkingDateRequestAdapter adapter = new WorkingDateRequestAdapter();
			return new WorkingDateCommand(adapter.inputFor(req), adapter.outputFor(res));
		};
	}

	private static CommandFactory.Builder workingDaysBuilder() {
		return (req, res) -> {
			WorkingDaysRequestAdapter adapter = new WorkingDaysRequestAdapter();
			return new WorkingDaysCommand(adapter.inputFor(req), adapter.outputFor(res));
		};
	}

	private static void execute(String command, HttpServletRequest req, HttpServletResponse res) {
		CommandFactory factory = new CommandFactory();
		factory.with(req, res).build(command).execute();
	}
}
