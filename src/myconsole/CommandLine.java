package myconsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandLine implements ObserverInterface {
	String view;
	Scanner input;
	String command;
	String option;

	CommandBuilder commandBuilder;
	CommandHandler commandHandler;

	public CommandLine(CommandBuilder commandBuilder) {
		this.commandBuilder = commandBuilder;
		commandHandler = new CommandHandler(commandBuilder.getCommandMap());
	}

	public void initCli() {
		addAllObservable();
		input = new Scanner(System.in);
		while (true) {
			System.out.print("[MyShell] " + view);
			readCommandLine();
			commandHandler.handleCommand(command, option);
			command = null;
			option = null;
		}
	}

	@Override
	public void actualize(String state) {
		view = state;
	}

	// private void addObservable() {
	// ObservableInterface ob = (ObservableInterface)
	// commandBuilder.getSpecialObject("prompt");
	// ob.addObserver(this);
	// }
	private void addAllObservable() {
		List<ObservableInterface> list = commandBuilder.getObservableObjects();
		for (ObservableInterface item : list) {
			item.addObserver(this);
		}
	}

	private void readCommandLine() {
		List<String> s = new ArrayList<String>(Arrays.asList(input.nextLine().split("\\s")));
		if (s.size() == 1) {
			command = s.get(0);
		} else if (s.size() == 2) {
			command = s.get(0);
			option = s.get(1);
		} else {
			System.out.println("To much parameters");
		}
	}
}
