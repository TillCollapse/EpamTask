package myconsole;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandBuilder {
	private Map<String, Command> commandMap;

	public CommandBuilder() {
		commandMap = new HashMap<String, Command>();
		initCommandMap();
	}
	public CommandBuilder(File path) {
		commandMap = new HashMap<String, Command>();
		initCommandMap(path);
	}

	private void initCommandMap() {
		try {
			commandMap.put("prompt", new PromptCommand());
			commandMap.put("dir", new DirCommand());
			commandMap.put("tree", new TreeCommand());
			commandMap.put("cd", new CdCommand());
			commandMap.put("exit", new ExitCommand());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initCommandMap(File path) {
		try {
			commandMap.put("prompt", new PromptCommand(path));
			commandMap.put("dir", new DirCommand(path));
			commandMap.put("tree", new TreeCommand(path));
			commandMap.put("cd", new CdCommand(path));
			commandMap.put("exit", new ExitCommand(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, Command> getCommandMap() {
		return commandMap;
	}

	public List<ObservableInterface> getObservableObjects() {
		List<ObservableInterface> observables = new ArrayList<ObservableInterface>();
		for (Command item : commandMap.values()) {
			if (item instanceof ObservableInterface) {
				observables.add((ObservableInterface) item);
			}
		}
		return observables;
	}

	public Command getSpecialObject(String name) {
		return commandMap.get(name);
	}

}
