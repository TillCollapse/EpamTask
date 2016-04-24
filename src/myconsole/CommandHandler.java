package myconsole;

import java.util.Map;

public class CommandHandler {
	private Map<String, Command> commandMap;

	public CommandHandler(Map<String, Command> commandMap) {
		this.commandMap = commandMap;

	}

	public void handleCommand(String com, String option) {
		Command command = commandMap.get(com);
		if (command != null) {
			if (option != null) {
				command.execute(option);
			} else {
				command.execute();
			}
		} else {
			System.out.println(com + " : " + "unknown command");
		}
	}
}
